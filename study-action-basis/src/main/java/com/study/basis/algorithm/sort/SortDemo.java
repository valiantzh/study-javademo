/**
 * 
 * File: SortDemo.java <br/>
 * Package: com.study.basis.algorithm.sort <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月29日 上午8:38:33
 * @version 1.0
 * 
 */
package com.study.basis.algorithm.sort;

import java.util.Random;

import org.apache.commons.collections4.functors.InstantiateTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/*
https://www.toutiao.com/i6584942885190238728/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1540772949&app=news_article&utm_source=weixin&iid=47045642479&utm_medium=toutiao_android&group_id=6584942885190238728
https://www.toutiao.com/i6609876623455945219/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1540773012&app=news_article&utm_source=weixin&iid=47045642479&utm_medium=toutiao_android&group_id=6609876623455945219
常见排序算法可以分为两大类：
非线性时间比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此称为非线性时间比较类排序。
线性时间非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此称为线性时间非比较类排序。

稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。
不稳定：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。
时间复杂度：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。
空间复杂度：是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数。
 */
/** 
 *   排序算法
 *   
 * @author zhengxy
 * @date 2018年10月29日 上午8:38:33  
 *   
 */
public class SortDemo {
    private static Logger log = LoggerFactory.getLogger(SortDemo.class);
    public static final int MIN_TEST_NUM = 10;
    public static final int MIN_TEST_INTERVAL = 10;
    
    public static int[] generateRandomNumber(int num, int interval){
        if(num<MIN_TEST_NUM){
            num = MIN_TEST_NUM;
        }
        if(interval<MIN_TEST_INTERVAL){
            interval = MIN_TEST_INTERVAL;
        }
        Random rand = new Random();
        int[] arr = new int[num];
        for(int i=0; i< num; i++){
            arr[i]= rand.nextInt(interval)+1;
        }
        return arr;
    }
    
    /**  
     * @Title: main  
     * @Description: TODO(这里用一句话描述这个方法的作用)  
     * @param args  
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[] arrSrc = generateRandomNumber(19,99);
        System.out.println("arrSrc:"+JSON.toJSONString(arrSrc));
        //int[] arrSrcClon1 = arrSrc.clone();
        //System.out.println("arrSrc:"+JSON.toJSONString(arrSrcClon1));
        int[] arrSort = BubbleSort.sort(arrSrc.clone());
        int len = arrSrc.length;
        
        //BubbleSort.sort2(arrSrc.clone());//随机情况下，提升效果不大
        
        SelectionSort.sort(arrSrc.clone());

        InsertionSort.sort(arrSrc.clone());
        
        ShellSort.sort(arrSrc.clone(), 2);
        ShellSort.sort(arrSrc.clone(), 3);
        
        ////////////
        long startInMs = System.currentTimeMillis();
        log.info("===== Quick2 Sort Start. Length="+len);
        int[] arrSort51 = QuickSort.sort(arrSrc.clone(), 0, len-1);
        log.info("===== Quick2 Sort End. Length="+len+",耗时(ms)="+(System.currentTimeMillis()-startInMs));
        System.out.println("***** arrSort51:"+JSON.toJSONString(arrSort51));
        
        HeapSort.sort(arrSrc.clone());
        
        RadixSort.sort(arrSrc.clone());
        
        MergeSort.sort(arrSrc.clone());
        System.out.println("arrSrc:"+JSON.toJSONString(arrSrc));
        System.out.println("arrSort01:"+JSON.toJSONString(arrSort));
 
    }
}
