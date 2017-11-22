package com.dataStructure.weight_graph;

import com.dataStructure.heap.IndexMaxHeap;
import com.dataStructure.heap.IndexMinHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Dijkstra算法求最短路径

public class Dijkstra {
    private WeightedGraph graph;    // 图的引用
    private int startNode;  // 起始点
    private Number[] distanceTo;    // startNode 到 节点 i 的最短路径长度
    private boolean[] visited;  // 节点 i 的访问状态
    private Edge[] from;    // from[i] 记录最短路径中，到达 i 的边是哪一条，可以用来恢复最短路径

    // 构造函数，使用 Dijkstra 算法求最短路径
    public Dijkstra(WeightedGraph graph, int startNode) {
        // 初始化私有字段
        this.graph = graph;
        this.startNode = startNode;
        distanceTo = new Number[graph.V()];
        visited = new boolean[graph.V()];
        from = new Edge[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            distanceTo[i] = Integer.MAX_VALUE;
            visited[i] = false;
            from[i] = null;
        }

        // 索引堆记录当前找到的到达每个节点的最短距离
        IndexMinHeap indexMinHeap = new IndexMinHeap(graph.V());

        // 初始化 startNode
        distanceTo[startNode] = 0.0;
        visited[startNode] = true;
        from[startNode] = new Edge(startNode, startNode, 0.0);
        indexMinHeap.insert(startNode, (Comparable)distanceTo[startNode]);

        // 堆非空
        while (!indexMinHeap.isEmpty()){
            int v = indexMinHeap.extractMinIndex();
            visited[v] = true;

            for (Edge edge: graph.adjacentNode(v)){
                int w= edge.getAnotherNode(v);
                if (!visited[w]){
                    if (from[w] == null ||
                            distanceTo[v].doubleValue() + edge.getWeight().doubleValue() < distanceTo[w].doubleValue()){
                        from[w] = edge;
                        distanceTo[w] = distanceTo[v].doubleValue() + edge.getWeight().doubleValue();
                        if (indexMinHeap.contain(w))
                            indexMinHeap.change(w, (Comparable) distanceTo[w]);
                        else
                            indexMinHeap.insert(w, (Comparable) distanceTo[w]);
                    }
                }
            }
        }
    }




//    // 构造函数，使用 Dijkstra 算法求 单源最短路径
//    public Dijkstra(WeightedGraph graph, int startNode) {
//        // 私有字段初始化
//        this.graph = graph;
//        this.startNode = startNode;
//        distanceTo = new Number[graph.V()];
//        visited = new boolean[graph.V()];
//        from = new Edge[graph.V()];
//
//        for (int i = 0; i < graph.V(); i++) {
//            distanceTo[i] = 0.0;
//            visited[i] = false;
//            from[i] = null;
//        }
//
//        // 使用最小索引堆记录当前找到的 到达每个节点的最短距离
//        IndexMinHeap indexMinHeap = new IndexMinHeap(graph.V());
//
//        // 对起始点 startNode 进行初始化
//        distanceTo[startNode] = 0.0;
//        from[startNode] = new Edge(startNode, startNode, (Number) 0.0);
//        visited[startNode] = true;
//        indexMinHeap.insert(startNode, (Comparable) distanceTo[startNode]);
//
//        // 当堆非空
//        while (!indexMinHeap.isEmpty()) {
//            int v = indexMinHeap.extractMinIndex(); // 取出当前堆中距离 startNode 最近的节点 v
//                                                    // 此时找到了从 startNode 到 v 的最短路径
//            visited[v] = true;  // 只有找到从 startNode 到 v 的最短路径，visited[v] 才为 true
//
//            for (Edge edge : graph.adjacentNode(v)) {   // 遍历 v 的邻接节点
//                int w = edge.getAnotherNode(v);     // w 为 v 的邻接节点
//                if (!visited[w]) {  // 如果从 startNode 到 w 的最短路径尚未找到
//                    // 以前没有访问过 w || 通过当前 v 到 w 的距离更短
//                    if (from[w] == null ||
//                            distanceTo[v].doubleValue() + edge.getWeight().doubleValue() < distanceTo[w].doubleValue()){
//                        distanceTo[w] = distanceTo[v].doubleValue() + edge.getWeight().doubleValue();   // 设置到达 w 的“当前最短距离”
//                        from[w] = edge; // 设置到达 w 的边为 edge
//                        if (indexMinHeap.contain(w))    // 如果堆中已经含有 w ，更新 “最短距离”
//                            indexMinHeap.change(w, (Comparable) distanceTo[w]);
//                        else
//                            indexMinHeap.insert(w, (Comparable) distanceTo[w]);
//                    }
//                }
//            }
//        }
//    }

    public Number shortestDistanceTo(int w) {
        return distanceTo[w];
    }

    public boolean hasPathTo(int w) {
        return visited[w];
    }

    public List<Edge> shortestPathTo(int w) {
        Stack<Edge> stack = new Stack<>();
        Edge edge = from[w];
        while (edge.getV() != startNode) {
            stack.push(edge);
            edge = from[edge.getV()];
        }
        stack.push(edge);

        List<Edge> list = new ArrayList<>();
        while (!stack.isEmpty())
            list.add(stack.pop());

        return list;
    }

