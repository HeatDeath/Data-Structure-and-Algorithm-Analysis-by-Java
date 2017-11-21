package com.dataStructure.weight_graph;

import java.util.ArrayList;
import java.util.List;

// 稠密图 - 邻接矩阵
public class DenseGraph implements WeightedGraph {
    private int vertexCount;    // 节点数量
    private int edgeCount;  // 边数
    private Edge[][] adjacencyMatrix;   // 存放 Edge 的邻接矩阵
    private boolean directed;   // 是否为有向图

    // 构造函数，初始化私有字段
    public DenseGraph(int vertexCount, boolean directed) {
        this.vertexCount = vertexCount;
        this.edgeCount = 0;
        this.directed = directed;
        adjacencyMatrix = new Edge[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++)
            for (int j = 0; j < vertexCount; j++)
                adjacencyMatrix[i][j] = null;   // 邻接矩阵初始为空

    }

    public int V() {    // 返回节点数量
        return vertexCount;
    }

    public int E() {    // 返回边数
        return edgeCount;
    }

    public void addEdge(Edge e) {   // 添加一条边
        if (hasEdge(e.getV(), e.getW()))
            return;
        adjacencyMatrix[e.getV()][e.getW()] = new Edge(e);

        if( e.getV() != e.getW() && !directed )
            adjacencyMatrix[e.getW()][e.getV()] = new Edge(e.getW(), e.getV(), e.getWeight());

        edgeCount++;
    }

    public boolean hasEdge(int v, int w) {  // 判断两节点之间是否有边
        return adjacencyMatrix[v][w] != null;
    }

    public void show() {    // 打印邻接矩阵
        for( int i = 0 ; i < vertexCount ; i ++ ){
            for( int j = 0 ; j < vertexCount ; j ++ )
                if( adjacencyMatrix[i][j] != null )
                    System.out.print(adjacencyMatrix[i][j].getWeight()+"\t");
                else
                    System.out.print("NULL\t");
            System.out.println();
        }
    }

    public Iterable<Edge> adjacentNode(int v) { // 获取邻接节点
        List<Edge> list = new ArrayList<>();
        for (int i = 0;i<adjacencyMatrix[v].length;i++){
            if (adjacencyMatrix[v][i] != null)
                list.add(adjacencyMatrix[v][i]);
        }
        return list;
    }
}


//public class DenseWeightedGraph<Weight extends Number & Comparable>
//        implements WeightedGraph{
//
//    private int n;  // 节点数
//    private int m;  // 边数
//    private boolean directed;   // 是否为有向图
//    private Edge<Weight>[][] g;         // 图的具体数据
//
//    // 构造函数
//    public DenseWeightedGraph( int n , boolean directed ){
//        assert n >= 0;
//        this.n = n;
//        this.m = 0;    // 初始化没有任何边
//        this.directed = directed;
//        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为null, 表示没有任和边
//        // false为boolean型变量的默认值
//        g = new Edge[n][n];
//        for(int i = 0 ; i < n ; i ++)
//            for(int j = 0 ; j < n ; j ++)
//                g[i][j] = null;
//    }
//
//    public int V(){ return n;} // 返回节点个数
//    public int E(){ return m;} // 返回边的个数
//
//    // 向图中添加一个边
//    public void addEdge(Edge e){
//
////        assert e.v() >= 0 && e.v() < n ;
////        assert e.w() >= 0 && e.w() < n ;
//
////        if( hasEdge( e.v() , e.w() ) )
////            return;
////
////        g[e.v()][e.w()] = new Edge(e);
////        if( e.v() != e.w() && !directed )
////            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.wt());
//
////        m ++;
//    }
//
//    // 验证图中是否有从v到w的边
//    public boolean hasEdge( int v , int w ){
//        assert v >= 0 && v < n ;
//        assert w >= 0 && w < n ;
//        return g[v][w] != null;
//    }
//
//    // 显示图的信息
//    public void show(){
//
//        for( int i = 0 ; i < n ; i ++ ){
//            for( int j = 0 ; j < n ; j ++ )
//                if( g[i][j] != null )
//                    System.out.print(g[i][j].getWeight()+"\t");
//                else
//                    System.out.print("NULL\t");
//            System.out.println();
//        }
//    }
//
//    // 返回图中一个顶点的所有邻边
//    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
//    public Iterable<Edge<Weight>> adjacentNode(int v) {
//        assert v >= 0 && v < n;
//        List<Edge<Weight>> adjV = new ArrayList<>();
//        for(int i = 0 ; i < n ; i ++ )
//            if( g[v][i] != null )
//                adjV.add( g[v][i] );
//        return adjV;
//    }
//}