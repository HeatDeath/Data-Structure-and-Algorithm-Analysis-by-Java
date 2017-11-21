package com.dataStructure.weight_graph;

import com.dataStructure.heap.IndexMinHeap;

import java.util.ArrayList;
import java.util.List;

public class PrimMST {
    private WeightedGraph graph;    // 存放输入的图
    private boolean[] visited;  // 节点的访问状态
    private IndexMinHeap indexMinHeap;  // 最小索引堆
    private Edge[] edgeTo;  // edgeTo[i] 表示到 i 节点的 Edge
    private List<Edge> mst; // 组成最小生成树的边
    private Number mstWeight;   // 最小生成树的权重

    // 构造函数
    public PrimMST(WeightedGraph graph) {
        // 私有字段初始化
        this.graph = graph;
        visited = new boolean[graph.V()];
        indexMinHeap = new IndexMinHeap(graph.V());
        edgeTo = new Edge[graph.V()];
        mst = new ArrayList<>();
        mstWeight = 0;
        for (int i = 0; i < graph.V(); i++) {
//            visited[i] = false;
            edgeTo[i] = null;
        }

        // Prim
        visit(0);   // 访问节点 0
        while (!indexMinHeap.isEmpty()) {    // 最小索引堆不为空
            int i = indexMinHeap.extractMinIndex(); // 获取当前堆中最小权重对应的节点
            mst.add(edgeTo[i]); // 将 edgeTo[i] 加入 mst 中
            visit(i);   // 访问节点 i
        }

        for (Edge edge : mst) // 计算最小生成树的权重
            mstWeight = mstWeight.doubleValue() + edge.getWeight().doubleValue();
    }

    public void visit(int i) {
        visited[i] = true;  // 节点的访问状态置为 true
        for (Edge edge : graph.adjacentNode(i)) { // 遍历 i 的邻接节点
            int w = edge.getAnotherNode(i);
            if (!visited[w]) {   // 对于未被访问的邻接节点 w
                if (edgeTo[w] == null) { // 如果尚未考虑过 w
                    edgeTo[w] = edge;   // 设置到 w 的边为 edge
                    indexMinHeap.insert(w, (Comparable) edge.getWeight());  // 插入到最小索引堆中
                } else if (edge.compareTo(edgeTo[w]) < 0) {   // 如果考虑过 w
                    // 且 edge 比 edgeTo[w] 的权重更小
                    edgeTo[w] = edge;   // 更新到 w 的边为 edge
                    indexMinHeap.change(w, (Comparable) edge.getWeight());  // 更新最小索引堆中 w 对应值
                }
            }
        }
    }

    public List<Edge> getMst() {
        return mst;
    }

    public Number getMstWeight() {
        return mstWeight;
    }

    // 测试 Prim
    public static void main(String[] args) {

        String filename = "/testG1.txt";
        int V = 8;

        SparseGraph g = new SparseGraph(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Prim MST
        System.out.println("Test Prim MST:");
        PrimMST primMST = new PrimMST(g);
        List<Edge> mst = primMST.getMst();
        for (int i = 0; i < mst.size(); i++)
            System.out.println(mst.get(i));
        System.out.println("The MST weight is: " + primMST.getMstWeight());

        System.out.println();
    }
}


//public class PrimMST {
//    private WeightedGraph G;              // 图的引用
//    private IndexMinHeap ipq;     // 最小索引堆, 算法辅助数据结构
//    private Edge[] edgeTo;        // 访问的点所对应的边, 算法辅助数据结构
//    private boolean[] marked;             // 标记数组, 在算法运行过程中标记节点i是否被访问
//    private List<Edge> mst;     // 最小生成树所包含的所有边
//    private Number mstWeight;             // 最小生成树的权值
//
//    // 构造函数, 使用Prim算法求图的最小生成树
//    public PrimMST(WeightedGraph graph) {
//
//        G = graph;
//        assert (graph.E() >= 1);
//        ipq = new IndexMinHeap(graph.V());
//
//        // 算法初始化
//        marked = new boolean[G.V()];
//        edgeTo = new Edge[G.V()];
//        for (int i = 0; i < G.V(); i++) {
//            marked[i] = false;
//            edgeTo[i] = null;
//        }
//        mst = new ArrayList<>();
//
//        // Prim
//        visit(0);
//        while (!ipq.isEmpty()) {
//            // 使用最小索引堆找出已经访问的边中权值最小的边
//            // 最小索引堆中存储的是点的索引, 通过点的索引找到相对应的边
//            int v = ipq.extractMinIndex();
//            assert (edgeTo[v] != null);
//            mst.add(edgeTo[v]);
//            visit(v);
//        }
//
//        // 计算最小生成树的权值
//        mstWeight = mst.get(0).getWeight();
//        for (int i = 1; i < mst.size(); i++)
//            mstWeight = mstWeight.doubleValue() + mst.get(i).getWeight().doubleValue();
//    }
//
//    // 访问节点v
//    void visit(int v) {
//
//        assert !marked[v];
//        marked[v] = true;
//
//        // 将和节点v相连接的未访问的另一端点, 和与之相连接的边, 放入最小堆中
//        for (Edge edge : G.adjacentNode(v)) {
//            int w = edge.getAnotherNode(v);
//            // 如果边的另一端点未被访问
//            if (!marked[w]) {
//                // 如果从没有考虑过这个端点, 直接将这个端点和与之相连接的边加入索引堆
//                if (edgeTo[w] == null) {
//                    edgeTo[w] = edge;
//                    ipq.insert(w, (Comparable)edge.getWeight());
//                }
//                // 如果曾经考虑这个端点, 但现在的边比之前考虑的边更短, 则进行替换
//                else if (edge.compareTo(edgeTo[w]) < 0) {
//                    edgeTo[w] = edge;
//                    ipq.change(w, (Comparable)edge.getWeight());
//                }
//            }
//        }
//
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
//    // 测试 Prim
//    public static void main(String[] args) {
//
//        String filename = "/testG1.txt";
//        int V = 8;
//
//        SparseGraph g = new SparseGraph(V, false);
//        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);
//
//        // Test Prim MST
//        System.out.println("Test Prim MST:");
//        PrimMST primMST = new PrimMST(g);
//        List<Edge> mst = primMST.mstEdges();
//        for (int i = 0; i < mst.size(); i++)
//            System.out.println(mst.get(i));
//        System.out.println("The MST weight is: " + primMST.result());
//
//        System.out.println();
//    }
//
//}
