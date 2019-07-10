package com.study.oss.impl;

import com.study.oss.Storage;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class TencentStorageTest {

    private static final String OSS_SECRET_ID = "AKIDe690c4pI2WkiRu95nJbfV6TcXDfuohFY";
    private static final String OSS_SECRET_KEY = "FG2ZqseBSUHo68uRs8C3iBRUKxNZZMvH";
    private static final String OSS_REGION = "ap-shanghai";
    //private static final String OSS_BUCKET_NAME = "dcdzsoft-csp-1258955611";
    private static final String OSS_BUCKET_NAME = "demo-1258955611";
    private static final String OSS_FILE_KEY_DEMO = "demo/upload_single_demo.txt";
    private TencentStorage storage;
    @Before
    public void before() throws Exception {
        TencentStorage tencentStorage = new TencentStorage();
        tencentStorage.setSecretId(OSS_SECRET_ID);
        tencentStorage.setSecretKey(OSS_SECRET_KEY);
        tencentStorage.setRegion(OSS_REGION);
        tencentStorage.setBucketName(OSS_BUCKET_NAME);
        storage = tencentStorage;
    }

    @Test
    public void store() throws FileNotFoundException {
        // 指定要上传到 COS 上对象键
        String key = OSS_FILE_KEY_DEMO;
        File localFile = new File("src/test/resources/store-demo.txt");
        InputStream inputstream = new FileInputStream(localFile);
        storage.store(inputstream, localFile.length(),"text/plain",key);
    }

    @Test
    public void load() {
        // 指定文件在 COS 上的对象键
        String key = OSS_FILE_KEY_DEMO;
        // 指定要下载到的本地路径
        File downFile = new File("src/test/resources/mydown.txt");
        storage.load(key, downFile);
    }

    @Test
    public void delete() {
        String key = OSS_FILE_KEY_DEMO;
        storage.delete(key);
    }

    @Test
    public void generateUrl() {
        // 指定文件在 COS 上的对象键
        String key = "upload_single_demo.txt";
        String url = storage.generateUrl(key);

        System.out.println("url:"+url);
    }

}