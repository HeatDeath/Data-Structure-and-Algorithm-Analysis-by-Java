package com.dataStructure.weight_graph;

import com.dataStructure.heap.MinHeap;

import java.util.ArrayList;
import java.util.List;

public class LazyPrimMST{
    private WeightedGraph graph;    // 存放输入的图
    private boolean[] visited;  // 图中节点的访问状态
    private List<Edge> mst; // 最小生成树经过的边
    private Number mstWeight;   // 最小生成树的权重
    private MinHeap<Edge> minHeap;  // 用于缓存 edge 的最小堆

    // 构造函数，初始化私有字段
    public LazyPrimMST(WeightedGraph graph){
        this.graph = graph;
        visited = new boolean[graph.V()];
        mst = new ArrayList<>();
        mstWeight = 0;
        minHeap = new MinHeap<>(graph.E()); // 最小堆的大小等于边数

        visit(0);   // 从节点 0 开始访问图
        while (!minHeap.isEmpty()){ // 当最小堆非空
            Edge edge = minHeap.extractMin();   // 获取最小边
            if (visited[edge.getV()] == visited[edge.getW()])   // 如果最小边的两个端点都被访问
                continue;   // 跳出本次循环

            mst.add(edge);  // 将最小边放入 mst 中
            if (!visited[edge.getV()])  // 访问最小边两端点中未被访问的端点
                visit(edge.getV());
            else
                visit(edge.getW());
        }

        for (Edge edge:mst) // 计算最小生成树的权重
            mstWeight = mstWeight.doubleValue() + edge.getWeight().doubleValue();

    }

    public void visit(int i){   // 访问节点 i
        visited[i] = true;
        for (Edge edge:graph.adjacentNode(i))   // 将 i 的邻接节点（未被访问的）与 i 之间的边加入最小堆中
            if (!visited[edge.getAnotherNode(i)])
                minHeap.insert(edge);
    }

    public Number getMstWeight(){   // 返回最小生成树的权重
        return mstWeight;
    }

    public List<Edge> getMst() {    // 返回最小生成树
        return mst;
    }
}



//public class LazyPrimMST {
//    private WeightedGraph G;    // 图的引用
//    private MinHeap<Edge> pq;   // 最小堆, 算法辅助数据结构
//    private boolean[] visited;           // 标记数组, 在算法运行过程中标记节点i是否被访问
//    private List<Edge> mst;   // 最小生成树所包含的所有边
//    private Number mstWeight;           // 最小生成树的权值
//
//    // 构造函数, 使用Prim算法求图的最小生成树
//    public LazyPrimMST(WeightedGraph graph) {
//
//        // 算法初始化
//        G = graph;
//        pq = new MinHeap<>(G.E());  // 堆的大小等于 g 的边数
//        visited = new boolean[G.V()];   // 节点的访问状态
//        mst = new ArrayList<>();
//
//        // Lazy Prim
//        visit(0);
//        while (!pq.isEmpty()) {
//            // 使用最小堆找出已经访问的边中权值最小的边
//            Edge e = pq.extractMin();
//            // 如果这条边的两端都已经访问过了, 则扔掉这条边
//            if (visited[e.getV()] == visited[e.getW()])
//                continue;
//            // 否则, 这条边则应该存在在最小生成树中
//            mst.add(e);
//
//            // 访问和这条边连接的还没有被访问过的节点
//            if (!visited[e.getV()])
//                visit(e.getV());
//            else
//                visit(e.getW());
//        }
//
//        // 计算最小生成树的权值
//
////        mstWeight = mst.get(0).getWeight();
////        for (int i = 1; i < mst.size(); i++)
////            mstWeight = mstWeight.doubleValue() + mst.get(i).getWeight().doubleValue();
//
//        mstWeight = 0;
//        for (Edge edge:mst)
//            mstWeight = mstWeight.doubleValue() + edge.getWeight().doubleValue();
//
//    }
//
//    // 访问节点v
//    private void visit(int v) {
//
//        assert !visited[v];
//        visited[v] = true;
//
//        // 将和节点v相连接的所有未访问的边放入最小堆中
//        for (Edge e : G.adjacentNode(v))
//            if (!visited[e.getAnotherNode(v)])
//                pq.insert(e);
//    }
//
//    // 返回最小生成树的所有边
//    List<Edge> mstEdges() {
//        return mst;
//    }
//
//    ;
//
//    // 返回最小生成树的权值
//    Number result() {
//        return mstWeight;
//    }
//
//}
