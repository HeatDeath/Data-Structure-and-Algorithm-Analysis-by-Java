package com.leetcode.graph;

import com.dataStructure.graph.Components;
import com.dataStructure.graph.DenseGraph;

import java.util.List;

public class Friend_Circles {
//    private int vertexCount;
//    private int edgeCount;
//    private
//    private boolean[] visited;
//    private int[] mark;
//    private int componentCount;
//
//    class

    public int solution(int[][] M){
        int n = M.length;
        DenseGraph denseGraph = new DenseGraph(n, false);
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (M[i][j] == 1)
                    denseGraph.addEdge(i, j);
        Components components = new Components(denseGraph);
        return components.getComponentCount();
    }

    public static void main(String[] args) {
        int[][] inputData = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Friend_Circles friend_circles = new Friend_Circles();
        System.out.println(friend_circles.solution(inputData));
//        System.out.println(friend_circles);
    }
}
