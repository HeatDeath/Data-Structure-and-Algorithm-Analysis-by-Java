package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

// 稠密图 - 使用邻接矩阵表示
public class DenseGraph implements Graph {
    private int edgeCount;  // 图中边的数量
    private int vertexCount;    // 图中节点的数量
    private boolean[][] adjacencyMatrix;    // 邻接矩阵
    private boolean directed;   // 是否为有向图

    // 稠密图构造函数
    public DenseGraph(int vertexCount, boolean directed) {
        this.vertexCount = vertexCount;
        this.edgeCount = 0;
        this.directed = directed;
        adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int v, int w) {
        if (hasEdge(v, w))
            return;
        adjacencyMatrix[v][w] = true;
        if (!directed)
            adjacencyMatrix[w][v] = true;
        edgeCount++;
    }

    public boolean hasEdge(int v, int w) {
        return adjacencyMatrix[v][w];
    }

    public int E() {
        return edgeCount;
    }

    public int V() {
        return vertexCount;
    }

    public Iterable<Integer> adjacentNode(int v) {
        List<Integer> nodeList = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            if (adjacencyMatrix[v][i])
                nodeList.add(i);
        }
        return nodeList;
    }

    public void show() {
        System.out.print("\t");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + "\t\t");
        }
        System.out.println();

        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjacencyMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


//// 使用 邻接矩阵 表示 稠密图
//public class DenseGraph implements Graph {
//    private int n;  // 图中的节点数
//    private int m;  // 图中的边数
//    private boolean[][] g;  // 邻接矩阵g
//    private boolean directed;   // 是否为有向图
//
//    public DenseGraph(int n, boolean directed) {
//        this.n = n;     // 初始化图中的节点数量
//        this.m = 0;     // 图中边（edge）的数量初始化为0
//        this.directed = directed;
//        g = new boolean[n][n];      // 邻接矩阵 g 初始化为一个 n*n 的二维矩阵
//        // 索引代表图中的节点，g中存储的值为 节点是否有边
//    }
//
//    // 返回图中边的数量
//    public int E() {
//        return m;
//    }
//
//    // 返回图中节点的数量
//    public int V() {
//        return n;
//    }
//
//    // 在图中指定的两节点之间加边
//    public void addEdge(int v, int w) {
//        if (!hasEdge(v, w)) {
//
//            // 连接[v][w]
//            g[v][w] = true;
//
//            // 无向图
//            if (!directed)
//                g[w][v] = true;
//
//            // 图中边的数量+1
//            m++;
//        }
//    }
//
//    // 判断两节点之间是否有边
//    public boolean hasEdge(int v, int w) {
//        return g[v][w];
//    }
//
//    // 返回所有 节点 v 的 邻接节点
//    public Iterable<Integer> adjacentNode(int v) {
//        // adjacentL 用于存储 v 的邻接节点
//        List<Integer> adjacentL = new ArrayList<>();
//        // 找到所有与 v 邻接的节点，将其加入 adjacentL 中
//        for (int i = 0; i < n; i++) {
//            if (g[v][i])
//                adjacentL.add(i);
//        }
//        return adjacentL;
//    }
//
//    // 显示图的信息
//    public void show() {
//        System.out.print("\t");
//        for (int i = 0; i < n; i++) {
//            System.out.print(i + "\t\t");
//        }
//        System.out.println();
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(i + "\t");
//            for (int j = 0; j < n; j++) {
//                System.out.print(g[i][j] + "\t");
//            }
//            System.out.println();
//        }
//    }
//
//
//}