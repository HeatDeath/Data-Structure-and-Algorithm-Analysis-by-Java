package com.dataStructure.weight_graph;

public interface WeightedGraph {
    public int V();

    public int E();

    public void addEdge(Edge e);

    boolean hasEdge(int v, int w);

    void show();

    public Iterable<Edge> adjacentNode(int v);
}
