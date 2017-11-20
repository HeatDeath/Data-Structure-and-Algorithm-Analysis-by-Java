package com.dataStructure.graph;

// 使用 广度优先遍历 查找节点之间的最短路径

import java.util.*;

public class ShortestPath {
    private Graph graph;
    private int startNode;
    private boolean[] visited;
    private int[] from;
    private int[] order;

    public ShortestPath(Graph graph, int startNode) {
        this.graph = graph;
        this.startNode = startNode;
        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        order = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            order[i] = -1;
        }

        Queue<Integer> cacheQueue = new LinkedList<>(); // 用于缓存节点的队列

        visited[startNode] = true;  // startNode 访问状态变为 true
        order[startNode] = 0;   // startNode 的访问次序为 0

        cacheQueue.offer(startNode);    // 将 startNode 入队

        while (!cacheQueue.isEmpty()) {  // 当缓存队列不为空
            int frontNode = cacheQueue.poll();   // frontNode 存放从缓存队列中出队的元素
            for (int adjNode : graph.adjacentNode(frontNode)) { // 遍历 frontNode 的未被访问的邻接节点
                if (!visited[adjNode]) {
                    visited[adjNode] = true;    // 邻接节点 adjNode 的访问状态为 true
                    from[adjNode] = frontNode;   // adjNode 的前一个节点为 frontNode
                    order[adjNode] = order[frontNode] + 1;  // ajdNode 的访问次序在 frontNode 上+1
                    cacheQueue.offer(adjNode);  // adjNode 入队
                }
            }
        }
    }

    public List<Integer> getPath(int w) {
        Stack<Integer> stack = new Stack<>();
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty())
            list.add(stack.pop());

        return list;
    }

    public boolean hasPath(int w) {
        return visited[w];
    }

    public int pathLength(int w) {
        return order[w];
    }

    // 打印出从 startNode 到w点的路径
    void showPath(int w) {
        List<Integer> path = getPath(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i == path.size() - 1)
                System.out.println();
            else
                System.out.print(" -> ");
        }
        System.out.println();
    }
}


//public class ShortestPath {
//
//    private Graph G;   // 图的引用
//    private int s;     // 起始点
//    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
//    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点
//    private int[] ord;          // 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。
//
//
//    // 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
//    public ShortestPath(Graph graph, int s) {
//
//        // 算法初始化
//        G = graph;
//        assert s >= 0 && s < G.V();
//
//        visited = new boolean[G.V()];
//        from = new int[G.V()];
//        ord = new int[G.V()];
//        for (int i = 0; i < G.V(); i++) {
//            visited[i] = false;
//            from[i] = -1;
//            ord[i] = -1;
//        }
//        this.s = s;
//
//        // 无向图最短路径算法, 从s开始广度优先遍历整张图
//        LinkedList<Integer> q = new LinkedList<>();
//
//        q.push(s);
//        visited[s] = true;
//        ord[s] = 0;
//        while (!q.isEmpty()) {
//            int v = q.pop();
//            for (int i : G.adjacentNode(v))
//                if (!visited[i]) {
//                    q.push(i);
//                    visited[i] = true;
//                    from[i] = v;
//                    ord[i] = ord[v] + 1;
//                }
//        }
//    }
//
//    // 查询从s点到w点是否有路径
//    public boolean hasPath(int w) {
//        assert w >= 0 && w < G.V();
//        return visited[w];
//    }
//
//    // 查询从s点到w点的路径, 存放在vec中
//    public List<Integer> path(int w) {
//
//        assert hasPath(w);
//
//        Stack<Integer> s = new Stack<Integer>();
//        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
//        int p = w;
//        while (p != -1) {
//            s.push(p);
//            p = from[p];
//        }
//
//        // 从栈中依次取出元素, 获得顺序的从s到w的路径
//        List<Integer> res = new ArrayList<>();
//        while (!s.empty())
//            res.add(s.pop());
//
//        return res;
//    }
//
//    // 打印出从s点到w点的路径
//    public void showPath(int w) {
//
//        assert hasPath(w);
//
//        List<Integer> vec = path(w);
//        for (int i = 0; i < vec.size(); i++) {
//            System.out.print(vec.get(i));
//            if (i == vec.size() - 1)
//                System.out.println();
//            else
//                System.out.print(" -> ");
//        }
//    }
//
//    // 查看从s点到w点的最短路径长度
//    // 若从s到w不可达，返回-1
//    public int length(int w) {
//        assert w >= 0 && w < G.V();
//        return ord[w];
//    }
//}