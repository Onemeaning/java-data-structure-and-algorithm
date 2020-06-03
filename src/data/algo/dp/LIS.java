package data.algo.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 最长递增子序列;
 */
public class LIS {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {

            nums[i] = scanner.nextInt();
        }

        int[] results = new int[n];
        results[0] = nums[0];
        int index = 0;


        for (int i = 1; i < n; i++) {

            int temp = nums[i];
            if (temp > results[index]){
                index++;
                results[index] = temp;
            }
            else {

                for (int j = 0; j <= index ; j++) {

                    if (results[j] > temp ){

                        results[j] = temp;
                        break;
                    }
                }
            }


        }

        System.out.println(index+1);



    }

}
