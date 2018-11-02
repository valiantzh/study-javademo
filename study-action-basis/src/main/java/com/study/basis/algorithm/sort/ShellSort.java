package com.study.basis.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 希尔排序（Shell Sort） 
 * @Description: 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
 *     它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * 工作原理
 *   先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序
 * 算法描述
 *   1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 *   2.按增量序列个数k，对序列进行k 趟排序；
 *   3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 *     仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * 算法分析
 *     希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。
 *     动态定义间隔序列的算法是《算法（第4版）》的合著者Robert Sedgewick提出的。
 * 复杂度
 *   时间复杂度（平均）：
 *   时间复杂度（最坏）：
 *   时间复杂度（最好）：
 *   空间复杂度：
 *   稳定性：
 */
public class ShellSort {
    public static int[] sort(int[] arr, int gap){
        long startInMs = System.currentTimeMillis();
        long count = 0;
        if(gap<2){
            gap = 2;
        }else if(gap>10){
            gap = 10;
        }
        
        int len = arr.length;
        int temp;
        int j;//定位较远的元素
        int jmp = len/gap;
        
        
        System.out.println("===== Shell Sort Start. Length="+len+",gap="+gap);
        while (jmp > 0) { 
            for(int i = jmp; i < len; i++){
                temp = arr[i];
                j = i-jmp;
                while(j>=0 && temp<arr[j]){
                    arr[j+jmp] = arr[j];
                    j = j-jmp;
                    
                    count++;
                }
                
                arr[j+jmp] = temp;
                
            }
            jmp = jmp/gap;
        }
        
        System.out.println("===== Shell Sort End. Length="+len+",gap="+gap+",count="+count+",耗时(ms)="+(System.currentTimeMillis()-startInMs));
        System.out.println("***** arrSort:"+JSON.toJSONString(arr));
        return arr;
    }
}
