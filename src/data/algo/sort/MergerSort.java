package data.algo.sort;

import java.util.Arrays;

/**
 * 归并排序：
 */
public class MergerSort {

    public static void main(String[] args){

        int[] data = {4,2,30,4,5,7,6,11,3,-1};

        mergerSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));

    }


    private static void merger(int[] data,int left,int mid, int right){

       int leftBound = left;
       int rightBound = mid+1;//这里为什么要+1？

       int[] tempData = new int[data.length];
       int index = left;

       // 左右两边数组一次比较，按照从小到大的顺序加入到临时数组中去
       while (leftBound <= mid && rightBound <= right){

           if (data[leftBound] < data[rightBound]){

               tempData[index++] = data[leftBound++];
           }
           else {

               tempData[index++] = data[rightBound++];
           }
       }


       //左右两个数组有可能还剩余数据没有加入临时数组中去
        while (leftBound <= mid){

            tempData[index++] = data[leftBound++];
        }

        while (rightBound <= right){

            tempData[index++] = data[rightBound++];
        }

        //将临时数组中数据还原到原数组中去；

        index = left;
        while (index <= right){

            data[index] = tempData[index++];
        }

    }

    private static void mergerSort(int[] data,int left, int right){

        if (left >= right){
            return;
        }

        int mid = (left+right)/2;
        mergerSort(data,left,mid);
        mergerSort(data,mid+1,right);
        merger(data,left,mid,right);

    }


}
