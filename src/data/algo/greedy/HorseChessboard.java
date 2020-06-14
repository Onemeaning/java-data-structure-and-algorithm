package data.algo.greedy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HorseChessboard {

    private static int X;//棋盘的行数
    private static int Y; //棋盘的列数；

    //表示棋盘的某个位置是否被访问
    private static boolean[][] visited;

    //表示访问是否完成了
    private static boolean finished;


    public static void main(String[] args){

        X = 6;
        Y = 6;
        visited = new boolean[X][Y];
        int[][] chessboard = new int[X][Y];

        //初始位置
        int priX = 2;
        int priY = 4;

        System.out.println("马踏棋盘算法开始运行……");
        long start = System.currentTimeMillis();
        travesalChessboard(chessboard,priX-1,priY-1,1);

        for(int[] row : chessboard){
            for (int step : row){
                System.out.print(step +"\t");
            }
            System.out.println();
        }

        System.out.println("总共耗时为：" + (System.currentTimeMillis() - start) + "ms" );

    }

    /**
     * 马踏棋盘算法：
     * @param chess 棋盘，用于保存走的步骤
     * @param x 初始点的行数
     * @param y 初始点的列数
     * @param step 走的步数
     */
    public static void travesalChessboard(int[][] chess,int x, int y, int step){

        chess[x][y] = step;
        visited[x][y] = true;
        List<Point> ps = next(new Point(x, y));
        sort(ps);
        while (!ps.isEmpty()){

            Point point = ps.remove(0);
            if (!visited[point.x][point.y]){
                travesalChessboard(chess,point.x,point.y,step+1);
            }
        }

        // 如果走的步数没有达到棋盘的数量，说明没有走完，
        if (step < X*Y && !finished){
            chess[x][y] = 0;  //回溯，表示该点往下是走不通的；
            visited[x][y] = false;
        }
        else {
            finished = true;
        }
    }

    /**
     * 获取每一个点，接下来可以走的所有的点的位置；
     * @param cur
     * @return
     */
    public static List<Point> next(Point cur){

        List<Point> ps = new ArrayList<>();
        Point p1 = new Point();

        if ((p1.x = cur.x - 2) >= 0 && (p1.y = cur.y -1) >=0 ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x - 1) >= 0 && (p1.y = cur.y -2) >=0 ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x + 1) < X && (p1.y = cur.y -2) >=0 ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x + 2) < X && (p1.y = cur.y -1) >=0 ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x + 2) < X && (p1.y = cur.y +1) < Y ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x + 1) < X && (p1.y = cur.y +2) < Y ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x - 1) >= 0 && (p1.y = cur.y +2) < Y ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x - 2) >= 0 && (p1.y = cur.y + 1) < Y ){
            ps.add(new Point(p1));
        }

        return ps;
    }

    //对下一步要走的每一个点进行排序，排序原则，每个点下一步要走的点的个数越多，回溯的可能性越大，
    //因此按照要走点的个数从少到多进行排序
    public static void sort(List<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int c1 = next(o1).size();
                int c2 = next(o2).size();

                if (c1 < c2){
                    return -1;
                }else if (c1 == c2){
                    return 0;
                }
                else
                    return 1;
            }
        });
    }


}
