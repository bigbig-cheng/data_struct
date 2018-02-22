package cn.cy.search.ordersearch;

import java.util.Arrays;

/**
 * Created by jiangyi on 2017/9/11.
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4, 15, 32, 47, 64, 73, 99};
//        System.out.println("顺序查找:" + OrderSearch.orderSearch(arr, 3));
//        System.out.println("哨兵顺序查找:" + OrderSearch.sentinelSearch(arr, arr.length-1, 3));
//        System.out.println("二分查找:" + OrderSearch.binarySearch(arr, arr.length-1, 3));
//        System.out.println("优化二分查找:" + OrderSearch.binarySearch2(arr, arr.length-1, 3));
        System.out.println("裴波那契查找:" + OrderSearch.fibonacciSearch(arr, arr.length-1, 73));

//        System.out.println(OrderSearch.getFibonacciIndex(7));
//        System.out.println(Arrays.toString(OrderSearch.getFibonacciByLen(10)));
    }

}
