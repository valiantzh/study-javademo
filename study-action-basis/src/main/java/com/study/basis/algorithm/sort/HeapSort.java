package com.study.basis.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 堆排序（Heap Sort） 
 * @Description: 
 * 工作原理
 *   利用堆这种数据结构所设计的一种排序算法。
 *   堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * 算法描述
 *   1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 *   2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 *   3.由于交换后新的堆顶R[1]可能违反堆的性质，
 *     因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 *     不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 * 算法分析
 *     
 * 复杂度
 *   时间复杂度（平均）：
 *   时间复杂度（最坏）：
 *   时间复杂度（最好）：
 *   空间复杂度：
 *   稳定性：
 */
public class HeapSort {

	private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void buildHeap(int[] arr){
        int heapSize = arr.length;
        int filter = heapSize/2;
        
        for(int i = filter-1; i>=0; i--){
            heapAdjust(arr, i, heapSize);
        }
        
    }
    //堆整理
    private static void heapAdjust(int[] arr, int i, int heapSize){
        //当前待调整的元素
        int temp = arr[i];
        //改元素的左孩子
        int index = 2*i+1;
        while(index<heapSize){
            //如果右孩子大于左孩子，则index+1，即交换右孩子和双亲节点
            if(index+1 < heapSize && arr[index] < arr[index + 1]){
                index++;
            }
            if(arr[i] < arr[index]){
                arr[i] = arr[index];//交换孩子和双亲节点
                i = index;//重新赋值
                index = 2*i+1;
            }else{
                break;//已经是最大堆
            }
            arr[i] = temp;//把双亲赋值给孩子节点
        }
    }
    
    public static int[] sort(int[] arr){
        long startInMs = System.currentTimeMillis();
        long count = 0;
        
        int len = arr.length;
        
        System.out.println("===== Heap Sort Start. Length="+len);
        buildHeap(arr);
        for(int i = arr.length-1; i>0; i--){
            swap(arr, 0, i);
            heapAdjust(arr,0,i);
        }
        
        System.out.println("===== Heap Sort End. Length="+len+",count="+count+",耗时(ms)="+(System.currentTimeMillis()-startInMs));
        System.out.println("***** arrSort:"+JSON.toJSONString(arr));
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
