package tencent.interview1;

public class SortUtil {

    public static void bubbleSort(int[] array){

        for (int i = 0; i < array.length; i++) {

            for (int j = i; j < array.length ; j++) {


                if (array[j] > array[i]){

                    int temp = array[j];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }

        }
    }
}
