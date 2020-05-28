package zhaoshang;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] rows = new int[n];

        for (int i = 0; i < n; i++) {
            rows[i] = scanner.nextInt();
        }

        int counts = 0;
        for (int i = 0; i < n-1; i+=2) {

            if (rows[i] % 2 ==0 && rows[i+1] == (rows[i] + 1)){//偶数
                continue;
            }
            if (rows[i] % 2 !=0 && rows[i+1] == (rows[i]-1)){
                continue;
            }
            counts++;
        }

        if (counts % 2 == 0){
            System.out.println(counts/2);
        }
        else if (counts % 2 != 0){

            System.out.println(counts/2 + 1);
        }
    }

}
