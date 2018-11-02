package com.study.basis.thread.demo2;

/**
 * ThreadLocal所保存的数据是线程私有的
 *    
 *
 */
public class ThreadLocalTest {
	static class ResourceClass {

		public final static ThreadLocal<String> RESOURCE_1 = new ThreadLocal<String>();

		public final static ThreadLocal<String> RESOURCE_2 = new ThreadLocal<String>();

	}

	static class A {

		public void setOne(String value) {
			ResourceClass.RESOURCE_1.set(value);
		}

		public void setTwo(String value) {
			ResourceClass.RESOURCE_2.set(value);
		}
	}

	static class B {
		public void display() {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+","+ResourceClass.RESOURCE_1.get() + ":"
					+ ResourceClass.RESOURCE_2.get());
		}
	}

	public static void main(String[] args) {
		final A a = new A();
		final B b = new B();
		for (int i = 0; i < 15; i++) {
			final String resouce1 = "线程-" + i;
			final String resouce2 = " value = (" + i + ")";
			new Thread() {
				public void run() {
					
					try {
						a.setOne(resouce1);
						a.setTwo(resouce2);
						b.display();
					} finally {
						ResourceClass.RESOURCE_1.remove();
						ResourceClass.RESOURCE_2.remove();
					}
				}
			}.start();
		}
	}
}
