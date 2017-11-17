package com.dataStructure.graph;

//// 稠密图 - 使用邻接矩阵表示
//public class DenseGraph {
//
//    private int n;  // 节点数
//    private int m;  // 边数
//    private boolean directed;   // 是否为有向图
//    private boolean[][] g;      // 图的具体数据
//
//    // 构造函数
//    public DenseGraph(int n, boolean directed) {
//        assert n >= 0;
//        this.n = n;
//        this.m = 0;    // 初始化没有任何边
//        this.directed = directed;
//        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
//        // false为boolean型变量的默认值
//        g = new boolean[n][n];
//    }
//
//    public int V() {
//        return n;
//    } // 返回节点个数
//
//    public int E() {
//        return m;
//    } // 返回边的个数
//
//    // 向图中添加一个边
//    public void addEdge(int v, int w) {
//
//        assert v >= 0 && v < n;
//        assert w >= 0 && w < n;
//
//        if (hasEdge(v, w))
//            return;
//
//        // 连接 v 和 w
//        g[v][w] = true;
//        if (!directed)
//            g[w][v] = true;
//
//        //  边数 ++
//        m++;
//    }
//
//    // 验证图中是否有从v到w的边
//    boolean hasEdge(int v, int w) {
//        assert v >= 0 && v < n;
//        assert w >= 0 && w < n;
//        return g[v][w];
//    }
//
//    // 返回图中一个顶点的所有邻边
//    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
//    public Iterable<Integer> adj(int v) {
//            assert v >= 0 && v < n;
//            Vector<Integer> adjV = new Vector<Integer>();
//            for(int i = 0 ; i < n ; i ++ )
//            if( g[v][i] )
//            adjV.add(i);
//            return adjV;
//            }
//}


import java.util.ArrayList;
import java.util.List;

// 使用 邻接矩阵 表示 稠密图
public class DenseGraph implements Graph {
    private int n;  // 图中的节点数
    private int m;  // 图中的边数
    private boolean[][] g;  // 邻接矩阵g
    private boolean directed;   // 是否为有向图

    public DenseGraph(int n, boolean directed) {
        this.n = n;     // 初始化图中的节点数量
        this.m = 0;     // 图中边（edge）的数量初始化为0
        this.directed = directed;
        g = new boolean[n][n];      // 邻接矩阵 g 初始化为一个 n*n 的二维矩阵
        // 索引代表图中的节点，g中存储的值为 节点是否有边
    }

    // 返回图中边的数量
    public int E() {
        return m;
    }

    // 返回图中节点的数量
    public int V() {
        return n;
    }

    // 在图中指定的两节点之间加边
    public void addEdge(int v, int w) {
        if (!hasEdge(v, w)) {

            // 连接[v][w]
            g[v][w] = true;

            // 无向图
            if (!directed)
                g[w][v] = true;

            // 图中边的数量+1
            m++;
        }
    }

    // 判断两节点之间是否有边
    public boolean hasEdge(int v, int w) {
        return g[v][w];
    }

    // 返回所有 节点 v 的 邻接节点
    public Iterable<Integer> adjacentNode(int v) {
        // adjacentL 用于存储 v 的邻接节点
        List<Integer> adjacentL = new ArrayList<>();
        // 找到所有与 v 邻接的节点，将其加入 adjacentL 中
        for (int i = 0; i < n; i++) {
            if (g[v][i])
                adjacentL.add(i);
        }
        return adjacentL;
    }

    // 显示图的信息
    public void show() {
        System.out.print("\t");
        for (int i = 0; i < n; i++) {
            System.out.print(i + "\t\t");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < n; j++) {
                System.out.print(g[i][j] + "\t");
            }
            System.out.println();
        }
    }


}