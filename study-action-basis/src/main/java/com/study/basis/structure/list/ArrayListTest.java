package com.study.basis.structure.list;

import java.util.*;

public class ArrayListTest {
	public static void main(String[] args) {
		List books = new ArrayList();
		
		// 向books集合中添加三个元素
		books.add(new String("Spring实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂Android讲义"));
		System.out.println(books);

		// 将新字符串对象插入在第二个位置
		books.add(1, new String("Spring Cloud"));
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}

		// 删除第三个元素
		books.remove(2);
		System.out.println(books);

		// 判断指定元素在List集合中位置：输出1，表明位于第二位
		System.out.println(books.indexOf(new String("Spring Cloud"))); 
		// 将第二个元素替换成新的字符串对象
		books.set(1, new String("Android Gradle"));
		System.out.println(books);

		// 将books集合的第二个元素（包括）
		// 到第三个元素（不包括）截取成子集合
		System.out.println(books.subList(1, 2));
	}
}