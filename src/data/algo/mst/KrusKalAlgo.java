package data.algo.mst;

import java.util.*;

/**
 * @author meanlam
 * @date 2020/6/6-11:04
 */
public class KrusKalAlgo {

    private int edgeNum;
    private char[] vertexs;
    private int[][] matrix;

    private static final int INF = Integer.MAX_VALUE;

    public KrusKalAlgo(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;

        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF)
                    edgeNum++;
            }
        }
    }

    public void print(){
        System.out.println("邻接矩阵为：");
        for (int[] link : matrix){
            for (int i = 0; i < link.length; i++) {
                if (link[i] == INF)
                    System.out.printf("%5s","INF");
                else
                    System.out.printf("%5d",link[i]);
            }
            System.out.println();

        }
    }

    public List<Edge> createEdges(){
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {

                if (matrix[i][j] != INF)
                    list.add(new Edge(vertexs[i],vertexs[j],matrix[i][j]));
            }
        }
        return list;
    }

    /**
     * 获取 index 索引对应的顶点的终点；
     * @param ends
     * @param index
     * @return
     */
    private int getEnd(int[] ends, int index){

        while (ends[index] != 0){
            index = ends[index];
        }

        return index;
    }

    private Map<Character,Integer> createMap(){

        Map<Character,Integer> maps = new HashMap<>();
        for (int i = 0; i < vertexs.length; i++) {
            maps.put(vertexs[i],i);
        }

        return maps;
    }

    public List<Edge> kruskal(){

        int[] ends = new int[edgeNum];//保存已经存在的节点，用于检测已有最小生成树中是否会形成环
        List<Edge> mstResult = new ArrayList<>();
        List<Edge> edges = createEdges();
        Collections.sort(edges);
        Map<Character, Integer> posMap = createMap();

        for (Edge edge : edges){

            int start_index = posMap.get(edge.start);
            int end_index = posMap.get(edge.end);

            int ends_start = getEnd(ends,start_index);
            int ends_end = getEnd(ends,end_index);

            if (ends_start != ends_end){
                mstResult.add(edge);
                ends[ends_start] = ends_end;
            }
        }

        return mstResult;
    }



    public static void main(String[] args){

    char[] vertex = {'A','B','C','D','E','F','G'};
    int[][] matrix = {
               /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
        /*A*/ { 0,12, INF, INF, INF, 16, 14},
        /*B*/ { 12, 0, 10,INF, INF, 7, INF},
        /*C*/ { INF, 10, 0, 3, 5, 6, INF},
        /*D*/ { INF, INF, 3, 0, 4, INF, INF},
        /*E*/ { INF, INF, 5, 4, 0, 2, 8},
        /*F*/ { 16,   7, 6, INF, 2, 0, 9},
        /*G*/ { 14, INF, INF, INF, 8, 9, 0}};

        KrusKalAlgo krusKal = new KrusKalAlgo(vertex, matrix);
        krusKal.print();


        List<Edge> lists = krusKal.createEdges();
        System.out.println("原始边：");
        for (Edge edge : lists){
            System.out.println(edge);
        }

        System.out.println("排序后的边：");
        Collections.sort(lists);
        for (Edge edge : lists){
            System.out.println(edge);
        }

        System.out.println("最小生成树：");
        List<Edge> mst = krusKal.kruskal();
        for (Edge edge : mst){
            System.out.println(edge);
        }

    }

}

class Edge implements Comparable<Edge>{

    char start; // 一条边的左顶点
    char end;   // 一条边的右顶点
    int weight; // 边上面的权重

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge<" + start + " —————— " + end + "> weight = " + weight ;
    }


    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }


}

