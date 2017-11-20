package com.dataStructure.graph;

// 图的接口
interface Graph {
    int E(); // edge 边
    int V(); // vertex 节点
    void addEdge(int v, int w);
    boolean hasEdge(int v, int w);
    Iterable<Integer> adjacentNode(int v);
    void show();
}
