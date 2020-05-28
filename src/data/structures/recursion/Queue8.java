package data.structures.recursion;

/**
 * 八皇后问题的求解方案，采用递归的方式进行求解；
 */
public class Queue8 {

    private static final int MAX = 8;//定义是8皇后问题；

    //定义一个棋盘
    // map[index] = value; 表示将第 index 个皇后放在第 index 行的第index列；
    int[] map = new int[MAX];

    static int count = 0;
    public static void main(String[] args){

        Queue8 queue8 = new Queue8();
        queue8.check(0);

        System.out.printf("一共有%d种解法",count);

    }


    private void check(int n){

        if (n == MAX){
            // 此时已经摆放完最后一组了，说明一组摆放已经成功，直接打印并返回；
            print();
            return;
        }

        //从第一列到最后一列进行遍历；
        for (int i = 0; i < MAX; i++) {

            //先把当前这个皇后n，放在改行的第1列；
            map[n] = i;

            //判断放置第n个皇后到i列的时候，是否有冲突；
            if (judge(n)){
                //接着开始放置第n+1个皇后
                check(n+1);
            }

            //如果有冲突则将第n个皇后放置在第i+1列再次进行尝试；

        }

    }


    /**
     * 判断是否满足
     * @param n 第n个皇后，放在第n行的情况
     * @return
     */
    private boolean judge(int n){

        //判断前n-1列是否会有冲突；
        for (int i = 0; i < n; i++) {
            /*说明：
              （1）map[i] == map[n]：说明在同一列；
             *（2）Math.abs(n - i) == Math.abs(map[n] - map[i]：说明在同一对角线上面；（行之差等于列之差）；
             *（3）是否在同一行不用判断了，因为默认是从第一行到底MAX行进行摆放的，不会放在同一行；
             */

            if (map[i] == map[n] || Math.abs(n - i) == Math.abs(map[n] - map[i])){
                return false;
            }

        }
        //前n-1行都没有冲突，则第n个皇后放在当前的位置是可行的；
        return true;
    }


    private void print(){
        count++;
        for (int i = 0; i < MAX; i++) {
            System.out.print(map[i] + " ");
        }
        System.out.println();

    }


}
