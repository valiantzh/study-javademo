package com.study.basis.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 归并排序（Merge Sort） <br/>
 * 工作原理 <br/>
 *   归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 *   将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 *   若将两个有序表合并成一个有序表，称为2-路归并。 <br/>
 * 算法描述 <br/>
 *   1.把长度为n的输入序列分成两个长度为n/2的子序列； <br/>
 *   2.对这两个子序列分别采用归并排序； <br/>
 *   3.将两个排序好的子序列合并成一个最终的排序序列。 <br/>
 * 算法分析 <br/>
 *   归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，
 *   但表现比选择排序好的多，因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间。<br/>
 * 复杂度 <br/>
 *   时间复杂度（平均）： <br/>
 *   时间复杂度（最坏）： <br/>
 *   时间复杂度（最好）： <br/>
 *   空间复杂度： <br/>
 *   稳定性： <br/> 
 *
 */
public class MergeSort {
	
	public static int[] sort(int[] arr){
        long startInMs = System.currentTimeMillis();
        long count = 0;
        
        int len = arr.length;
        int[] result = new int[len];
        int block, start;
        System.out.println("===== Merge Sort Start. Length="+len);
        for(block = 1; block <len; block *= 2){
        	for(start = 0; start < len; start += 2*block){
        		int low = start;
        		int mid = (start +block)< len?(start+block):len;
        		int high = (start +2*block)<len?(start +2*block):len;
        		//两个块的起始下标及介绍下标
        		int start1 = low, end1 = mid;
        		int start2 = mid, end2 = high;
        		//开始对两个block进行归并排序
        		while(start1< end1 && start2<end2){
        			result[low++] = arr[start1]<arr[start2]?arr[start1++]:arr[start2++];
        		}
        		//
        		while(start1 <end1){
        			result[low++] = arr[start1++];
        		}
        		//
        		while(start2 < end2){
        			result[low++] = arr[start2++];
        		}
        	}
        	int[] temp = arr;
        	arr = result;
        	result = temp;
        }
        
        System.out.println("===== Radix Sort End. Length="+len+",count="+count+",耗时(ms)="+(System.currentTimeMillis()-startInMs));
        System.out.println("***** arrSort:"+JSON.toJSONString(arr));
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
