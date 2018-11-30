package com.study.basis.scanner;

import java.util.Scanner;

public class ScannerDemo {

	/*
	 * 1、一定要读取到有效字符后才可以结束输入。
	 * 2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
	 * 3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
	 * 4、next() 不能得到带有空格的字符串。
	 */
	public static void funcNext(){
		Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
 
        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
	}
	/*
	 * 1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
	 * 2、可以获得空白。
	 */
	public static void funcNextLine(){
		Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
 
        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
	}
	public static void funcCheck(){
		Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数：");
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            i = scan.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数：");
        if (scan.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scan.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        scan.close();
	}
	public static void funcSum(){
		Scanner scan = new Scanner(System.in);
		 
        double sum = 0;
        int m = 0;
 
        while (scan.hasNextDouble()) {
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }
 
        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
        scan.close();
	}
	public static void main(String[] args) {
		//funcNext();
		
		//funcNextLine();
		
		//funcCheck();
		
		//funcSum();
        System.out.println(3|9);
	}

}
