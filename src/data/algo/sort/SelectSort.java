package data.algo.sort;

import java.util.Arrays;

/**
 * 选择排序，
 * （1）每一趟（第i趟）排序都去找最小的值与第i个数进行交换；
 * （2）一共排序 length -1 趟;
 */
public class SelectSort {

    public static void main(String[] args){

        int[] data = {3,2,7,1,4,11,45,22,-1};

        selectSort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void selectSort(int[] data){

        int minData ;  //记录数组中第i个数据到最后所有数据的最小值；
        int minIndex ; //记录数组中最小值的索引

        for (int i = 0; i < data.length-1; i++) {

            minData = data[i];
            minIndex = i;

            for (int j = i+1; j < data.length; j++) {

                if (data[j] < minData){
                    minData = data[j];
                    minIndex = j;
                }
            }

            if (minIndex != i){//说明已经发生了交换
                data[minIndex] = data[i];
                data[i] = minData;
            }

        }


    }
}
