package alibaba.interview1;

import java.util.Scanner;


public class Test3 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long res = 0;

        for (int i = 1; i <= n; i++) {

            long temp = compact(n,i);
            res += temp *i;
        }

        System.out.println((res % (long)(Math.pow(10,9)+7)));

    }


    public static long compact(long n, long x){

        double temp = 0;
        double res = 1;
        for (int i = 0; i < x; i++) {

            temp = ((double) (n-i))/(x-i);
            res *= temp;

        }
        return (long)res;
    }

}
