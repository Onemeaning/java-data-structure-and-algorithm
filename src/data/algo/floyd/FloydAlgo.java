package data.algo.floyd;

import java.util.Arrays;

/**
 * @author meanlam
 * @date 2020/6/9-9:48
 */
public class FloydAlgo {

    private static final int INF = Integer.MAX_VALUE/2;
    public static void main(String[] args){

        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = new int[][]{
                {0, 5,7,INF , INF, INF,2},
                {5, 0, INF,9, INF, INF,3},
                {7,INF, 0 , INF, 8, INF, INF},
                {INF, 9, INF, 0, INF ,4, INF},
                {INF, INF, 8, INF,0,5,4},
                {INF, INF, INF,4, 5, 0,6},
                {2,3, INF, INF,4,6, 0},};

        Graph graph = new Graph(vertex.length, vertex, matrix);
        graph.floyd();
        graph.show();
    }
}

class Graph{

    private char[] vertex;
    private int[][] dis; // 存放节点之间的最短路径
    private int[][] pre; // 存放节点的前驱节点
    private static final int INF = Integer.MAX_VALUE/2;

    public Graph(int len, char[] vertex, int[][] dis) {
        this.vertex = vertex;
        this.dis = dis;

        pre = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(pre[i],i);
        }
    }

    public void floyd(){

        int len = 0;
        for (int k = 0; k < vertex.length; k++) { //对中间节点遍历[A - G]

            for (int i = 0; i < vertex.length; i++) { // 出发节点的遍历[A - G]
                for (int j = 0; j < vertex.length; j++) { // 到达目标节点的遍历[A - G]

                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]){
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }

                }
            }
        }
    }


    public void show(){

        System.out.println("距离表");
        for (int i = 0; i < vertex.length; i++) {

            for (int j = 0; j < vertex.length; j++) {

                if (dis[i][j] == INF)
                {
                    System.out.printf("<%10s>",vertex[i] +"——"+ vertex[j]+" INF");
                    System.out.print("  ");
                }

                else{
                    System.out.printf("<%10s>",vertex[i]+"——"+ vertex[j]+ " "+ dis[i][j]);
                    System.out.print("  ");
                }


            }
            System.out.println();

        }

        System.out.println("----------------------------------");
        System.out.println("前驱表：");
        for (int i = 0; i < vertex.length; i++) {

            for (int j = 0; j < vertex.length; j++) {

              System.out.print(vertex[pre[i][j]] + " ");
            }
            System.out.println();

        }
    }
}
