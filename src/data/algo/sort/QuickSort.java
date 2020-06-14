package data.algo.sort;

import java.util.Arrays;

/**
 * 快速排序，
 */
public class QuickSort {

    public static void main(String[] args){

        int[] data = {4,2,30,4,5,7,6,11,3,-1};

        quickSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));

    }


    private static int partition(int[] data, int low, int height){

        int start = low;
        int end = height;
        int baseNum = data[low];


        while (start < end){

            //从后往前找，找到比基准值小的
           while (start < end && data[end] >= baseNum){

               end--;
           }

           if (data[end] < baseNum){
               data[start++] = data[end];
           }


            //从前往后找，找到比基准值大的
            while (start < end && data[start] < baseNum){

               start++;
            }

            if (data[start] >= baseNum){

                data[end--] = data[start];
            }

        }

        data[start] = baseNum;
        return start;

    }


    private static void quickSort(int[] data, int low, int height){

        if (low < height){

            int index = partition(data,low,height);

            quickSort(data,low,index-1);
            quickSort(data,index+1,height);
        }

    }




}
