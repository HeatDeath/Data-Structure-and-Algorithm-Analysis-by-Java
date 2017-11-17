package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

//// 稀疏图 - 邻接表
//public class SparseGraph {
//
//    private int n;  // 节点数
//    private int m;  // 边数
//    private boolean directed;    // 是否为有向图
//    private List<Integer>[] g;   // 图的具体数据
//
//    // 构造函数
//    public SparseGraph(int n, boolean directed) {
//        assert n >= 0;
//        this.n = n;
//        this.m = 0;    // 初始化没有任何边
//        this.directed = directed;
//        // g初始化为n个空的 ArrayList , 表示每一个g[i]都为空, 即没有任和边
//        // g 是一个存储 ArrayList 的数组
//        // 数组中的每一个元素都 图中的一个节点和与之有联系的节点 组成的ArrayList
//        g = (ArrayList<Integer>[]) new ArrayList[n];
//        for (int i = 0; i < n; i++)
//            g[i] = new ArrayList<Integer>();
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
//        // v 表示的是 图中节点
//        // g[v] 表示图中与 v 相连的节点组成的 ArrayList
//        // g[v].add(w) 表示 将与 v 相连的节点 w 放到 g[v](ArrayList) 中
//        g[v].add(w);
//        if (v != w && !directed)
//            g[w].add(v);
//
//        m++;
//    }
//
//    // 验证图中是否有从v到w的边
//    boolean hasEdge(int v, int w) {
//
//        assert v >= 0 && v < n;
//        assert w >= 0 && w < n;
//
//        for (int i = 0; i < g[v].size(); i++)
//            if (g[v].get(i) == w)
//                return true;
//        return false;
//    }
//}

// 使用 邻接表 表示 稀疏图
public class SparseGraph implements Graph {
    private int n;  // 图中节点数量
    private int m;  // 图中边的数量
    private List<Integer>[] g;  // 邻接表 g
    private boolean directed;   // 是否为有向图

    public SparseGraph(int n, boolean directed) {
        this.n = n; // 初始化节点数量
        this.m = 0; // 初始图中边数为 0
        this.directed = directed;

        // 初始化一个用于存储 ArrayList<Integer>类型数据 的数组 g 作为邻接表
        g = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }
    }

    // 返回图中边的数量
    public int E() {
        return m;
    }

    // 返回图中节点的数量
    public int V() {
        return n;
    }

    // 在节点 v 与 w 之间添加一条边
    public void addEdge(int v, int w) {

        // 当 v 和 w 之间没有边时
        if (!hasEdge(v, w)) {

            // 在邻接表中添加一条 v 、 w 之间的边
            g[v].add(w);
            if (v != w && !directed)
                g[w].add(v);

            // 图中边数+1
            m++;
        }
    }

    // 判断两节点 v、w 之间是否存在边
    public boolean hasEdge(int v, int w) {
        // 遍历 g[i] 中存储的 ArrayList，若其中存在 w ，返回 true
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i) == w)
                return true;
        }
        return false;
    }

    // 返回节点v 的所有邻接节点
    public Iterable<Integer> adjacentNode(int v) {
        return g[v];
    }

    // 显示图的信息
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.print(g[i].get(j) + "\t");
            }
            System.out.println();
        }
    }
}