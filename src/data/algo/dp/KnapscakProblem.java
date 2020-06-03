package data.algo.dp;

/**
 * 动态规划解决 0-1背包问题（每个物品只能选择一次）：
 *
 *
 * @author meanlam
 * @date 2020/6/1-21:29
 */
public class KnapscakProblem {
    

    public static void main(String[] args){

        int[] weight = {1,4,3};
        int[] val = {1500,3000,2000};
        int size = 4;//背包的容量
        int nums = val.length; // 物品的数量

        int[][] dp = new int[nums+1][size+1]; //动态规划最优表，查表就可以知道最优解
        int[][] paths = new int[nums+1][size+1]; // 保存最优解情况下，添加了那些物品；
        
        
        for (int i = 0; i < size; i++) { //第一列（背包容量为0）始化为0，表示：当背包的容量为0的时候，任何物品都装不下，价值为0；
            dp[i][0] = 0;
        }

        for (int j = 0; j < nums; j++) {//第一行（没有物品可选）初始化为0，表示：当没有物品可选的时候，背包容量为任何值，价值为0.
            dp[0][j] = 0;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
             
                if (weight[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                    
                }else{
                    
//                    dp[i][j] = Math.max(dp[i-1][j],val[i-1] + dp[i-1][j-weight[i-1]]);// 这种方式没法记录，添加了哪些商品；

                    if (dp[i-1][j] < val[i-1] + dp[i-1][j-weight[i-1]]){ //这有这种情况下才是组合加入的；

                        dp[i][j] = val[i-1] + dp[i-1][j-weight[i-1]];
                        paths[i][j] = 1;
                    }
                    else
                        dp[i][j] = dp[i-1][j];

                }
            }
        }
        
        
        //----------------------------------------------------------------------------

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[i].length; j++) {
                
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        int i = nums;//行最大下标
        int j = size;//列最大下标

        while (i > 0 && j > 0){

            if (paths[i][j] == 1){

                System.out.printf("背包中添加的商品编号为：%d \n",i);
                j = j - weight[i-1];//剩余背包的容量；
            }

            i--;
        }
        
    }
    
    

}
