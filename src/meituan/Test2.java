package meituan;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int x = 0;
        int temp = x;
        int sum = temp;
        int kk = 1;

        while (sum < n){

            x++;
            kk = 1;
            sum = 0;
            while ((temp = x / kk) != 0){

                sum += temp;
                kk = kk*k;

//                System.out.println("x = " + x);
//                System.out.println("temp = " + temp);
//                System.out.println("sum = " + sum);
//                System.out.println("kk = " + kk);

            }

        }


        System.out.println(x);
    }
}
