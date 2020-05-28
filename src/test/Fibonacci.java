package test;

public class Fibonacci {
/**
 * 采用动态规划算法计算斐波那契数列的第n项；
 * 动态规划算法的三个关键目标：
 * （1）建立状态转移方程 f(n) = f(n-1) + f(n-2)；
 * （2）缓存前 n-1 项的计算结果，否则会让计算复杂度从线性变成指数
 * （3）按顺序从小往大计算
 *
 */

    public static void main(String[] args){

        System.out.println(fab(100));
    }

    public static long fab(int n){

        long[] result = new long[n+1];
        for (int i = 0; i < n+1; i++) {

            if (i<2)
                result[i] = i;
            else
                /*
                    缓存结果，使得计算量降为线性的；
                 */
                result[i] = result[i-1] + result[i-2];
        }

        return result[n];

    }
}
