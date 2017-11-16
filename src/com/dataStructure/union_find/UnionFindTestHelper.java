package com.dataStructure.union_find;

// 测试并查集
public class UnionFindTestHelper {

    // 测试第一版本的并查集, 测试元素个数为n
    private static void testUnionFind1(int n) {
        UnionFind1 unionFind1 = new UnionFind1(n);

        long startTime = System.currentTimeMillis();

        // 进行 n 次操作，每次随机选择两个元素进行合并操作
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            unionFind1.unionElements(a, b);
        }

        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            unionFind1.isConnected(a, b);
        }

        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UnionFind_1 " + 2 * n + " ops, " + (endTime - startTime) + " ms ");
    }

    // 测试第二版本的并查集, 测试元素个数为n
    private static void testUnionFind2(int n){
        UnionFind2 unionFind2 = new UnionFind2(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            unionFind2.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            unionFind2.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("unionFind_2 " + 2*n + " ops, " + (endTime-startTime) + " ms");
    }

    // 测试第三版本的并查集, 测试元素个数为n
    private static void testUnionFind3(int n){
        UnionFind3 unionFind3 = new UnionFind3(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            unionFind3.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            unionFind3.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("unionFind_2 " + 2*n + " ops, " + (endTime-startTime) + " ms");
    }

    // 测试第四版本的并查集, 测试元素个数为n
    private static void testUnionFind4(int n){
        UnionFind4 unionFind4 = new UnionFind4(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            unionFind4.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            unionFind4.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("unionFind_2 " + 2*n + " ops, " + (endTime-startTime) + " ms");
    }

    public static void main(String[] args){
        int N = 100000;
        testUnionFind1(N);
        testUnionFind2(N);
        testUnionFind3(N);
        testUnionFind4(N);
    }

}
