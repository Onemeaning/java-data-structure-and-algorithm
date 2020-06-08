package data.algo.dijkstra;

import javax.xml.bind.Binder;
import java.util.Arrays;

/**
 * @author meanlam
 * @date 2020/6/8-16:10
 */
public class DijkstraAlo {

    private static final int INF = Integer.MAX_VALUE/2;
    public static void main(String[] args){

        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = new int[][]{
                {INF, 5,7,INF , INF, INF,2},
                {5, INF, INF,9, INF, INF,3},
                {7,INF, INF , INF, 8, INF, INF},
                {INF, 9, INF, INF, INF ,4, INF},
                {INF, INF, 8, INF,INF,5,4},
                {INF, INF, INF,4, 5, INF,6},
                {2,3, INF, INF,4,6, INF},};

        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
        graph.dijkstra(6);
        graph.showResult(6);
    }




}

class VisitedVertex{

    private int[] already_vi; // 记录各个节点是否被访问过，1表示访问过了，0表示还没有被访问过,会动态的更新
    private int[] pre_vi; // 每个下标对应的值为前一个节点的下标，会动态的更新
    private int[] dis; // 记录出发节点到其他各个顶点的距离，会动态的更新；
    private static final int INF = Integer.MAX_VALUE/2;
    /**
     * 初始化各个数组
     * @param len 节点的个数
     * @param index 开始访问的节点的下标
     */
    public VisitedVertex(int len, int index) {

        already_vi = new int[len];
        pre_vi = new int[len];
        dis = new int[len];
        
        already_vi[index] = 1;
        Arrays.fill(dis, INF);
        dis[index] = 0;
    }

    /**
     * 判断 index下标的所对应的节点是否被访问过了
     * @param index
     * @return
     */
    public boolean in(int index){
        return already_vi[index] == 1;
    }

    /**
     * 更新出发节点到index节点的距离
     * @param index 目标节点的索引
     * @param len 更新的距离
     */
    public void updateDis(int index, int len){
        dis[index] = len;
    }

    /**
     * 更新节点pre的前驱节点为index结果
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index){
        pre_vi[pre] = index;
    }

    /**
     * 获取节点到index节点的距离
     * @param index
     * @return
     */
    public int getDis(int index){
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问节点，比如这里的G访问结束之后，就是A点作为访问顶点（注意不是出发顶点）
     * 其实就是在找没有访问过的节点中距离最小的那个节点作为下次访问的节点
     * @return
     */
    public int updateAlreadyVisited(){

        int min = INF, index = 0;
        for (int i = 0; i < already_vi.length; i++) {

            if (!in(i) && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        already_vi[index] = 1;
        return index;
    }

    public void showFinalDis(int index){
        char[] vertex = {'A','B','C','D','E','F','G'};
        System.out.println("===========迪杰斯特拉最短路径结果==========");
        for (int i = 0; i < dis.length; i++) {
            System.out.println(vertex[index] + "————>"+ vertex[i] + " : " + dis[i]);
        }
    }

}

class Graph{

    char[] vertex;
    int[][] matrix;
    VisitedVertex vv;
    private static final int INF = Integer.MAX_VALUE/2;
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph(){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == INF)
                    System.out.printf("%5s","INF");
                else
                    System.out.printf("%5d",matrix[i][j]);
            }
            System.out.println();
        }

    }

    public void dijkstra(int index){
        vv = new VisitedVertex(vertex.length, index);
        update(index);

        for (int i = 1; i < vertex.length ; i++) {
            index = vv.updateAlreadyVisited();
            update(index);
        }

    }

    public void showResult(int index){
        vv.showFinalDis(index);
    }

    /**
     * 一次遍历的更新
     */
    private void update(int index){
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {

            // 出发顶点到index 节点的距离 + index节点到 i 节点的距离之和 （弯路）
            len = vv.getDis(index) + matrix[index][i];

            //当 i 这个节点还没有被访问过，且 len 小于出发顶点直接到i这个顶点的距离（直路）时，需要更新
            if (!vv.in(i) && len < vv.getDis(i)){

                vv.updateDis(i, len);
                vv.updatePre(i, index);
            }

        }
    }


}