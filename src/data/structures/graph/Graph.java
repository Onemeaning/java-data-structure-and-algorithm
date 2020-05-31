package data.structures.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private ArrayList<String> vertexList; //保存顶点的集合
    private int[][] edges;//存储图对应的邻接矩阵；
    private int edgeNums; //存储边的个数；

    public static void main(String[] args){

        int n = 5;
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

    }


    public Graph(int n){

        vertexList = new ArrayList<>();
        edges = new int[n][n];

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

}
