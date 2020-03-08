package ccf_csp;

import java.util.Scanner;

public class CCF2015_12_3 {
    /*
    试题编号：	201512-3
试题名称：	画图
时间限制：	1.0s
内存限制：	256.0MB
问题描述：
问题描述
　　用 ASCII 字符来画图是一件有趣的事情，并形成了一门被称为 ASCII Art 的艺术。例如，下图是用 ASCII 字符画出来的 CSPRO 字样。
　　..____.____..____..____...___..
　　./.___/.___||.._.\|.._.\./._.\.
　　|.|...\___.\|.|_).|.|_).|.|.|.|
　　|.|___.___).|..__/|.._.<|.|_|.|
　　.\____|____/|_|...|_|.\_\\___/.
　　本题要求编程实现一个用 ASCII 字符来画图的程序，支持以下两种操作：
　　 画线：给出两个端点的坐标，画一条连接这两个端点的线段。简便起见题目保证要画的每条线段都是水平或者竖直的。水平线段用字符 - 来画，竖直线段用字符 | 来画。如果一条水平线段和一条竖直线段在某个位置相交，则相交位置用字符 + 代替。
　　 填充：给出填充的起始位置坐标和需要填充的字符，从起始位置开始，用该字符填充相邻位置，直到遇到画布边缘或已经画好的线段。注意这里的相邻位置只需要考虑上下左右 4 个方向，如下图所示，字符 @ 只和 4 个字符 * 相邻。
　　.*.
　　*@*
　　.*.
输入格式
　　第1行有三个整数m, n和q。m和n分别表示画布的宽度和高度，以字符为单位。q表示画图操作的个数。
　　第2行至第q + 1行，每行是以下两种形式之一：
　　 0 x1 y1 x2 y2：表示画线段的操作，(x1, y1)和(x2, y2)分别是线段的两端，满足要么x1 = x2 且y1 ≠ y2，要么 y1 = y2 且 x1 ≠ x2。
　　 1 x y c：表示填充操作，(x, y)是起始位置，保证不会落在任何已有的线段上；c 为填充字符，是大小写字母。
　　画布的左下角是坐标为 (0, 0) 的位置，向右为x坐标增大的方向，向上为y坐标增大的方向。这q个操作按照数据给出的顺序依次执行。画布最初时所有位置都是字符 .（小数点）。
输出格式
　　输出有n行，每行m个字符，表示依次执行这q个操作后得到的画图结果。
样例输入
4 2 3
1 0 0 B
0 1 0 2 0
1 0 0 A
样例输出
AAAA
A--A
样例输入
16 13 9
0 3 1 12 1
0 12 1 12 3
0 12 3 6 3
0 6 3 6 9
0 6 9 12 9
0 12 9 12 11
0 12 11 3 11
0 3 11 3 1
1 4 2 C
样例输出
................
...+--------+...
...|CCCCCCCC|...
...|CC+-----+...
...|CC|.........
...|CC|.........
...|CC|.........
...|CC|.........
...|CC|.........
...|CC+-----+...
...|CCCCCCCC|...
...+--------+...
................
评测用例规模与约定
　　所有的评测用例满足：2 ≤ m, n ≤ 100，0 ≤ q ≤ 100，0 ≤ x < m（x表示输入数据中所有位置的x坐标），0 ≤ y < n（y表示输入数据中所有位置的y坐标）。
     */

    public static int n,m,q;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] fristLine =  scanner.nextLine().trim().split(" ");
         m = Integer.parseInt(fristLine[0]);//column
         n = Integer.parseInt(fristLine[1]);//row
         q = Integer.parseInt(fristLine[2]);//operator numbers

        //init the canvas by char '.'
        char[][] canvas = new char[n][m];
        for (int i = 0;i<n;i++)
        {
            for (int j = 0; j < m; j++)
            {
                canvas[i][j] = '.';
            }
        }


        for (int i = 0; i < q ; i++) {

           String[] operator =  scanner.nextLine().trim().split(" ");
           int flag = Integer.parseInt(operator[0]);

            if (flag == 0)//draw line with '-' or '|'
            {
                int x1 = Integer.parseInt(operator[1]);
                int y1 = Integer.parseInt(operator[2]);
                int x2 = Integer.parseInt(operator[3]);
                int y2 = Integer.parseInt(operator[4]);

                drawLine(x1,y1,x2,y2,canvas);

            }

            else //fill the canvas by a Char
            {
                int x1 = Integer.parseInt(operator[1]);
                int y1 = Integer.parseInt(operator[2]);
                char tag = operator[3].charAt(0);

                fillCanvas(n-1-y1,x1,tag,canvas);
            }
        }


        for (int i = 0;i<n;i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    //注意了 y 对应着行 ； x 对应的这列
    private static void drawLine(int x1, int y1, int x2, int y2, char[][] canvas)
    {
        if (y1 == y2) // Draw a horizontal line with '-'
        {
            int lowBound = Math.min(x1,x2);
            int upBound = Math.max(x1,x2);
            while (lowBound != upBound+1)
            {
                if(canvas[n-1-y1][lowBound] != '|')
                {
                    canvas[n-1-y1][lowBound] = '-';
                }
                else
                {
                    canvas[n-1-y1][lowBound] = '+';
                }
                lowBound++;
            }

        }
        else if (x1 == x2) // draw a  vertical line with '|'
        {
            int lowBound = Math.min(y1,y2);
            int upBound = Math.max(y1,y2);
            while (lowBound != upBound+1)
            {
                if(canvas[n-1-lowBound][x1] != '-')
                {
                    canvas[n-1-lowBound][x1] = '|';
                }
                else
                {
                    canvas[n-1-lowBound][x1] = '+';
                }
                lowBound++;
            }
        }

    }


    private static void fillCanvas(int x, int y, char tag,char[][] canvas)
    {
        if (x >= 0&&x < n && y < m && y >= 0 && canvas[x][y] != '+' && canvas[x][y] != '|' && canvas[x][y] != '-'&&canvas[x][y] != tag ) {
            canvas[x][y] = tag;
            fillCanvas(x + 1, y, tag ,canvas);
            fillCanvas(x - 1, y, tag ,canvas);
            fillCanvas(x, y + 1, tag ,canvas);
            fillCanvas(x, y - 1, tag ,canvas);
      }

    }


}
