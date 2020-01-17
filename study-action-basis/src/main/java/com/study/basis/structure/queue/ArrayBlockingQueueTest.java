package com.study.basis.structure.queue;

import com.study.basis.utils.SleepUtils;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author valiantzh
 * @version 1.0
 * ArrayBlockingQueue是数组实现的线程安全的有界的阻塞队列。
 *      + 线程安全: 内部通过“互斥锁”保护竞争资源，实现了多线程对竞争资源的互斥访问
 * 		+ 有界，则是指ArrayBlockingQueue对应的数组是有界限的
 * 		+ 阻塞队列，是指多线程访问竞争资源时，当竞争资源已被某线程获取时，其它要获取该资源的线程需要阻塞等待;
 * 	    + 按 FIFO（先进先出）原则对元素进行排序，元素都是从尾部插入到队列，从头部开始返回。
 *
 *
 *
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue books = new ArrayBlockingQueue(10);
        books.add("books-01");
        books.add("books-02");
        books.add("books-03");
        books.add("books-04");
        books.offer("books-05");
        System.out.println(books);
        System.out.println(books.poll());
        System.out.println(books.peek());
        System.out.println(books.take());

    }


}
/*
// 创建一个带有给定的（固定）容量和默认访问策略的 ArrayBlockingQueue。
ArrayBlockingQueue(int capacity)
// 创建一个具有给定的（固定）容量和指定访问策略的 ArrayBlockingQueue。
ArrayBlockingQueue(int capacity, boolean fair)
// 创建一个具有给定的（固定）容量和指定访问策略的 ArrayBlockingQueue，它最初包含给定 collection 的元素，并以 collection 迭代器的遍历顺序添加元素。
ArrayBlockingQueue(int capacity, boolean fair, Collection<? extends E> c)
// 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则抛出 IllegalStateException。
boolean add(E e)
// 自动移除此队列中的所有元素。
void clear()
// 如果此队列包含指定的元素，则返回 true。
boolean contains(Object o)
// 移除此队列中所有可用的元素，并将它们添加到给定 collection 中。
int drainTo(Collection<? super E> c)
// 最多从此队列中移除给定数量的可用元素，并将这些元素添加到给定 collection 中。
int drainTo(Collection<? super E> c, int maxElements)
// 返回在此队列中的元素上按适当顺序进行迭代的迭代器。
Iterator<E> iterator()
// 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则返回 false。
boolean offer(E e)
// 将指定的元素插入此队列的尾部，如果该队列已满，则在到达指定的等待时间之前等待可用的空间。
boolean offer(E e, long timeout, TimeUnit unit)
// 获取但不移除此队列的头；如果此队列为空，则返回 null。
E peek()
// 获取此队列的头，如果此队列为空，则返回 null。
E poll()
// 获取并移除此队列的头部，在指定的等待时间前等待可用的元素（如果有必要）。
E poll(long timeout, TimeUnit unit)
// 将指定的元素插入此队列的尾部，如果该队列已满，则等待可用的空间。
void put(E e)
// 返回在无阻塞的理想情况下（不存在内存或资源约束）此队列能接受的其他元素数量。
int remainingCapacity()
// 从此队列中移除指定元素的单个实例（如果存在）。
boolean remove(Object o)
// 返回此队列中元素的数量。
int size()
// 获取并移除此队列的头部，在元素变得可用之前一直等待（如果有必要）。
E take()
// 返回一个按适当顺序包含此队列中所有元素的数组。
Object[] toArray()
// 返回一个按适当顺序包含此队列中所有元素的数组；返回数组的运行时类型是指定数组的运行时类型。
<T> T[] toArray(T[] a)
// 返回此 collection 的字符串表示形式。
String toString()
 */