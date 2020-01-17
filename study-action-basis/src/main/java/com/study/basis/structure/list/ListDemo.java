package com.study.basis.structure.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import com.alibaba.fastjson.JSON;

/*
 * ArrayList
 * LinkedList
 * Vector
 * Stack
 */
public class ListDemo {

	private static final int COUNT = 100000; //十万

    private static ArrayList<Object> arrayList = new ArrayList<Object>();
    private static LinkedList<Object> linkedList = new LinkedList<Object>();
    private static Vector<Object> vector = new Vector<Object>();
    private static Stack<Object> stack = new Stack<Object>();
    
    /**
     * 指定的List 的子类中插入元素，并统计插入的时间
     * @param list List 的子类
     * @param name 子类的名称
     */
    private static void insertData(List<Object> list,String name) {
        long startTime = System.currentTimeMillis();

        // 向list的位置0插入COUNT个数
        for (int i=0; i<COUNT; i++){
            list.add(0, i);
        }

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(name + " : 插入 "+COUNT+"元素， 使用的时间是 " + interval+" ms");
    }

    /**
     * 指定的List 的子类中删除元素，并统计删除的时间
     * @param list List 的子类
     * @param name 子类的名称
     */
    private static void deleteData(List<Object> list,String name) {
        long startTime = System.currentTimeMillis();

        // 删除list第一个位置元素
        for (int i=0; i<COUNT; i++)
            list.remove(0);

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(name + " : 删除 "+COUNT+"元素， 使用的时间是 " + interval+" ms");
    }

    /**
     * 指定的List 的子类中读取元素，并统计读取的时间
     * @param list List 的子类
     * @param name 子类的名称
     */
    private static void readAccessData(List<Object> list,String name) {
        long startTime = System.currentTimeMillis();

        // 读取list元素
        for (int i = 0; i < COUNT; i++)
            list.get(i);

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(name + " : 随机读取 "+COUNT+"元素， 使用的时间是 " + interval+" ms");
    }

    public static void testPerformance(){
    	System.out.println("....开始测试插入元素..........");

        // 插入元素测试
        insertData(arrayList,"ArrayList") ;
        insertData(linkedList,"LinkedList") ;
        insertData(vector,"Vector") ;
        insertData(stack,"Stack") ;

        System.out.println("....开始测试读取元素..........");

        // 随机读取元素测试
        readAccessData(arrayList,"ArrayList") ;
        readAccessData(linkedList,"LinkedList") ;
        readAccessData(vector,"Vector") ;
        readAccessData(stack,"Stack") ;

        System.out.println("....开始测试删除元素..........");

        // 随机删除元素测试
        deleteData(arrayList,"ArrayList") ;
        deleteData(linkedList,"LinkedList") ;
        deleteData(vector,"Vector") ;
        deleteData(stack,"Stack") ;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		show("list.toString:"+list.toString());
		show("list.get:"+list.get(2));
		show("list.size:"+list.size());
		//show("list.get:"+list.get(3));
		show("list:"+JSON.toJSONString(list));
		
		//JDK 1.8
		list.forEach((value)->{
            System.out.println(" value=" + value);
        });
		
		//性能测试对比
		testPerformance();
	}
	
	public static void show(String msg){
		System.out.println(msg);
	}
}
