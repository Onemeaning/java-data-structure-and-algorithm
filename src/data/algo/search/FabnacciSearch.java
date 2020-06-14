package data.algo.search;

import java.util.Arrays;

public class FabnacciSearch {

    private static final int MAXSIZE = 20;
    public static void main(String[] args){

        int[] data = {4,2,30,4,5,7,6,11,3,111};
        Arrays.sort(data);

        System.out.println(Arrays.toString(data));

        System.out.println(fabnacciSearch(data,11));


    }


    /**
     * 斐波那契数列数组;
     * @return
     */
    private static int[] fab(){

        int[] fab = new int[MAXSIZE];
        fab[0] = 1;
        fab[1] = 1;

        for (int i = 2; i < 20; i++) {
            fab[i] = fab[i-1] + fab[i-2];
        }
        return fab;
    }


    private static int fabnacciSearch(int[] data , int key){

        int low = 0;
        int high = data.length-1;

        int k = 0; //表示斐波那契分割数值的下标；
        int mid = 0;//表示分割的索引;

        int[] fab = fab();

        //找到大于数组中数值个数最小的斐波那契值
        while (high > fab[k] -1){
            k++;
        }

        //因此此时数组的长度是小于等于fab[k]的，所以需要对数组进行扩充；

        int[] temp = Arrays.copyOf(data,fab[k]);
        //因此这是一个有序的数组，固然最后填充的值需要用原数组中最大值进行填充；
        for (int i = data.length; i < temp.length; i++) {

            temp[i] = data[high];
        }

        while (low <= high){

            mid = low + fab[k]-1;

            if (key < temp[mid]){

                high = mid -1;

                //由于f[k] = f[k-1] + f[k-2]
                // 由于前面是有f[k-1] 个元素，可以继续差分f[k-1] = f[k-2] +  f[k-3];
                k--;
            }
            else if (key > temp[mid]){
                low = mid + 1;
                k -= 2;
            }
            else {

                if (mid <= high){
                    return mid;
                }
                else
                    return high;
            }

        }

        return  -1;


    }



}
