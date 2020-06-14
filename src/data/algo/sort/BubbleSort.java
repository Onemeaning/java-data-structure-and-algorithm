package data.algo.sort;

import java.util.Arrays;

/**
 * 冒泡排序，时间复杂度（O(n^2)）,包括冒泡排序的优化版本；
 */
public class BubbleSort {

    public static void main(String[] args){

        int[] data = {1,2,30,4,5,7,6,11,3};

        bubbleSortPlus(data);
        System.out.println(Arrays.toString(data));

    }


    private static void bubbleSort(int[] data){
        int temp = 0;
        for (int i = 0; i < data.length-1; i++) {

            for (int j = 0; j < data.length-i-1; j++) {

                if (data[j] > data[j+1]){

                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }

    }

    private static void bubbleSortPlus(int[] data){

        boolean flag = true; // 标记是否为一个有序的数组，默认是有序的；
        int temp = 0;
        for (int i = 0; i < data.length-1; i++) {

            for (int j = 0; j < data.length-i-1; j++) {

                if (data[j] > data[j+1]){
                    flag = false; //有交换，说明不是一个有序的数组；
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }

            if (flag){
                break;
            }
            else
                flag = true;
        }

    }

}
