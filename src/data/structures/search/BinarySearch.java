package data.structures.search;

import java.util.Arrays;

/**
 * 二分查找算法
 *
 * 递归版
 * 非递归版
 */
public class BinarySearch {

    public static void main(String[] args){

        int[] data = {4,2,30,4,5,7,6,11,3,111};
        Arrays.sort(data);

        System.out.println(Arrays.toString(data));

        System.out.println(binarySearch(data,0,data.length-1,11));

    }

    /**
     *
     * @param data 有序数组
     * @param left
     * @param right
     * @param findData
     * @return
     */
    private static String binarySearch(int[] data, int left, int right, int findData){

        int midIndex = (left + right) / 2;

        if (left > right){
            return "未找到数据";
        }
        if (data[midIndex] == findData){
            return "待查找数据在数组中的索引为："+ midIndex;
        }

        if (findData < data[midIndex]){
            return binarySearch(data,left,midIndex-1, findData);
        }
        else {
            return binarySearch(data,midIndex+1,right,findData);
        }

    }

}
