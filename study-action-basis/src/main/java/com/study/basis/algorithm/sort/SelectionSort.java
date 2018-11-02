package com.study.basis.algorithm.sort;

import com.alibaba.fastjson.JSON;

public class SelectionSort {

	/**
     * 选择排序（Selection Sort） 
     * @Description: 
     * 工作原理
     *   首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置；
     *   然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     *   以此类推，直到所有元素均排序完毕
     * 算法描述
     *   1.初始状态：无序区为R[1..n]，有序区为空；
     *   2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     *     该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
     *     使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     *   3.n-1趟结束，数组有序化了。
     * 复杂度
     *   时间复杂度（平均）：
     *   时间复杂度（最坏）：
     *   时间复杂度（最好）：
     *   空间复杂度：
     *   稳定性：
     * @param arr
     */
    public static int[] sort(int[] arr){
        long startInMs = System.currentTimeMillis();
        long count = 0;
        
        int temp;
        int minIndex;//最小索引
        int len = arr.length;
        System.out.println("===== Selection Sort Start. Length="+len);
        for(int i=0; i<len-1; i++){
            minIndex = i;
            for(int j=i+1; j< len; j++){
                if(arr[j]< arr[minIndex]){// // 寻找最小的数
                    minIndex = j;// 将最小数的索引保存
                    
                    count++;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
        System.out.println("===== Selection Sort End. Length="+len+",count="+count+",耗时(ms)="+(System.currentTimeMillis()-startInMs));
        System.out.println("***** arrSort:"+JSON.toJSONString(arr));
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
