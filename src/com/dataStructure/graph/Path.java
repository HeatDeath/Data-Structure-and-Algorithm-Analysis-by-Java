package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Stack;

public class Path {

    private Graph G;   // 图的引用
    //    private int v;     // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点

    // 图的深度优先遍历
    private void dfs(int v) {
        visited[v] = true;  // 节点v 的访问状态置为 true

        // 遍历节点 v 的邻接点
        for (int i : G.adjacentNode(v))
            if (!visited[i]) {  // 将节点 v 未被访问的邻接点 i
                from[i] = v;    // 邻接点 i from（来自） v
                dfs(i); // 对 i 进行深度优先遍历
            }
    }

    // 构造函数, 寻路算法, 寻找图graph从v点到其他点的路径
    public Path(Graph graph, int v) {

        // 算法初始化
        G = graph;
        assert v >= 0 && v < G.V();

        visited = new boolean[G.V()];   // visited 数组存储图中节点的访问状态
        from = new int[G.V()];  // from 数组存储路径上的节点

        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }

        // 寻路算法
        // 从起始节点 v 开始深度优先遍历 图G
        dfs(v);
    }

    // 查询从s点到w点是否有路径
    private boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];  // 如果访问到 节点w ，则 起始节点 v 到 节点w 有路径
    }

    // 查询从 v 点到w点的路径, 存放在 res 中
    private List<Integer> path(int w) {

        assert hasPath(w);

        // 栈 s 用于
        Stack<Integer> s = new Stack<Integer>();

        // 通过from数组逆向查找到从 v 到 w 的路径, 存放到栈中

        int p = w;  // p 指向 w
        while (p != -1) {
            s.push(p);  // 将 p 压入栈中
            p = from[p];    // 使用 from[] 数组逆向查找
        }

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        List<Integer> res = new ArrayList<>();
        while (!s.isEmpty())
            res.add(s.pop());

        return res;
    }

    // 打印出从s点到w点的路径
    void showPath(int w) {

        assert hasPath(w);

        List<Integer> vec = path(w);
        for (Integer node : vec) {
            System.out.print(node);
//            if (i == vec.size() - 1)
//                System.out.println();
//            else
            System.out.print(" -> ");
        }
        System.out.println();
    }
}