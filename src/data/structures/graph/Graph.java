package data.structures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 这里介绍的图的创建，顶点采用ArrayList保存，
 * 边采用邻接矩阵的方式存储
 *
 * 图的遍历：
 * （1）深度优先搜索 DFS
 * （2）广度优先搜索 BFS
 */

public class Graph {

    private ArrayList<String> vertexList; //保存顶点的集合
    private int[][] edges;//存储图对应的邻接矩阵；
    private int edgeNums; //存储边的个数；

    private boolean[] isVisited; //保存每个节点是否访问

    public static void main(String[] args){

/*        int n = 5;
        String[] vertexes = new String[]{"A","B","C","D","E"};

        Graph graph = new Graph(n);

        // 添加顶点
        for (int i = 0; i < n; i++) {
            graph.inserVertex(vertexes[i]);
        }

        //添加边

        graph.insertEdges(0,1,1);//A--B
        graph.insertEdges(0,2,1);//A--C
        graph.insertEdges(1,2,1);//B--C
        graph.insertEdges(1,3,1);//B--D
        graph.insertEdges(1,4,1);//B--E


        graph.showGraph();

//        System.out.println("深度优先搜索");
//        graph.dfs();

        System.out.println("广度优先搜索");
        graph.bfs();*/


        /*
            展示广度优先，深度优先的区别；
         */

        int n = 8;
        String[] vertexes = new String[]{"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(n);

        for (int i = 0; i < n; i++) {
            graph.inserVertex(vertexes[i]);
        }

        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1,3, 1);
        graph.insertEdges(1, 4, 1);
        graph.insertEdges(3, 7, 1);
        graph.insertEdges(4, 7, 1);
        graph.insertEdges(2, 5, 1);
        graph.insertEdges(2, 6, 1);
        graph.insertEdges(5, 6, 1);

        graph.showGraph();
//        graph.dfs();
        graph.bfs();

    }


    public Graph(int n){

        vertexList = new ArrayList<>();
        edges = new int[n][n];

        isVisited = new boolean[n];

    }

    //添加顶点
    public void inserVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加顶点之间的边
    public void insertEdges(int v1, int v2,int weight){

        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeNums++;
    }

    //返回顶点的个数
    public int getVertexs(){
        return vertexList.size();
    }

    //返回边的数量
    public int getEdges(){
        return edgeNums;
    }

    //返回节点i的数据
    public String getValueByIndex(int index){
        return vertexList.get(index);
    }

    //返回两个顶点之间的边的情况
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //显示邻接矩阵
    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    /************************深度优先搜索Start****************************************/

    /**
     * 查找一个顶点的第一个相邻的节点。
     * @param i 待查找第一个相邻节点的下标
     * @return -1 表示没有找到，否则返回数组的下标。
     */
    private int getFirstNeighbor(int i){

        for (int j = 0; j < getVertexs(); j++) {

            if (edges[i][j] > 0)
                return j;
        }
        return -1;
    }

    /**
     * 根据前一个相邻的顶点的下标，来获取下一个相邻的顶点。
     * @param v1 前一个相邻顶点的下标，下一个相邻顶点的下标。
     * @param v2
     * @return
     */
    private int getNextNeighbor(int v1, int v2){

        for (int j = v2+1; j < getVertexs(); j++) {

            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 对一个节点的深度优先搜索
     * @param start 搜索的起始位置的下标
     */
    private void dfs(boolean[] isVisited ,int start){

        System.out.print(getValueByIndex(start) + "-->");

        //获取第一个相邻顶点的下标值：
        int w = getFirstNeighbor(start);
        isVisited[start] = true;

        //有相邻的顶点；
        while (w != -1){

           if (!isVisited[w]){
               //没有被访问，则会以当前的节点作为起始顶点递归访问
               dfs(isVisited,w);
           }

           //如果w顶点已经被访问了
           w = getNextNeighbor(start, w);

        }
    }

    /**
     * 深度优先搜索
     */
    public void dfs(){

        for (int i = 0; i < getVertexs(); i++) {
            if (!isVisited[i])
                dfs(isVisited,i);
        }

    }

    /*************************************深度优先搜索END*******************************************/


    /*************************************广度优先搜索START*******************************************/

    /**
     * 对一个节点的广度优先搜索
     * @param isVisited 顶点访问情况分析
     * @param start 节点索引
     */
    private void bfs(boolean[] isVisited, int start){

        int u; //队列头结点的下标；
        int w; //邻接节点

        LinkedList<Integer> queue = new LinkedList<>();//充当队列，记录节点访问的顺序

        System.out.print(getValueByIndex(start) + "-->");
        isVisited[start] = true;
        queue.addLast(start);

        while (!queue.isEmpty()){

            u = queue.removeFirst();
            w = getFirstNeighbor(u);

            while (w != -1){

                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "-->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }

                w = getNextNeighbor(u,w);

            }

        }
    }

    /**
     * 广度优先搜索
     */
    public void bfs(){

        for (int i = 0; i < getVertexs(); i++) {

            if (!isVisited[i])
                bfs(isVisited, i);
        }

    }


}
