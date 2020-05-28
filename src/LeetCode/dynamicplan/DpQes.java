package LeetCode.dynamicplan;

import java.util.Scanner;

public class DpQes {

    public static void main(String[] args){



 /*       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        System.out.println(dpTest(nums));*/


    }


    /**
     * 小招在玩一款游戏：在一个N层高的金字塔上，以金字塔顶为第一层，第i层有i个落点，
     * 每个落点有若干枚金币，在落点可以跳向左斜向下或向右斜向下的落点。
     * 若知道金字塔的层数N及每层的金币数量分布，请计算小招在本次游戏中可以获得的最多金币数量。
     *
     * 输入共有N + 1行(N ≤ 1024)，第一行为高度N，第二行至N + 1行 ，为该金字塔的金币数量分布。
     * 输出金币数量。
     *
     * 5
     * 8
     * 3 8
     * 8 1 0
     * 4 7 5 4
     * 3 5 2 6 5
     *
     * 31
     *
     */

    public static int dpTest(int[][] nums){

        int[][] dp = new int[nums.length+1][nums.length+1];

        for (int i = nums.length-1; i >=0; i--) {

            for (int j = 0; j <= i; j++) {
                dp[i][j] = nums[i][j] + Math.max(dp[i+1][j],dp[i+1][j+1]);
            }

            System.out.println();
        }

        return dp[0][0];

    }


    //---------------------------------------------------------------
    /**
     * leetcode 53 最大子序和： 使用动态规划的方法求解（DP）
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        int size = nums.length;
        int[] dp = new int[size]; //用于存储以索引i结尾的连续子数组的最大和

        dp[0] = nums[0];//初始化
        int ans = dp[0];

        for (int i = 1; i < size ; i++) {
            dp[i] =  Math.max(dp[i-1] + nums[i],nums[i]);
            ans = Math.max(dp[i],ans);
        }

//       System.out.println(Arrays.toString(dp));
        return ans;
    }

}
