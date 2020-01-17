package com.study.basis.jvm.loader;

/**
 * @author valiantzh
 * @version 1.0
 */
public class FDDLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        //一、 使用ClassLoader.loadClass()来加载类，不会执行初始化块
        loader.loadClass("com.study.basis.jvm.loader.FDD");
        // 二、 使用Class.forName()来加载类，默认会执行初始化块
        Class.forName("com.study.basis.jvm.loader.FDD");
        // 三、使用Class.forName()来加载类，指定ClassLoader，初始化时不执行静态块
        Class.forName("com.study.basis.jvm.loader.FDD", false, loader);
    }
}
