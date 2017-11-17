package com.dataStructure.graph;

// 图的接口
public interface Graph {
    public int E();
    public int V();
    public void addEdge(int v, int w);
    public boolean hasEdge(int v, int w);
    public Iterable<Integer> adjacentNode(int v);
    public void show();
}
