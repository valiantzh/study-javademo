package com.study.oss.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.study.oss.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 腾讯对象存储服务
 * @author valiantzh
 * @version 1.0
 */
public class TencentStorage implements Storage {

    private static final Logger LOGGER = LoggerFactory.getLogger(TencentStorage.class);
    private String secretId;
    private String secretKey;
    private String region;
    private String bucketName;

    private COSClient cosClient;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public TencentStorage(){
    }

    private COSClient getCOSClient() {
        synchronized (this){
            if (cosClient == null) {
                // 1 初始化用户身份信息(secretId, secretKey)
                COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
                // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
                ClientConfig clientConfig = new ClientConfig(new Region(region));
                cosClient = new COSClient(cred, clientConfig);
            }
        }

        return cosClient;
    }

    private String getBaseUrl() {
        return "https://" + bucketName + ".cos-website." + region + ".myqcloud.com/";
    }

    /**
     * 创建Bucket
     * Bucket 是有限的资源，Bucket 不等同于目录，且 Bucket 下的文件数量无限，建议不要创建大量的 Bucket。
     * @param bucketName 的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
     */
    public void createBucket(String bucketName){
        try {
            Bucket bucket = cosClient.createBucket(bucketName);
        } catch (CosServiceException cse) {
            //服务端处理为失败的原因,如没有权限，
            LOGGER.error("create bucket failed.", cse);
        } catch (CosClientException cle){
            //一些客户端异常，如网络异常，发送请求失败
            LOGGER.error("create bucket failed.", cle);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 删除已清空的 Bucket
     * @param bucketName
     */
    public void deleteBucket(String bucketName){
        try {
            cosClient.deleteBucket(bucketName);
        } catch (CosServiceException cse) {
            //服务端处理为失败的原因,如没有权限
            LOGGER.error("delete bucket failed.", cse);
        } catch (CosClientException cle){
            //一些客户端异常，如网络异常，发送请求失败
            LOGGER.error("delete bucket failed.", cle);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 查询一个 Bucket 是否存在
     * @param bucketName
     * @return
     */
    public boolean doesBucketExist(String bucketName){
        return cosClient.doesBucketExist(bucketName);
    }

    @Override
    public void store(InputStream inputStream, long contentLength, String contentType, String keyName) {
        try {
            // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(contentLength);
            objectMetadata.setContentType(contentType);
            // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, keyName, inputStream, objectMetadata);
            PutObjectResult putObjectResult = getCOSClient().putObject(putObjectRequest);
            String etag = putObjectResult.getETag();  // 获取文件的 etag
            LOGGER.debug("key={}, etag={}",keyName,etag);
        } catch (CosServiceException cse) {
            //服务端处理为失败的原因,如没有权限，访问一个不存在的文件
            LOGGER.error("store object failed.", cse);
        } catch (CosClientException cle){
            //一些客户端异常，如网络异常，发送请求失败
            LOGGER.error("store object failed.", cle);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String keyName) {
        return null;
    }

    @Override
    public void load(String keyName, File downFile){
        try {
            GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, keyName);
            ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
        } catch (CosServiceException cse) {
            //服务端处理为失败的原因,如没有权限，访问一个不存在的文件
            LOGGER.error("load object failed.", cse);
        } catch (CosClientException cle){
            //一些客户端异常，如网络异常，发送请求失败
            LOGGER.error("load object failed.", cle);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Override
    public void delete(String keyName) {
        try {
            getCOSClient().deleteObject(bucketName, keyName);
        } catch (CosServiceException cse) {
            //服务端处理为失败的原因,如没有权限，访问一个不存在的文件
            LOGGER.error("del object failed.", cse);
        } catch (CosClientException cle){
            //一些客户端异常，如网络异常，发送请求失败
            LOGGER.error("del object failed.", cle);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String generateUrl(String keyName) {
        return getBaseUrl() + keyName;
    }

    public void download(String keyName, File downFile){
        try {
            GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, keyName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
