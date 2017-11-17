package com.dataStructure.graph;

// 求无权图的联通分量
public class Components {

    private Graph G;                    // 图的引用
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int ccount;         // 记录联通分量个数
    private int[] id;           // 每个节点所对应的联通分量标记

    // 图的深度优先遍历
    private void dfs( int v ){

        visited[v] = true;  // 节点 v 的访问状态置为 true
        id[v] = ccount; // 节点 v 对应的联通标记设置为 ccount

        // 遍历节点 v 的邻接点 i
        for( int i: G.adjacentNode(v) ){
            // 如果邻接点 i 尚未被访问
            if( !visited[i] )
                // 对邻接点 i 进行深度优先遍历
                dfs(i);
        }
    }

    // 构造函数, 求出无权图的联通分量
    public Components(Graph graph){

        // 算法初始化
        G = graph;

        // visited 数组存储 图G 中 节点的被访问状态
        visited = new boolean[G.V()];

        // id 数组存储 图G 中 节点所属连通分量的标记
        id = new int[G.V()];

        // 连通分量数量初始化为 0
        ccount = 0;

        // 将 visited 数组全部置为 false； id 数组全部置为 -1
        for( int i = 0 ; i < G.V() ; i ++ ){
            visited[i] = false;
            id[i] = -1;
        }

        // 求图的联通分量
        for( int i = 0 ; i < G.V() ; i ++ )
            // 访问一个未曾被访问的节点
            if( !visited[i] ){
                // 对其进行深度优先遍历
                dfs(i);
                ccount ++;
            }
    }

    // 返回图的联通分量个数
    int count(){
        return ccount;
    }

    // 查询点v和点w是否联通（节点v 和 w 的联通分量的标记是否相同
    boolean isConnected( int v , int w ){
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }
}