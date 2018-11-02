package com.study.basis.structure.map;

import java.util.*;
import java.io.*;

/*
 * Properties还可以把key-value对以XML文件的形式保存起来，也可以从XML文件中加载key-value对
 */
public class PropertiesTest {
	public static void xmlTest(){
		// 书写properties文件
		Properties properties = new Properties();
		properties.put("ONE", "1");
		properties.put("TWO", "2");
		properties.put("中文", "看看中文怎么样");
		properties.put("日本語", "日本語はどう？");
		properties.put("한국어", "한국어");
		properties.put("Thảo luận tiếng Việt", "Thảo luận tiếng Việt");

		OutputStream stream = null;

		try {
		    stream = new FileOutputStream("temp.xml");
		    properties.storeToXML(stream, "Temporary Properties");
		} catch (IOException ex){
		    ex.printStackTrace();
		}finally{
			try{
				stream.close();
			} catch(Exception e){
			}
		}
		// 读取properties文件
		Properties properties2 = new Properties();
		InputStream is = null;
		try{
			is = new FileInputStream("temp.xml");
			properties2.loadFromXML(is);
			System.out.println(properties2);
		}catch (IOException e) {
		    e.printStackTrace();
		}finally{
		    try{
		        is.close();
		    }catch (Exception e1){}
		}
	}

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		// 向Properties中增加属性
		props.setProperty("username", "yeeku");
		props.setProperty("password", "123456");

		// 将Properties中的key-value对保存到a.ini文件中
		props.store(new FileOutputStream("a.ini"), "comment line"); // ①

		// 新建一个Properties对象
		Properties props2 = new Properties();
		// 向Properties中增加属性
		props2.setProperty("gender", "male");

		// 将a.ini文件中的key-value对追加到props2中
		props2.load(new FileInputStream("a.ini")); // ②
		System.out.println(props2);
		System.out.println(props2.getProperty("username"));
		
		xmlTest();
	}
}