package data.algo.sort;

import java.util.Arrays;

public class SortUtil {

    /**
     * 二分查找，算法复杂度为O(log(n));
     * @param array 输入一个有序的数组
     * @param num 待查找的数字
     * @return -1: 未查找到这个数据；
     *         > 0 :待查找的数字在数组中的位置
     */
    public static int BiSerach(int[] array, int num){

        int lowBond = 0;
        int upBond = array.length-1;
        int mid ;

        while (lowBond <= upBond){

            mid = (lowBond + upBond) / 2;
            if (array[mid] == num){

                return mid;
            }
            else if (array[mid] > num){

                upBond = mid-1;
            }
            else {

                lowBond = mid +1;
            }

        }

        return -1;

    }

    /**
     * 二分查找递归版
     * @param arr 待查找的数组
     * @param l 左边界
     * @param r 有边界
     * @param data 待查找的数据
     * @return -1：未查找到 找到则返回数组下标
     */
    public static int binarySearch(int[] arr, int l, int r, int data) {
        int mid = (l + r) / 2;
        if(r < l){
            return -1;
        }
        if(arr[mid] == data){
            return mid;
        }
        if(arr[mid] < data){
            return binarySearch(arr,mid+1,r,data);
        }else{
            return binarySearch(arr,l,mid-1,data);
        }
    }


    /**
     * 冒泡排序，时间复杂度为O(n^2)
     * @param array 输入一个无序数组
     */
    public static void bubbleSort(int[] array){

        int length = array.length;
        for (int i = 0;i<length;i++){

            for (int j = i+1; j <length ; j++) {

                if (array[i] > array[j])
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序，时间复杂度为O(n^2)
     * @param array
     */
    public static void insertSort(int[] array){

        for (int i = 1; i < array.length ; i++) {

            int index = i-1;   //待插入的位置;
            int intervalNum = array[i];  //待插入数据

            while (index >= 0 && intervalNum < array[index]){

                //数据大的右移
                array[index+1] = array[index];

                index--;

            }

            array[index+1] = intervalNum;
        }



    }

    private static int partition(int[] array,int low, int high){

        int start = low;
        int end = high;

        int base = array[low];

        //从后往前找比基准值小的
        while (start < end  ){

            while (start < end && array[end] >= base)
            {
                end--;
            }

            if (start < end){

                array[start] = array[end];
                start++;
            }


            //从前往后找比基准值大的
            while (start < end && array[start] < base){

                start++;
            }

            if (start < end){

                array[end] = array[start];
                end--;
            }

        }

        array[start] = base;
        return start;

    }

    /**
     *  快速排序，时间复杂度 O(nlog(n))
     * @param array 待排序数组
     *  @param low 需要利用快速排序的数组的起始位置；
     *  @param high 需要利用快速排序的数组的末尾位置;
     */
    public static void fastSort(int[] array, int low, int high){
        if (low < high){
            int index =  partition(array,low,high);
            fastSort(array,low,index-1);
            fastSort(array,index+1,high);
        }

    }

    /**
     * 归并
     * @param array 局部有序的数组
     * @param left  左边有序数组的下边界
     * @param center 左边有序数组的上边界，center+1 为右边有序数组的下边界
     * @param right 右边有序数组的上边界
     */

    private static void merger(int[] array, int left, int center, int right){

        int[] tempArr = new int[array.length];

        // 记录左边的数组的下边界
        int leftLow = left;

        //记录右边数组的下边界
        int rightLow = center+1;

        //记录临时数组的索引
        int index = left;

        while (leftLow <= center && rightLow <= right){

            if (array[leftLow] <= array[rightLow]){

                tempArr[index++] = array[leftLow];
                leftLow++;
            }else {

                tempArr[index++] = array[rightLow];
                rightLow++;
            }
        }


        /*
           下面是把左右数组中剩余部分直接添加到缓存数组中，其实下面只会执行其中的一个
         */
        while (leftLow <= center){

            tempArr[index++] = array[leftLow++];
        }

        while (rightLow <= right){

            tempArr[index++] = array[rightLow++];
        }

//        System.out.println(Arrays.toString(tempArr));
        //把临时数组中的数据赋值给原数组
        index = left;
        while (index <= right){

            array[index] = tempArr[index++];
        }

    }

    /**
     * 归并排序：O(nlog(n))
     * @param array
     * @param left
     * @param right
     */

    public static void mergerSort(int[] array,int left,int right){

        if (left >= right){
            return;
        }

        int mid = (left + right)/2;

        // 对左边数组进行递归
        mergerSort(array,left,mid);

        //对有点数组进行递归
        mergerSort(array,mid+1,right);


        merger(array,left,mid,right);


    }


}
