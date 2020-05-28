package tencent.interview3;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();

        for (int i = 0; i < n; i++) {

            int nums = scanner.nextInt();
            int k = scanner.nextInt();

            int left  = 1;
            int count = 1;
            while (left < nums){
                left = left *2;
                count++;
            }
            left = left/2;
            count--;

            if (k >= count){

                System.out.println(-1);
            }
            else {

                System.out.println(nums/(int) (Math.pow(2,(count-k))));
            }

        }

    }

}
