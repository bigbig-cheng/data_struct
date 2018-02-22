package cn.cy.search.ordersearch;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiangyi on 2017/9/11.
 */
public class OrderSearch {

    /**
     * 顺序查找
     * @param arr
     * @param key
     * @return
     */
    public static int orderSearch(int[] arr, int key){

        if(arr==null || arr.length==0){
            return 0;
        }

        for(int i=1; i<=arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return 0;
    }


    /**
     * 哨兵查找
     * @param arr
     * @param n
     * @param key
     * @return
     */
    public static int sentinelSearch(int[] arr, int n, int key){
        int i = n;
        arr[0] = key;
        while(arr[i] != key){
            i--;
        }
        return i;
    }

    /**
     * 二分查找
     * @param arr
     * @param n
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr, int n, int key){
        int mid;
        int low = 1;
        int high =n;
        while(low < high){
            mid = (low + high)/2;
            if(arr[mid] < key){
                low = mid + 1;
            }else if(arr[mid] > key){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return 0;
    }

    /**
     * 均匀分布数据
     *      -- 二分查找优化
     * @param arr
     * @param n
     * @param key
     * @return
     */
    public static int binarySearch2(int[] arr, int n, int key){

        int mid;
        int low = 1;
        int high =n;
        while(low < high){
            mid = low + (key - arr[low])*(high - low)/(arr[high] - arr[low]);
            if(arr[mid] > key){
                high = mid - 1;
            }else if(arr[mid] < key){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return 0;
    }

    /**
     * 按下标获取
     *      裴波纳契数列指定值
     * @param index
     * @return
     */
    public static int getFibonacciIndex(int index){

        int temp1 = 0;
        int temp2 = 1;
        if(index<0 || index==0){
            return temp1;
        }
        if(index == 1){
            return temp2;
        }

        int f = 0;
        for(int i=2; i<=index; i++){
            f = temp1 + temp2;
            temp1 = temp2;
            temp2 = f;
        }
        return f;
    }

    public static Integer[] getFibonacciByLen(int len){
        List<Integer> integerList = new ArrayList<>();

        integerList.add(0);
        if(len<1 || len==1){
            return integerList.toArray(new Integer[1]);
        }

        integerList.add(1);
        if(len == 2){
            return integerList.toArray(new Integer[2]);
        }

        int k=1;
        do {
            k++;
            integerList.add(integerList.get(k-1)+integerList.get(k-2));
        } while (len > integerList.get(k)-1);
        return integerList.toArray(new Integer[]{});
    }

    /**
     * 裴波那契查找
     * @param arr
     * @param n
     * @param key
     * @return
     */
    public static int fibonacciSearch(int[] arr, int n, int key){

        int low = 1;
        int high = n;
        int k = 0;
        int mid;

        Integer[] fibonacciArr = getFibonacciByLen(n);
        while(n > fibonacciArr[k]-1){
            k++;
        }
        int[] newArr = new int[fibonacciArr[k]-1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        for(int i=n; i<newArr.length; i++){
            newArr[i] = arr[n];
        }

        while(high >= low){
            mid = low + fibonacciArr[k-1] - 1;
            if(key < newArr[mid]){
                high = mid - 1;
                k = k-1;
            }else if(key > newArr[mid]){
                low = mid + 1;
                k = k-2;
            }else{
                if(mid >= n){
                    return 0;
                }
                return mid;
            }
        }
        return 0;
    }


}
