package com.dataStructure.union_find;

public class UnionFind1 {
    // 第一版的 Union-Find 本质是一个数组
    private int[] id;
    // 数据个数
    private int count;

    public UnionFind1(int n) {
        count = n;
        id = new int[n];
        // 初始化，使每一个 id[i] 指向自己，没有合并的元素
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    // 查找过程，查找元素 p 所对应的集合编号
    // 复杂度 O(1)
    public int find(int p) {
        return id[p];
    }

    // 查看元素 p 和 元素 q 是否属于同一个集合
    // 复杂度 O(1)
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素 p 和元素 q 所属的集合
    // 复杂度 O(n)
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        // 合并过程需要遍历一遍所有元素, 将两个元素的所属集合编号合并
        for (int i = 0; i < count; i++) {
            if (id[i] == pID)
                id[i] = qID;
        }
    }


}
