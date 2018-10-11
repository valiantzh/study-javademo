/**
 * 
 * File: HttpResponse.java <br/>
 * @author zhengxy
 * @Date 2018年9月27日 下午6:23:45
 * @version 1.0
 * 
 */
package com.study.http;


import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;

import com.alibaba.fastjson.JSON;

/** 
 *  
 * @ClassName: HttpResponse  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author zhengxy
 * @date 2018年9月27日 下午6:23:45  
 *   
 */
@SuppressWarnings("unused")
public class HttpResponse{
    private int statusCode;
    private String body;
    private String reasonPhrase;
    private Header[] headers;
    /**  
     * @return statusCode  
     */
    public int getStatusCode() {
        return statusCode;
    }
    
    /**  
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    /**  
     * @return body  
     */
    public String getBody() {
        return body;
    }
    
    /**  
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }
    
    /**  
     * @return reasonPhrase  
     */
    public String getReasonPhrase() {
        return reasonPhrase;
    }
    
    /**  
     * @param reasonPhrase the reasonPhrase to set
     */
    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }
    
    /**  
     * @return headers  
     */
    public Header[] getHeaders() {
        return headers;
    }
    
    /**  
     * @param headers the headers to set
     */
    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }
}
