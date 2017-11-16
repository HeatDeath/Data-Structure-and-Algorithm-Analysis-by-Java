package com.dataStructure.union_find;

public class UnionFind2 {
    // parent[i] 表示第一个元素所指向的父节点
    private int[] parent;
    private int count;

    public UnionFind2(int n) {
        count = n;
        parent = new int[count];
        // 初始化，使每一个 parent[i] 指向自己，表示每一个元素自己自成一个集合
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
    }

    // 查找过程，查找元素 p 所对应的集合编号
    // 复杂度O(h)， h为树的高度
    private int find(int p){
        while (p!=parent[p])
            p = parent[p];
        return p;
    }

    // 查看元素p 和元素q 是否属于同一个集合
    // 复杂度O(h), h为树的高度
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    // 合并元素p 和元素q 所属的集合
    // 复杂度O(h)， h为树的高度
    public void unionElements(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }


}
