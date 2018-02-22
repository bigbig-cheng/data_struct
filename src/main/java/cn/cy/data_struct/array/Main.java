package cn.cy.data_struct.array;

/**
 * Created by jiangyi on 2017/6/27.
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        int len = arr.length;
        int temp;
        for (int i=0;i<len/2;i++){
            temp = arr[i];
            arr[i] = arr[len-i];
            arr[len-1-i] = temp;
        }

        for (int j=0; j<len; j++){
            System.out.print(arr[j]+",");
        }

    }


}
