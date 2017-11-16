package com.dataStructure.union_find;

public class UnionFind3 {
    private int[] parent; // parent[i]表示第一个元素所指向的父节点
    private int[] size;     // sz[i]表示以i为根的集合中元素个数
    private int count;    // 数据个数

    public UnionFind3(int n) {
        count = n;
        parent = new int[count];
        size = new int[count];
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    private int find(int p){
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while (p!=parent[p]){
            p = parent[p];
        }
        return p;
    }

    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    public void unionElements(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (size[pRoot] > size[qRoot]){
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }else {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }
}
