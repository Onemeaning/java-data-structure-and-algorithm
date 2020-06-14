package data.algo.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序：避免直接插入排序时候，最小值在数组的最后一位的情况下，导致需要移动的次数太多，造成效率低下；
 * （1）交换法：效率比较低；
 * （2）移位法：效率比较高；
 */
public class ShellSort {

    private static final int SIZE = 8000000;

    public static void main(String[] args){

      //  int[] data = {4,2,30,4,5,7,6,11,3,-1};


        int[] data = new int[SIZE];
        for (int i = 0; i < SIZE ; i++) {
           data[i] = (int) (Math.random()*SIZE);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timeStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间为：" + timeStr1);

        shellSort(data);

        Date date2 = new Date();
        String timeStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后时间为：" + timeStr2);


//        System.out.println(Arrays.toString(data));
    }

    private static void shellSort(int[] data){

        //step 表示增量，它是以2的倍率逐渐递减的，直至为1；
        for (int step = data.length/2;step>0;step /= 2){

            for (int i = step; i < data.length ; i++) {

                 // 使用传统的插入排序思想；
                int insertTemp = data[i];
                int insertIndex = i-step;

                while ( insertIndex >= 0 && insertTemp < data[insertIndex]){

                    data[insertIndex + step] = data[insertIndex];
                    insertIndex -= step;

                }

                data[insertIndex+step] = insertTemp;

            }
            
            
        }

    }
}