    public void showPath(int w) {
        List<Edge> path = shortestPathTo(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).getV() + " -> ");
            if (i == path.size() - 1)
                System.out.println(path.get(i).getW());
        }
    }

    // 测试我们的Dijkstra最短路径算法
    public static void main(String[] args) {

        String filename = "/testG2.txt";
        int V = 5;

        SparseGraph g = new SparseGraph(V, true);
        // Dijkstra最短路径算法同样适用于有向图
        //SparseGraph<int> g = SparseGraph<int>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        System.out.println("Test Dijkstra:\n");
        Dijkstra dij = new Dijkstra(g, 0);
        for (int i = 1; i < V; i++) {
            if (dij.hasPathTo(i)) {
                System.out.println("Shortest Path to " + i + " : " + dij.shortestPathTo(i));
                dij.showPath(i);
            } else
                System.out.println("No Path to " + i);

            System.out.println("----------");
        }
    }
}

//public class Dijkstra {
//
//    private WeightedGraph G;    // 图的引用
//    private int s;  // 起始点
//    private Number[] distTo;    // distTo[i]存储从起始点s到i的最短路径长度
//    private boolean[] visited;  // 标记数组, 在算法运行过程中标记节点i是否被访问
//    private Edge[] from;       // from[i]记录最短路径中, 到达i点的边是哪一条
//    // 可以用来恢复整个最短路径
//
//    // 构造函数, 使用Dijkstra算法求最短路径
//    public Dijkstra(WeightedGraph graph, int s) {
//
//        // 算法初始化
//        G = graph;
//        assert s >= 0 && s < G.V();
//        this.s = s;
//        distTo = new Number[G.V()];
//        visited = new boolean[G.V()];
//        from = new Edge[G.V()];
//        for (int i = 0; i < G.V(); i++) {
//            distTo[i] = 0.0;
//            visited[i] = false;
//            from[i] = null;
//        }
//
//        // 使用索引堆记录当前找到的到达每个顶点的最短距离
//        IndexMinHeap ipq = new IndexMinHeap(G.V());
//
//        // 对于其实点s进行初始化
//        distTo[s] = 0.0;
//        from[s] = new Edge(s, s, (Number) (0.0));
//        ipq.insert(s, (Comparable) distTo[s]);
//        visited[s] = true;
//        while (!ipq.isEmpty()) {
//            int v = ipq.extractMinIndex();
//
//            // distTo[v]就是s到v的最短距离
//            visited[v] = true;
//
//            // 对v的所有相邻节点进行更新
//            for (Object item : G.adjacentNode(v)) {
//                Edge e = (Edge) item;
//                int w = e.getAnotherNode(v);
//                // 如果从s点到w点的最短路径还没有找到
//                if (!visited[w]) {
//                    // 如果w点以前没有访问过,
//                    // 或者访问过, 但是通过当前的v点到w点距离更短, 则进行更新
//                    if (from[w] == null || distTo[v].doubleValue() + e.getWeight().doubleValue() < distTo[w].doubleValue()) {
//                        distTo[w] = distTo[v].doubleValue() + e.getWeight().doubleValue();
//                        from[w] = e;
//                        if (ipq.contain(w))
//                            ipq.change(w, (Comparable) distTo[w]);
//                        else
//                            ipq.insert(w, (Comparable) distTo[w]);
//                    }
//                }
//            }
//        }
//    }
//
//    // 返回从s点到w点的最短路径长度
//    Number shortestPathTo(int w) {
//        assert w >= 0 && w < G.V();
//        assert hasPathTo(w);
//        return distTo[w];
//    }
//
//    // 判断从s点到w点是否联通
//    boolean hasPathTo(int w) {
//        assert w >= 0 && w < G.V();
//        return visited[w];
//    }
//
//    // 寻找从s到w的最短路径, 将整个路径经过的边存放在vec中
//    List<Edge> shortestPath(int w) {
//
//        assert w >= 0 && w < G.V();
//        assert hasPathTo(w);
//
//        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
//        Stack<Edge> s = new Stack<>();
//        Edge e = from[w];
//        while (e.getV() != this.s) {
//            s.push(e);
//            e = from[e.getV()];
//        }
//        s.push(e);
//
//        // 从栈中依次取出元素, 获得顺序的从s到w的路径
//        List<Edge> res = new ArrayList<>();
//        while (!s.empty()) {
//            e = s.pop();
//            res.add(e);
//        }
//
//        return res;
//    }
//
//    // 打印出从s点到w点的路径
//    void showPath(int w) {
//
//        assert w >= 0 && w < G.V();
//        assert hasPathTo(w);
//
//        List<Edge> path = shortestPath(w);
//        for (int i = 0; i < path.size(); i++) {
//            System.out.print(path.get(i).getV() + " -> ");
//            if (i == path.size() - 1)
//                System.out.println(path.get(i).getW());
//        }
//    }
//
//    // 测试我们的Dijkstra最短路径算法
//    public static void main(String[] args) {
//
//        String filename = "/testG2.txt";
//        int V = 5;
//
//        SparseGraph g = new SparseGraph(V, true);
//        // Dijkstra最短路径算法同样适用于有向图
//        //SparseGraph<int> g = SparseGraph<int>(V, false);
//        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);
//
//        System.out.println("Test Dijkstra:\n");
//        Dijkstra dij = new Dijkstra(g,0);
//        for( int i = 1 ; i < V ; i ++ ){
//            if(dij.hasPathTo(i)) {
//                System.out.println("Shortest Path to " + i + " : " + dij.shortestPathTo(i));
//                dij.showPath(i);
//            }
//            else
//                System.out.println("No Path to " + i );
//
//            System.out.println("----------");
//        }
//
//    }
//}
