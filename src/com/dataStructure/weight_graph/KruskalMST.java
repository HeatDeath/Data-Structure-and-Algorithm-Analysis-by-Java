package com.dataStructure.weight_graph;

import com.dataStructure.heap.MinHeap;
import com.dataStructure.union_find.UnionFind5;

import java.util.ArrayList;
import java.util.List;

// Kruskal算法求最小生成树

public class KruskalMST {
    private List<Edge> mst; // 存放最小生成树的边
    private Number mstWeight;   // 最小生成树的权重

    // 构造函数
    public KruskalMST(WeightedGraph graph) {
        // 初始化私有字段
        mst = new ArrayList<>();
        mstWeight = 0;

        // 最小堆存放图中所有的边
        MinHeap<Edge> edgeMinHeap = new MinHeap<>(graph.E());
        for (int i = 0; i < graph.V(); i++)
            for (Edge edge : graph.adjacentNode(i))   // 遍历 i 的邻接节点
                if (edge.getV() <= edge.getW()) // 过滤掉 7-1 这种重复的边
                    edgeMinHeap.insert(edge);   // 将非重复的边插入最小堆中

        // 初始化一个图中节点数量大小的并查集
        UnionFind5 unionFind = new UnionFind5(graph.V());

        // 当最小堆非空 且 最小生成树尚未连接图中的所有节点
        while (!edgeMinHeap.isEmpty() && mst.size() < graph.V() - 1) {
            Edge edge = edgeMinHeap.extractMin();   // 取出权重最小的边

            // 如果向 mst 中加入 edge 前，v 和 w 已经连接
            // edge 加入 mst 后，将形成环，为防止形成环，跳出此次循环
            if (unionFind.isConnected(edge.getV(), edge.getW()))
                continue;

            mst.add(edge);  // 将 edge 加入 mst 中
            unionFind.unionElements(edge.getV(), edge.getW());  // 并查集中 union v 和 w

        }

        for (Edge edge : mst)   // 计算最小生成树的权重
            mstWeight = mstWeight.doubleValue() + edge.getWeight().doubleValue();
    }

    public List<Edge> getMst() {
        return mst;
    }

    public Number getMstWeight() {
        return mstWeight;
    }

    // 测试 Kruskal
    public static void main(String[] args) {

        String filename = "/testG1.txt";
        int V = 8;

        SparseGraph g = new SparseGraph(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Kruskal
        System.out.println("Test Kruskal: ");

        KruskalMST kruskalMST = new KruskalMST(g);
        List<Edge> mst = kruskalMST.getMst();

        for (int i = 0; i < mst.size(); i++)
            System.out.println(mst.get(i));
        System.out.println("The MST weight is: " + kruskalMST.getMstWeight());

        System.out.println();
    }
}


//public class KruskalMST {
//
//    private List<Edge> mst;   // 最小生成树所包含的所有边
//    private Number mstWeight;           // 最小生成树的权值
//
//    // 构造函数, 使用Kruskal算法计算graph的最小生成树
//    public KruskalMST(WeightedGraph graph) {
//        mstWeight = 0;
//        mst = new ArrayList<>();
//
//        // 将图中的所有边存放到一个最小堆中
//        MinHeap<Edge> pq = new MinHeap<>(graph.E());
//        for (int i = 0; i < graph.V(); i++)
//            for (Edge edge : graph.adjacentNode(i))
//                if (edge.getV() <= edge.getW()) // 过滤掉 7-1 等情况，防止堆中的边重复
//                    pq.insert(edge);
//
//
//        // 创建一个并查集, 来查看已经访问的节点的联通情况
//        UnionFind5 unionFind = new UnionFind5(graph.V());
//        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
//
//            // 从最小堆中依次从小到大取出所有的边
//            Edge e = pq.extractMin();
//
//            // 如果该边的两个端点是联通的, 说明加入这条边将产生环, 扔掉这条边
//            if (unionFind.isConnected(e.getV(), e.getW()))
//                continue;
//
//            // 否则, 将这条边添加进最小生成树, 同时标记边的两个端点联通
//            mst.add(e);
//            unionFind.unionElements(e.getV(), e.getW());
//        }
//
//        for (Edge edge : mst) // 计算最小生成树的权重
//            mstWeight = mstWeight.doubleValue() + edge.getWeight().doubleValue();
//    }
//
//    // 返回最小生成树的所有边
//    List<Edge> mstEdges() {
//        return mst;
//    }
//
//    // 返回最小生成树的权值
//    Number result() {
//        return mstWeight;
//    }
//
//
//    // 测试 Kruskal
//    public static void main(String[] args) {
//
//        String filename = "/testG1.txt";
//        int V = 8;
//
//        SparseGraph g = new SparseGraph(V, false);
//        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);
//
//        // Test Kruskal
//        System.out.println("Test Kruskal:");
//        KruskalMST kruskalMST = new KruskalMST(g);
//        List<Edge> mst = kruskalMST.mstEdges();
//        for (int i = 0; i < mst.size(); i++)
//            System.out.println(mst.get(i));
//        System.out.println("The MST weight is: " + kruskalMST.result());
//
//        System.out.println();
//    }
//}