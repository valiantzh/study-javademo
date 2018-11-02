package com.study.basis.algorithm.sort;

/**
 * 快速排序（Quick Sort） <br/>
 * 
 * 工作原理 <br/>
 *   通过一趟排序将待排记录分隔成独立的两部分， 
 *   其中一部分记录的关键字均比另一部分的关键字小，
 *   则可分别对这两部分记录继续进行排序，以达到整个序列有序。 <br/>
 * 算法描述 <br/>
 *   1.从数列中挑出一个元素，称为 “基准”（pivot）； <br/>
 *   2.重新排序数列，所有元素比基准值小的摆放在基准前面，
 *    所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *    在这个分区退出之后，该基准就处于数列的中间位置。
 *    这个称为分区（partition）操作； <br/>
 *   3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。 <br/>
 * 复杂度 <br/>
 *   时间复杂度（平均）： <br/>
 *   时间复杂度（最坏）： <br/>
 *   时间复杂度（最好）： <br/>
 *   空间复杂度： <br/>
 *   稳定性： <br/>
 */
public class QuickSort {
	
    public static int[] sort(int[] arr, int left, int right){
        int temp;
        int lf_idx;
        int rg_idx;
        
        if(left< right){
            lf_idx = left + 1;//arr[left]作为基准
            rg_idx = right;
             while(true){
                 for(int i= left+1; i<=right; i++){//从左向右找出第一个值>arr[left]的值
                     if(arr[i]> arr[left]){
                         lf_idx=i;
                         break;
                     }
                     lf_idx++;
                 }
                 for(int j = right; j>=left+1; j--){//从右向左找出第一个值<arr[left]的值
                     if(arr[j]<=arr[left]){
                         rg_idx = j;
                         break;
                     }
                     rg_idx --;
                 }
                 
                 if(lf_idx < rg_idx){
                     temp = arr[lf_idx];
                     arr[lf_idx] = arr[rg_idx];
                     arr[rg_idx] = temp;
                 }else{
                     break;
                 }
             }
             //
             if(lf_idx>=rg_idx){
                 temp = arr[left];
                 arr[left] = arr[rg_idx];
                 arr[rg_idx] = temp;
                 
                 //分段递归排序
                 sort(arr,left, rg_idx-1);
                 sort(arr,rg_idx+1, right);
             }
            
        }
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
