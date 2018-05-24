package cn.cy.sort.merge;

import java.util.Arrays;

/**
 * Created by jiangyi on 2018/5/24.
 */
public class MergeSortMain {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 4, 3, 2, 1, 5, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void sort(int[] arr){
        int[] temp = new int[arr.length]; // 创建临时数据
        sort(arr, 0, arr.length-1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp); // 左子序排序
            sort(arr, mid+1, right, temp); // 右子序排序
            merge(arr, left, mid, right, temp); // 合并
        }
        System.out.println("sorting..." + Arrays.toString(arr));
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp){

        int i = left; // 左序列指针
        int j = mid + 1; // 右序列指针
        int k = 0; // 临时下标

        // 比较左右序列大小，将小的放入临时数据中
        while(i<=mid && j<=right){
            if(arr[i] > arr[j]){
                temp[k++] = arr[j++];
            }else{
                temp[k++] = arr[i++];
            }
        }

        // 将左序列剩余元素放入临时数组
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        // 将右序列生于元素放入临时数组
        while(j <= right){
            temp[k++] = arr[j++];
        }

        // 排序后数组复制回原数组
        k = 0;
        while(left <= right){
            arr[left++] = temp[k++];
        }
    }

}
