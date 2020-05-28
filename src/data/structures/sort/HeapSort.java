package data.structures.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args){

        int[] arr = {8,5,7,6,4,3,2,9,1,10};

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    private static void heapSort(int[] arr){
        int temp  = 0;
        System.out.println("堆排序！");

        // 1)将待排序序列构造成一个大顶堆
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }

        // 2)将其与末尾元素进行交换，此时末尾就为最大值。
        // 3)然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。
        // 如.此反复执行，便能得到一个有序序列了。

        for (int j = arr.length-1; j > 0 ; j--) {

            //交换
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            adjustHeap(arr,0,j);
        }

    }

    /**
     * 将索引为index的非叶子节点调整为  大顶堆；
     * @param arr 待调整的数组
     * @param index 待调整的非叶子结点的索引
     * @param len 对多少个元素继续调整，是逐渐减少的
     */
    private static void adjustHeap(int[] arr,int index,int len){

        int temp = arr[index];

        //i 表示索引为index节点的左子结点
        for (int i = index*2+1; i < len; i = i*2+1) {

            if (i+1 < len && arr[i] < arr[i+1])//比较左右子结点的大小，找到大的那个结点
            {
                i++;
            }

            if (arr[i] > temp){
                arr[index] = arr[i];
                index = i;
            }
            else {
                break;
            }
        }

        arr[index] = temp;

    }

}
