package com.study.basis.structure.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.alibaba.fastjson.JSON;

/*
 * https://www.cnblogs.com/LittleHann/p/3690187.html
 * 1) HashSet的性能总是比TreeSet好(特别是最常用的添加、查询元素等操作)，因为TreeSet需要额外的红黑树算法来维护集合元素的次序。只有当需要一个保持排序的Set时，才应该使用TreeSet，否则都应该使用HashSet
 * 2) 对于普通的插入、删除操作，LinkedHashSet比HashSet要略慢一点，这是由维护链表所带来的开销造成的。不过，因为有了链表的存在，遍历LinkedHashSet会更快
 * 3) EnumSet是所有Set实现类中性能最好的，但它只能保存同一个枚举类的枚举值作为集合元素
 * 4) HashSet、TreeSet、EnumSet都是"线程不安全"的，通常可以通过Collections工具类的synchronizedSortedSet方法来"包装"该Set集合。
 *    SortedSet s = Collections.synchronizedSortedSet(new TreeSet(...));
 */
public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		set.add("456");
		set.add("123");
		set.add("456");
		set.add("789");
		set.add(null);
		set.add(null);
		System.out.println();
		System.out.println(JSON.toJSONString(set));
		
		//遍历1
		System.out.println("---- 遍历-Iterator ----");
		for(Iterator iterator = set.iterator();
			       iterator.hasNext(); ) { 
			    System.out.println(""+iterator.next());
		}
		//遍历2
		System.out.println("---- 遍历-foreach ----");
		Object[] object = set.toArray();
		for (Object obj : object){
		    System.out.println(""+obj);
		}
		
		//同步Set
		System.out.println("---- HashSet 同步方式 ----");
		Set<String> s = Collections.synchronizedSet(new HashSet<String>());
		s.add("456");
		s.add("123");
		s.add("456");
		System.out.println(JSON.toJSONString(s));
	}

}
