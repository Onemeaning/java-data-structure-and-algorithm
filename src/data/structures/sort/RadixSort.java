package data.structures.sort;

import java.util.Arrays;

/**
 * 基数排序
 * 【注意事项】
 * （1） 要求的内存与数据量的大小成正比约为数据的11倍；
 * （2） 经典的空间换空间的算法
 * （3）只能处理非负数的数据；
 *
 */
public class RadixSort {

    public static void main(String[] args){

        int[] data = {4,2,30,4,5,7,6,11,3,111};

        radixSort(data);
        System.out.println(Arrays.toString(data));


    }

    private static void radixSort(int[] data){

        //创建十个桶，分别代表0-9
        int[][] bucket = new int[10][data.length];

        //存储每个桶中数据的索引
        int[] indexOfEle = new int[10];

        int maxData = data[0];
        for (int i = 1; i < 10; i++) {
            maxData = Math.max(maxData,data[i]);
        }

        int maxDataLen = (""+maxData).length();
        int n = 1;
        for (int i = 0; i < maxDataLen; i++,n *= 10) {

            //将所有的数据放置到相应的桶中去；
            for (int j = 0; j < data.length; j++) {

                int bit = data[j] /n % 10;
                bucket[bit][indexOfEle[bit]++] = data[j];

            }


            //从桶中取出数据放回原来的数组中去
            int index = 0;//用于存储数据到原数组的索引
            for (int k = 0; k < indexOfEle.length ; k++) { //遍历每一个桶

               if (indexOfEle[k] != 0){

                   //取出某个桶中的所有的数据，【注意】将桶中数据取完之后，每个桶对应数据的索引要置零
                   for (int l = 0; l < indexOfEle[k]; l++) {

                       data[index++] = bucket[k][l];
                   }

                   indexOfEle[k] = 0;

               }

            }

        }

    }


}
