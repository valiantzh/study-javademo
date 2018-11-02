package com.study.basis.structure.set;

import java.util.*;

/*
 * TreeSet采用红黑树的数据结构来存储集合元素。TreeSet支持两种排序方式: 自然排序、定制排序
 * 1. 自然排序
 *   TreeSet会调用集合元素的compareTo(Object obj)方法来比较元素之间的大小关系，然后将集合元素按升序排序，即自然排序。
 *   如果试图把一个对象添加到TreeSet时，则该对象的类必须实现Comparable接口，否则程序会抛出异常。
 * 
 */
public class TreeSetTest
{
    public static void main(String[] args) 
    {
        TreeSet tSet = new TreeSet();
        //向TreeSet中添加四个Integer对象
        tSet.add(5);
        tSet.add(2);
        tSet.add(10);
        tSet.add(-9);

        //输出集合元素，看到集合元素已经处于排序状态
        System.out.println(tSet);

        //输出集合里的第一个元素
        System.out.println("first:"+tSet.first());

        //输出集合里的最后一个元素
        System.out.println("last:"+tSet.last());

        //返回小于4的子集，不包含4
        System.out.println("headSet:"+tSet.headSet(4));

        //返回大于5的子集，如果Set中包含5，子集中还包含5
        System.out.println("tailSet:"+tSet.tailSet(5));

        //返回大于等于-3，小于4的子集。
        System.out.println("subSet:"+tSet.subSet(-3 , 4));
        
        //
        TreeSet tSet2 = new TreeSet();
        tSet2.add(new Dog(7));
        tSet2.add(new Dog(8));
        tSet2.add(new Dog(3));
        tSet2.add(new Dog(2));
        System.out.println(""+tSet2);
    }
}

class Dog implements Comparable<Dog>{
	int size;
	public Dog(int size){
		this.size = size;
	}
	public String toString() {
        return "Dog["+size + "]";
    }
	@Override
	public int compareTo(Dog o) {
		return size - o.size;
	}
}