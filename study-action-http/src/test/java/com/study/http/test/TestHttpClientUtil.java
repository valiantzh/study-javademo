/**
 * 
 * File: TestHttpClientUtil.java <br/>
 * Package: com.study.http.test <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年9月28日 下午3:06:55
 * @version 1.0
 * 
 */
package com.study.http.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.study.http.HttpClientUtil;
import com.study.http.HttpResponse;

/**
 * 
 * @author zhengxy
 * @date 2018年9月28日 下午3:06:55
 * 
 */
public class TestHttpClientUtil {
    private static Logger log = LoggerFactory.getLogger(TestHttpClientUtil.class);
    
    private String              url    = "http://localhost:18080/api/v1/role/";
    private String              encode = "utf-8";
    private Map<String, String> headers;
    private int                 id     = 0;
    private HttpResponse        resp;
    
    @Before
    public void setUp() throws Exception {
        headers = new HashMap<String, String>();
    }
    @Test
    public void test() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGet() {
        url = "http://localhost:18080/api/v1/role/";
        if (id > 0) {
            url += id;
        }
        resp = HttpClientUtil.httpGet(url, headers, encode);
        //System.out.println(JSON.toJSONString(resp));
        log.info(JSON.toJSONString(resp));
    }
    
    @Test
    public void testDelete() {
        id = 0;
        testGet();
        url = "http://localhost:18080/api/v1/role/13";
        resp = HttpClientUtil.httpDelete(url, headers, encode);
        log.info(JSON.toJSONString(resp));
        testGet();
    }
    
    @Test
    public void testPut() {
        
        id = 0;
        testGet();
        String stringJson = "";
        resp = HttpClientUtil.httpPutRaw(url, stringJson, headers, encode);
        System.out.println(JSON.toJSONString(resp));
    }
    
}
