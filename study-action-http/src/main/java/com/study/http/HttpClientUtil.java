/**
 * 
 * @author zhengxy
 * @Date 2018年9月27日 下午6:16:36
 * @version 1.0
 * 
 */
package com.study.http;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @ClassName: HttpClientUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhengxy
 * @date 2018年9月27日 下午6:16:36
 * 
 */
public class HttpClientUtil {
    private static Log log = org.apache.commons.logging.LogFactory.getLog(HttpClientUtil.class);
    
    /**
     * 
     * @Title: httpGet
     * @Description: 发送http get请求
     * @param url
     * @param headers
     * @param encode
     * @return
     */
    public static HttpResponse httpGet(String url, Map<String, String> headers, String encode) {
        HttpResponse response = new HttpResponse();
        if (encode == null) {
            encode = "utf-8";
        }
        String content = null;
        // since 4.3 不再使用 DefaultHttpClient
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        // 设置header
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = closeableHttpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);
            response.setBody(content);
            response.setHeaders(httpResponse.getAllHeaders());
            response.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try { // 关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        }
        return response;
    }
    
    /**
     * 
     * @Title: httpPostForm
     * @Description: 发送 http post 请求，参数以form表单键值对的形式提交。
     * @param url
     * @param params
     * @param headers
     * @param encode
     * @return
     */
    public static HttpResponse httpPostForm(String url, Map<String, String> params, Map<String, String> headers,
            String encode) {
        HttpResponse response = new HttpResponse();
        if (encode == null) {
            encode = "utf-8";
        }
        // HttpClients.createDefault()等价于 HttpClientBuilder.create().build();
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpost = new HttpPost(url);
        
        // 设置header
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        // 组织请求参数
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        if (params != null && params.size() > 0) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                paramList.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        try {
            httpost.setEntity(new UrlEncodedFormEntity(paramList, encode));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            log.error("" + e1.getMessage());
        }
        String content = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = closeableHttpClient.execute(httpost);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);
            response.setBody(content);
            response.setHeaders(httpResponse.getAllHeaders());
            response.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("" + e.getMessage());
            }
        }
        try { // 关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        }
        return response;
    }
    
    /**
     * 
     * @Title: httpPostRaw
     * @Description: 发送 http post 请求，参数以原生字符串进行提交
     * @param url
     * @param stringJson
     * @param headers
     * @param encode
     * @return
     */
    public static HttpResponse httpPostRaw(String url, String stringJson, Map<String, String> headers, String encode) {
        HttpResponse response = new HttpResponse();
        if (encode == null) {
            encode = "utf-8";
        }
        // HttpClients.createDefault()等价于 HttpClientBuilder.create().build();
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpost = new HttpPost(url);
        
        // 设置header
        httpost.setHeader("Content-type", "application/json");
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        // 组织请求参数
        StringEntity stringEntity = new StringEntity(stringJson, encode);
        httpost.setEntity(stringEntity);
        String content = null;
        CloseableHttpResponse httpResponse = null;
        try {
            // 响应信息
            httpResponse = closeableHttpClient.execute(httpost);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);
            response.setBody(content);
            response.setHeaders(httpResponse.getAllHeaders());
            response.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("" + e.getMessage());
            }
        }
        try { // 关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        }
        return response;
    }
    
    /**
     * 
     * @Title: httpPutRaw
     * @Description: 发送 http put 请求，参数以原生字符串进行提交
     * @param url
     * @param stringJson
     * @param headers
     * @param encode
     * @return
     */
    public static HttpResponse httpPutRaw(String url, String stringJson, Map<String, String> headers, String encode) {
        HttpResponse response = new HttpResponse();
        if (encode == null) {
            encode = "utf-8";
        }
        // HttpClients.createDefault()等价于 HttpClientBuilder.create().build();
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut(url);
        
        // 设置header
        httpput.setHeader("Content-type", "application/json");
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpput.setHeader(entry.getKey(), entry.getValue());
            }
        }
        // 组织请求参数
        StringEntity stringEntity = new StringEntity(stringJson, encode);
        httpput.setEntity(stringEntity);
        String content = null;
        CloseableHttpResponse httpResponse = null;
        try {
            // 响应信息
            httpResponse = closeableHttpClient.execute(httpput);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);
            response.setBody(content);
            response.setHeaders(httpResponse.getAllHeaders());
            response.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            closeableHttpClient.close(); // 关闭连接、释放资源
        } catch (IOException e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        }
        return response;
    }
    
    /**
     * 
     * @Title: httpDelete
     * @Description: 发送http delete请求
     * @param url
     * @param headers
     * @param encode
     * @return
     */
    public static HttpResponse httpDelete(String url, Map<String, String> headers, String encode) {
        HttpResponse response = new HttpResponse();
        if (encode == null) {
            encode = "utf-8";
        }
        String content = null;
        // since 4.3 不再使用 DefaultHttpClient
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpDelete httpdelete = new HttpDelete(url);
        // 设置header
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpdelete.setHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = closeableHttpClient.execute(httpdelete);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);
            response.setBody(content);
            response.setHeaders(httpResponse.getAllHeaders());
            response.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("" + e.getMessage());
            }
        }
        try { // 关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        }
        return response;
    }
    
    /**
     * 
     * @Title: httpPostFormMultipart
     * @Description: 发送 http post 请求，支持文件上传
     * @param url
     * @param params
     * @param files
     * @param headers
     * @param encode
     * @return
     */
    public static HttpResponse httpPostFormMultipart(String url, Map<String, String> params, List<File> files,
            Map<String, String> headers, String encode) {
        HttpResponse response = new HttpResponse();
        if (encode == null) {
            encode = "utf-8";
        }
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpost = new HttpPost(url);
        
        // 设置header
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        MultipartEntityBuilder mEntityBuilder = MultipartEntityBuilder.create();
        mEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        mEntityBuilder.setCharset(Charset.forName(encode));
        
        // 普通参数
        ContentType contentType = ContentType.create("text/plain", Charset.forName(encode));// 解决中文乱码
        if (params != null && params.size() > 0) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                mEntityBuilder.addTextBody(key, params.get(key), contentType);
            }
        }
        // 二进制参数
        if (files != null && files.size() > 0) {
            for (File file : files) {
                mEntityBuilder.addBinaryBody("file", file);
            }
        }
        httpost.setEntity(mEntityBuilder.build());
        String content = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = closeableHttpClient.execute(httpost);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);
            response.setBody(content);
            response.setHeaders(httpResponse.getAllHeaders());
            response.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("" + e.getMessage());
            }
        }
        try { // 关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("" + e.getMessage());
        }
        return response;
    }
    /*
     * 发送Get请求： HttpResponse httpGet(String url,Map<String,String>
     * headers,String encode) 发送Post请求，同表单Post提交 HttpResponse
     * httpPostForm(String url,Map<String,String> params, Map<String,String>
     * headers,String encode) 发送Post Raw请求 HttpResponse httpPostRaw(String
     * url,String stringJson,Map<String,String> headers, String encode) 发送Put
     * Raw请求 HttpResponse httpPutRaw(String url,String
     * stringJson,Map<String,String> headers, String encode) 发送Delete请求
     * HttpResponse httpDelete(String url,Map<String,String> headers,String
     * encode)
     * 
     * 说明： 1、since 4.3 不再使用 DefaultHttpClient 2、UrlEncodedFormEntity 与
     * StringEntity 区别 2.1、UrlEncodedFormEntity()的形式比较单一，只能是普通的键值对，局限性相对较大。
     * 2.2、而StringEntity()的形式比较自由，只要是字符串放进去，不论格式都可以。 3、以raw方式发送请求时，需指定 Content
     * type：httpost.setHeader("Content-type", "application/json"); 否则默认使用
     * Content type 'text/plain;charset=UTF-8'。
     */
}
