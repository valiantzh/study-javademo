package com.study.basis.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序（Insertion Sort） 
 * @Description: 
 * 工作原理
 *   通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 算法描述
 *   1.从第一个元素开始，该元素可以认为已经被排序；
 *   2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
 *   3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
 *   4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 *   5.将新元素插入到该位置后；
 *   6.重复步骤2~5。
 * 复杂度
 *   时间复杂度（平均）：
 *   时间复杂度（最坏）：
 *   时间复杂度（最好）：
 *   空间复杂度：
 *   稳定性：
 */
public class InsertionSort {

    public static int[] sort(int[] arr){
        long startInMs = System.currentTimeMillis();
        long count = 0;
        
        int preIndex;//索引
        int current;//当前
        int len = arr.length;
        System.out.println("===== Insertion Sort Start. Length="+len);
        for(int i=1; i< len; i++){
            preIndex = i-1;
            current = arr[i];
            while(preIndex>=0 && arr[preIndex]>current){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
                
                count++;
            }
            arr[preIndex+1] = current;
        }
        
        System.out.println("===== Insertion Sort End. Length="+len+",count="+count+",耗时(ms)="+(System.currentTimeMillis()-startInMs));
        System.out.println("***** arrSort:"+JSON.toJSONString(arr));
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
