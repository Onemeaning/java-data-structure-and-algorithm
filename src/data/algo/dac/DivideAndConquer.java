package data.algo.dac;

/**
 * 分治算法的案例汇总；
 * * 二分搜索
 * * 大整数乘法
 * * 棋盘覆盖
 * * 合并排序
 * * 快速排序
 * * 线性时间选择
 * * 最接近点对问题
 * * 循环赛日程表
 * * 汉诺塔
 * @author meanlam
 * @date 2020/6/1-19:52
 */
public class DivideAndConquer {

    static int conunt = 0;
    public static void main(String[] args){

        hanoiTower(5, 'A', 'B', 'C');
        System.out.println("总共搬运了 " + conunt +"次");
    }


    /**
     * 分支算法——汉诺塔
     * @param nums 圆盘数量
     * @param a 柱子 A
     * @param b 柱子 B
     * @param c 柱子 C
     */
    public static void hanoiTower(int nums, char a, char b, char c){

        if (nums == 1) {
            conunt++; // 类变量（静态变量），用于保存搬运的次数
            System.out.println("第1个圆盘" + a + "-->" + c);
        }
        
        //如果我们有n>=2情况，我们总是可以看做是两个盘: 1.最下边的一个盘 2上面的n-1个盘
        else {

            //1)先把最上面的盘 A -> B,中间借用C作为辅助的柱子
            hanoiTower(nums-1, a, c, b);

            //2)把最下边的盘 A -> C
            System.out.println("第" + (nums-1) +"个圆盘" + a + "-->" + c);
            conunt++;
            //3)把B塔的所有盘从 B -> C,中间借用A作为辅助的柱子

            hanoiTower(nums-1, b, a, c);
        }

    }


}
