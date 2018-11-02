package com.study.basis.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 基数排序（Radix Sort）
 * 工作原理 <br/>
 *   基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；
 *   依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
 *   最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。 <br/>
 * 算法描述 <br/>
 *   1.取得数组中的最大数，并取得位数； <br/>
 *   2.arr为原始数组，从最低位开始取每个位组成radix数组； <br/>
 *   3.对radix进行计数排序（利用计数排序适用于小范围数的特点） <br/>
 * 算法分析 <br/>
 *   基数排序基于分别排序，分别收集，所以是稳定的。
 *   但基数排序的性能比桶排序要略差，每一次关键字的桶分配都需要O(n)的时间复杂度，
 *   而且分配之后得到新的关键字序列又需要O(n)的时间复杂度。
 *   假如待排数据可以分为d个关键字，则基数排序的时间复杂度将是O(d*2n) ，当然d要远远小于n，因此基本上还是线性级别的。
 *   基数排序的空间复杂度为O(n+k)，其中k为桶的数量。一般来说n>>k，因此额外空间需要大概n个左右。
 * 复杂度 <br/>
 *   时间复杂度（平均）： <br/>
 *   时间复杂度（最坏）： <br/>
 *   时间复杂度（最好）： <br/>
 *   空间复杂度： <br/>
 *   稳定性： <br/> 
 *
 */
public class RadixSort {
	public static final int MAX_NUM = 100;//数值的最大位数  
	public static int[] sort(int[] arr){
        long startInMs = System.currentTimeMillis();
        long count = 0;
        
        int len = arr.length;
        int k;
        int m;
        System.out.println("===== Radix Sort Start. Length="+len);
        //假设每个数的位数不超过3位
        for(int n=1; n<=MAX_NUM; n = n*10){//n为基数，从个位开始排序
        	//
        	int[][] tmp = new int[10][len];
        	for(int i = 0; i< len; i++){//
        		m = (arr[i]/n)%10;
        		tmp[m][i] = arr[i];//把值暂存在tmp中
        	}
        	k = 0;
        	for(int i = 0; i<10; i++){
        		for(int j=0; j<len; j++){
        			if(tmp[i][j] != 0){//非零表示有数
        				//把暂存到tmp中的值放回arr[]中
            			arr[k++] = tmp[i][j];
        			}
        			
        		}
        	}
        }
        System.out.println("===== Radix Sort End. Length="+len+",count="+count+",耗时(ms)="+(System.currentTimeMillis()-startInMs));
        System.out.println("***** arrSort:"+JSON.toJSONString(arr));
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
