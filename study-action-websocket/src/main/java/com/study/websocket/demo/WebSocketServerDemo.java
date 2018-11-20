/**
 * 
 * File: MyWebSocketServer.java <br/>
 * Package: com.study.websocket.server <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月12日 上午9:35:36
 * @version 1.0
 * 
 */
package com.study.websocket.demo;

import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhengxy
 * @date 2018年10月12日 上午9:35:36
 * 
 */
@ServerEndpoint("/websocket/{username}")
public class WebSocketServerDemo {
    private static Logger log = LoggerFactory.getLogger(WebSocketServerDemo.class);
    
    private static int onlineCount = 0;
    private static Map<String, WebSocketServerDemo> clients = new ConcurrentHashMap<String, WebSocketServerDemo>();
    
    private Session    session;
    private String     username;
    
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException {
        
        this.username = username;
        this.session = session;
        
        addOnlineCount();
        clients.put(username, this);
        log.info("onOpen=>" + username+",onlineCount="+getOnlineCount());
    }
    
    @OnClose
    public void onClose() throws IOException {
        clients.remove(username);
        subOnlineCount();
        log.info("onClose=>" + username+",onlineCount="+getOnlineCount());
    }
    
    @OnMessage
    public void onMessage(String message) throws IOException {
        log.info("onMessage=>" + username+",message="+message);
        /*JSONObject jsonTo = JSONObject.parseObject(message);
        
        if (!jsonTo.get("To").equals("All")) {
            sendMessageTo("给一个人", jsonTo.get("To").toString());
        } else {
            sendMessageAll("给所有人");
        }*/
        sendMessageAll("给所有人:"+message);
    }
    
    @OnError
    public void onError(Session session, Throwable t) {
        // error.printStackTrace();
        // Most likely cause is a user closing their browser. Check to see if
        // the root cause is EOF and if it is ignore it.
        // Protect against infinite loops.
        int count = 0;
        Throwable root = t;
        while (root.getCause() != null && count < 20) {
            root = root.getCause();
            count++;
        }
        
        if (root instanceof EOFException) {
            // Assume this is triggered by the user closing their browser and
            // ignore it.
            log.error("[webSocket onError0] " + t.getMessage());
        } else if (root instanceof IOException) {
            log.error("[webSocket onError1] " + t.getMessage());
        } else {
            // throw t;
            // t.printStackTrace();
            log.error("[webSocket onError2]= " + t.getClass().getName() + "," + t.getMessage());
        }
    }
    
    public void sendMessageTo(String message, String To) throws IOException {
        log.info("sendMessageTo=>onlineCount="+getOnlineCount() + To+",message="+message);
        // session.getBasicRemote().sendText(message);
        // session.getAsyncRemote().sendText(message);
        for (WebSocketServerDemo item : clients.values()) {
            if (item.username.equals(To))
                item.session.getAsyncRemote().sendText(message);
        }
    }
    
    public void sendMessageAll(String message) throws IOException {
        log.info("sendMessageAll=>onlineCount="+getOnlineCount() +",message="+message);
        for (WebSocketServerDemo item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }
    
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
    
    public static synchronized void addOnlineCount() {
        WebSocketServerDemo.onlineCount++;
    }
    
    public static synchronized void subOnlineCount() {
        WebSocketServerDemo.onlineCount--;
    }
    
    public static synchronized Map<String, WebSocketServerDemo> getClients() {
        return clients;
    }
}
