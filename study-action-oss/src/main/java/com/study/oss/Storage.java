package com.study.oss;


import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 对象存储接口
 * @author valiantzh
 * @version 1.0
 */
public interface Storage {

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param keyName       文件名
     */
    void store(InputStream inputStream, long contentLength, String contentType, String keyName);

    Stream<Path> loadAll();

    Path load(String keyName);

    void load(String keyName, File downFile);

    void delete(String keyName);

    String generateUrl(String keyName);
}