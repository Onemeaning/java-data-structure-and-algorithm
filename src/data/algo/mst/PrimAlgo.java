package data.algo.mst;


import java.util.Arrays;

/**
 * @author meanlam
 * @date 2020/6/3-16:03
 */
public class PrimAlgo {

    public static final int NAN = Integer.MAX_VALUE; // 表示两个节点之间是不连通的；
    public static void main(String[] args){

        char[] vertexName = new char[]{'A','B','C','D','E','F','G'};
        int vertexNums = vertexName.length;
        int[][] weights = new int[][]{
        {NAN, 5,7,NAN , NAN, NAN,2},
        {5, NAN, NAN,9, NAN, NAN,3},
        {7,NAN, NAN , NAN, 8, NAN, NAN},
        {NAN, 9, NAN, NAN, NAN ,4, NAN},
        {NAN, NAN, 8, NAN,NAN,5,4},
        {NAN, NAN, NAN,4, 5, NAN,6},
        {2,3, NAN, NAN,4,6, NAN},};

        MGraph graph = new MGraph(vertexNums);

        MSTree msTree = new MSTree();
        msTree.createMsTree(graph, vertexNums, vertexName, weights);
        msTree.showWeights(graph);

        msTree.prim(graph, 3);

    }
}



class MSTree{


    public void createMsTree(MGraph graph, int vertexNums, char[] vertexName, int[][] weights){

        for (int i = 0; i < vertexNums; i++) {
            graph.vertexName[i] = vertexName[i];
            for (int j = 0; j < vertexNums; j++) {
                graph.weight[i][j] = weights[i][j];
            }
        }
    }


    public void showWeights(MGraph graph){

        for (int[] link : graph.weight){
            
            System.out.println(Arrays.toString(link));
        }

    }

    /**
     *
     * @param graph 原始图
     * @param index 初始访问的节点索引
     */
    public void prim(MGraph graph, int index){

        boolean[] visited = new boolean[graph.vertexNums];
        visited[index] = true;

        int minWeight = Integer.MAX_VALUE;//路径不通
        int preIndex = -1; // 表示访问过的节点
        int postIndex = -1; // 表示还没有访问过的节点

        int mileage = 0;

        for (int k = 1; k < graph.vertexNums; k++) {

            for (int i = 0; i < graph.vertexNums; i++) {
                for (int j = 0; j < graph.vertexNums; j++) {

                   if (visited[i] && !visited[j] && graph.weight[i][j] < minWeight){

                       minWeight = graph.weight[i][j];
                       preIndex = i;
                       postIndex = j;

                   }

                }
            }

            System.out.println("Edge <" + graph.vertexName[preIndex] + "————" + graph.vertexName[postIndex] + "> " + minWeight);
            mileage += minWeight;

            visited[postIndex] = true;
            minWeight = Integer.MAX_VALUE;

        }
        System.out.println("总里程为： "+mileage);

    }
}



class MGraph{

    int vertexNums;
    char[] vertexName;
    int[][] weight;

    public MGraph(int vertexNums) {
        this.vertexNums = vertexNums;
        vertexName = new char[vertexNums];
        weight = new int[vertexNums][vertexNums];

    }
}