package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

// 稀疏图 - 邻接表
public class SparseGraph implements Graph {
    private int vertexCount;
    private int edgeCount;
    private boolean directed;
    private List<Integer>[] adjacencyTable;

    public SparseGraph(int vertexCount, boolean directed) {
        this.vertexCount = vertexCount;
        this.edgeCount = 0;
        this.directed = directed;
        adjacencyTable = (ArrayList<Integer>[]) new ArrayList[vertexCount];
    }

    public int E() {
        return edgeCount;
    }

    public int V() {
        return vertexCount;
    }

    public void addEdge(int v, int w) {
        if (hasEdge(v, w))
            return;
        adjacencyTable[v].add(w);
        if (!directed && v != w)
            adjacencyTable[w].add(v);
        edgeCount++;
    }

    public boolean hasEdge(int v, int w) {
        for (int node : adjacencyTable[v])
            if (node == w)
                return true;
        return false;
    }

    public Iterable<Integer> adjacentNode(int v) {
        return adjacencyTable[v];
    }

    public void show() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < adjacencyTable[i].size(); j++) {
                System.out.print(adjacencyTable[i].get(j) + "\t");
            }
            System.out.println();
        }
    }
}



// 使用 邻接表 表示 稀疏图
//public class SparseGraph implements Graph {
//    private int n;  // 图中节点数量
//    private int m;  // 图中边的数量
//    private List<Integer>[] g;  // 邻接表 g
//    private boolean directed;   // 是否为有向图
//
//    public SparseGraph(int n, boolean directed) {
//        this.n = n; // 初始化节点数量
//        this.m = 0; // 初始图中边数为 0
//        this.directed = directed;
//
//        // 初始化一个用于存储 ArrayList<Integer>类型数据 的数组 g 作为邻接表
//        g = (ArrayList<Integer>[]) new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            g[i] = new ArrayList<Integer>();
//        }
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
//    // 在节点 v 与 w 之间添加一条边
//    public void addEdge(int v, int w) {
//
//        // 当 v 和 w 之间没有边时
//        if (!hasEdge(v, w)) {
//
//            // 在邻接表中添加一条 v 、 w 之间的边
//            g[v].add(w);
//            if (v != w && !directed)
//                g[w].add(v);
//
//            // 图中边数+1
//            m++;
//        }
//    }
//
//    // 判断两节点 v、w 之间是否存在边
//    public boolean hasEdge(int v, int w) {
//        // 遍历 g[i] 中存储的 ArrayList，若其中存在 w ，返回 true
//        for (int i = 0; i < g[v].size(); i++) {
//            if (g[v].get(i) == w)
//                return true;
//        }
//        return false;
//    }
//
//    // 返回节点v 的所有邻接节点
//    public Iterable<Integer> adjacentNode(int v) {
//        return g[v];
//    }
//
//    // 显示图的信息
//    public void show() {
//        for (int i = 0; i < n; i++) {
//            System.out.print("vertex " + i + ":\t");
//            for (int j = 0; j < g[i].size(); j++) {
//                System.out.print(g[i].get(j) + "\t");
//            }
//            System.out.println();
//        }
//    }
//}