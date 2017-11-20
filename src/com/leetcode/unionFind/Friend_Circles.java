package com.leetcode.unionFind;

//  547. Friend Circles
/*
There are N students in a class. Some of them are friends, while some are not.
Their friendship is transitive in nature. For example, if A is a direct friend of B,
 and B is a direct friend of C, then A is an indirect friend of C.
 And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class.
 If M[i][j] = 1, then the ith and jth students are direct friends with each other,
 otherwise not. And you have to output the total number of friend circles among all
 the students.
*/
public class Friend_Circles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind5 unionFind = new UnionFind5(n);
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (M[i][j] == 1)
                    unionFind.unionElements(i, j);


        for (int kkk : unionFind.parent){
            System.out.print(kkk+" ");
        }

        int count = 0;

        for (int i = 0; i < n; i++)
            if (i == unionFind.parent[i])
                count++;

        return count;
    }

    class UnionFind5 {

        // rank[i]表示以i为根的集合所表示的树的层数
        // 在后续的代码中, 我们并不会维护rank的语意, 也就是rank的值在路径压缩的过程中, 有可能不在是树的层数值
        // 这也是我们的rank不叫height或者depth的原因, 他只是作为比较的一个标准
        private int[] rank;
        private int[] parent; // parent[i]表示第i个元素所指向的父节点
        private int count;    // 数据个数

        // 构造函数
        public UnionFind5(int count) {
            rank = new int[count];
            parent = new int[count];
            this.count = count;
            // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
            for (int i = 0; i < count; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // 查找过程, 查找元素p所对应的集合编号
        // O(h)复杂度, h为树的高度
        private int find(int p) {
            assert (p >= 0 && p < count);

            // path compression 1
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;

            // path compression 2, 递归算法
//            if( p != parent[p] )
//                parent[p] = find( parent[p] );
//            return parent[p];
        }

        // 查看元素p和元素q是否所属一个集合
        // O(h)复杂度, h为树的高度
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        // 合并元素p和元素q所属的集合
        // O(h)复杂度, h为树的高度
        public void unionElements(int p, int q) {

            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot)
                return;

            // 根据两个元素所在树的元素个数不同判断合并方向
            // 将元素个数少的集合合并到元素个数多的集合上
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[qRoot] < rank[pRoot]) {
                parent[qRoot] = pRoot;
            } else { // rank[pRoot] == rank[qRoot]
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;   // 此时, 我维护rank的值
            }
        }
    }

    public static void main(String[] args) {
        int[][] inputData = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Friend_Circles friend_circles = new Friend_Circles();
        System.out.println(friend_circles.findCircleNum(inputData));
//        System.out.println(friend_circles);
    }
}