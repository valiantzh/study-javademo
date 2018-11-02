package com.study.basis.structure.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * HashTable
 * HashMap
 * ConcurrentHashMap
 */
public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
    	 * HashTable
    	 * 底层数组+链表实现，无论key还是value都不能为null;
    	 * 线程安全，实现线程安全的方式是在修改数据时锁住整个HashTable，效率低，ConcurrentHashMap做了相关优化
    	 * 初始size为11，扩容：newsize = olesize*2+1
    	 * 计算index的方法：index = (hash & 0x7FFFFFFF) % tab.length
    	 */
    	Hashtable<String, String> hashTable = new Hashtable<String, String>();
    	hashTable.put("hashTable", "Hello Hashtable");
    	System.out.println("hashTable hashCode "+hashTable.hashCode());
    	
    	/*
    	 * HashMap
    	 * 底层数组+链表实现，可以存储null键和null值，线程不安全
    	 * 初始size为16，扩容：newsize = oldsize*2，size一定为2的n次幂
    	 * 扩容针对整个Map，每次扩容时，原来数组中的元素依次重新计算存放位置，并重新插入
    	 * 插入元素后才判断该不该扩容，有可能无效扩容（插入后如果扩容，如果没有再次插入，就会产生无效扩容）
    	 * 当Map中元素总数超过Entry数组的75%，触发扩容操作，为了减少链表长度，元素分配更均匀
    	 * 计算index方法：index = hash & (tab.length – 1)
    	 * 
    	 * HashMap的内部结构可以看作是数组(Node<K,V>[] table)和链表的复合结构，
    	 *   数组被分为一个个桶（bucket），通过哈希值决定了键值对在这个数组中的寻址（哈希值相同的键值对，则以链表形式存储）
    	 * 
    	 * HashMap和Hashtable都是用hash算法来决定其元素的存储，
    	 *   因此HashMap和Hashtable的hash表包含如下属性:
    	 *   容量（capacity）：hash表中桶的数量;
    	 *   初始化容量（initial capacity）：创建hash表时桶的数量，HashMap允许在构造器中指定初始化容量;
    	 *   尺寸（size）：当前hash表中记录的数量
    	 *   负载因子（load factor）：负载因子等于“size/capacity”。负载因子为0，表示空的hash表，0.5表示半满的散列表，依此类推。轻负载的散列表具有冲突少、适宜插入与查询的特点（但是使用Iterator迭代元素时比较慢）
    	 *   
    	 * 除此之外，hash表里还有一个“负载极限”，“负载极限”是一个0～1的数值，
    	 *   “负载极限”决定了hash表的最大填满程度。
    	 *   当hash表中的负载因子达到指定的“负载极限”时，
    	 *   hash表会自动成倍地增加容量（桶的数量），
    	 *   并将原有的对象重新分配，放入新的桶内，这称为rehashing。
    	 *   
    	 * HashMap和Hashtable的构造器允许指定一个负载极限，HashMap和Hashtable默认的“负载极限”为0.75，
    	 *  这表明当该hash表的3/4已经被填满时，hash表会发生rehashing。
    	 *  
    	 * “负载极限”的默认值（0.75）是时间和空间成本上的一种折中：
    	 *   较高的“负载极限”可以降低hash表所占用的内存空间，但会增加查询数据的时间开销，而查询是最频繁的操作（HashMap的get()与put()方法都要用到查询）
    	 *   较低的“负载极限”会提高查询数据的性能，但会增加hash表所占用的内存开销
    	 */
    	Map<String, String> map = new HashMap<>();
    	map.put("hashmap", "Hello HashMap");
    	map.put("aa", "nn");
    	
    	//遍历方式一 建议使用第一种 EntrySet 进行遍历
    	System.out.println("Map 遍历方式一");
    	Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> next = entryIterator.next();
            System.out.println("key=" + next.getKey() + " value=" + next.getValue());
        }
    	//遍历方式二 还得需要通过 key 取一次 value，效率较低
        System.out.println("Map 遍历方式二");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println("key=" + key + " value=" + map.get(key));

        }
        //遍历方式三  需要 JDK1.8 以上，通过外层遍历 table，内层遍历链表或红黑树
        System.out.println("Map 遍历方式三");
        map.forEach((key,value)->{
            System.out.println("key=" + key + " value=" + value);
        });
    	/**
    	 * ConcurrentHashMap
    	 * 底层采用分段的数组+链表实现，线程安全
    	 * 通过把整个Map分为N个Segment，可以提供相同的线程安全，但是效率提升N倍，默认提升16倍。
    	 *   (读操作不加锁，由于HashEntry的value变量是 volatile的，也能保证读取到最新的值。)
    	 * Hashtable的synchronized是针对整张Hash表的，即每次锁住整张表让线程独占，
    	 *   ConcurrentHashMap允许多个修改操作并发进行，其关键在于使用了锁分离技术
    	 * 有些方法需要跨段，比如size()和containsValue()，它们可能需要锁定整个表,而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁
    	 * 扩容：段内扩容（段内元素超过该段对应Entry数组长度的75%触发扩容，不会对整个Map进行扩容），插入前检测需不需要扩容，有效避免无效扩容
    	 * Hashtable和HashMap都实现了Map接口，但是Hashtable的实现是基于Dictionary抽象类的。
    	 *   Java5提供了ConcurrentHashMap，它是HashTable的替代，比HashTable的扩展性更好。
    	 * 
    	 * 锁分段技术：首先将数据分成一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据的时候，其他段的数据也能被其他线程访问。
    	 */
    	ConcurrentHashMap<String, String> cHashMap = new ConcurrentHashMap<String, String>();
    	cHashMap.put("hashmap", "Hello ConcurrentHashMap");
    	System.out.println(cHashMap.size());
    	
    	System.out.println("availableProcessors:"+Runtime.getRuntime().availableProcessors());
	}

}
