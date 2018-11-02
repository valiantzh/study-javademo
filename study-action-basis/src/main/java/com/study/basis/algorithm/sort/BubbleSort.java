package com.study.basis.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序（Bubble Sort）
 * @Description: 
 * 算法描述
 *   1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 *   2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 *   3.针对所有的元素重复以上的步骤，除了最后一个；
 *   4.重复步骤1~3，直到排序完成。
 * 复杂度
 *   时间复杂度（平均）：
 *   时间复杂度（最坏）：
 *   时间复杂度（最好）：
 *   空间复杂度：
 *   稳定性：
 */
public class BubbleSort {
    public static int[] sort(int[] arr){
        long startInMs = System.currentTimeMillis();
        long count = 0;
        
        int temp;
        int len = arr.length;
        System.out.println("===== Bubble Sort Start. Length="+len);
        for(int i=0; i<len-1; i++){
            for(int j=0; j< len-1-i; j++){
                if(arr[j] > arr[j+1]){// 相邻元素两两对比
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    
                    count ++;
                }
            }
        }
        System.out.println("===== Bubble Sort End. Length="+len+",count="+count+",耗时(ms)="+(System.currentTimeMillis()-startInMs));
        System.out.println("***** arrSort:"+JSON.toJSONString(arr));
        return arr;
    }
    
    /**
     * 
     * @Description: 
     * @param arr
     * @return
     */
    public static int[] sort2(int[] arr){
        long startInMs = System.currentTimeMillis();
        long count = 0;
        
        int temp;
        int flag;
        int len = arr.length;
        System.out.println("===== Bubble2 Sort Start. Length="+len);
        System.out.println("===== arr:"+JSON.toJSONString(arr));
        for(int i=0; i<len-1; i++){
            flag = 0;
            for(int j=0; j< len-1-i; j++){
                if(arr[j] > arr[j+1]){// 相邻元素两两对比
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag++;
                    
                    count ++;
                }
            }
            if(0== flag){
                //一次比较后没有交换，表明已经排好序，跳出循环
                break;
            }
        }
        System.out.println("===== Bubble2 Sort End. Length="+len+",count="+count+",耗时(ms)="+(System.currentTimeMillis()-startInMs));
        System.out.println("***** arrSort:"+JSON.toJSONString(arr));
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
