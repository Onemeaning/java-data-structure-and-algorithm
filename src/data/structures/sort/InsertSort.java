package data.structures.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 */
public class InsertSort {

    public static void main(String[] args){

        int[] data = {4,2,30,4,5,7,6,11,3,-1};

        insertSort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void insertSort(int[] data){

        int insertData ;
        int insertIndex;

        for (int i = 1; i < data.length; i++) {

            insertData = data[i];
            insertIndex = i-1;

            while (insertIndex >= 0 && insertData < data[insertIndex] ){

                data[insertIndex+1] = data[insertIndex];
                insertIndex--;
            }

            data[insertIndex+1] = insertData;

        }

    }

}
