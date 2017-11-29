package com.dataStructure.heap;

import java.lang.*;

public class MaxHeap {
    protected Integer[] data;
    protected int count;
    protected int capacity;

    // 构造函数，构造一个空的堆，可以容纳 capacity 个元素
    public MaxHeap(int capacity) {
        data = new Integer[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 构造函数，用 Heapify 的方式使用数组构建最大堆
    // 根据堆的性质, 只要保证部分有序即可, 即根节点大于左右节点的值.
    // 将数组抽象为一个完全二叉树, 所以只要从【最后一个非叶子节点】向前遍历每一个节点即可.
    // 如果当前节点比左右子树节点都大, 则已经是一个最大堆, 否则将当前节点与左右节点较大的一个交换。
    public MaxHeap(Integer[] arr){
        int n = arr.length;
        data = new Integer[n+1];
        capacity = n;

        for (int i =0; i<n;i++){
            data[i+1] = arr[i];
        }
        count = n;

        // 从最后一个非叶子节点向前遍历到根节点，从每一个节点进行 shiftDown 操作
        for (int i = count/2; i >= 1; i--){
            shiftDown(i);
        }

    }

    // 返回堆中元素的个数
    public int size() {
        return count;
    }

    // 返回一个布尔值，表示堆是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向最大堆中插入一个新的元素 item
    public void insert(Integer item) {
        if (count + 1 > capacity) {
            System.out.println("元素数量已经达到堆容量的最大值！");
            return;
        }
        // 先将 item 放在堆的末尾
        data[count + 1] = item;
        count++;
        // 上浮 item
        shiftUp(count);
    }

    // 将堆中 k 位置的元素 上浮 到合适的位置
    private void shiftUp(int k) {
        // 如果 当前节点（k指向的位置） 不是根节点，且 父节点 < 当前节点
        // 进行循环
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    // 将堆中 i 和 j 位置的元素进行交换
    private void swap(int i, int j) {
        Integer temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // 从堆中取出堆顶元素，即堆中所存储的最大元素
    public Integer extractMax() {
        if (count <= 0 ){
            System.out.println("堆已空！");
            return null;
        }
        Integer ret = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    // 将堆顶元素 下沉 到合适的位置
    private void shiftDown(int k){
        while (2*k <= count){
            int j = 2*k;

            // 如果 有 右子节点 且 右子节点 > 左子节点
            if (j+1 <= count && data[j+1].compareTo(data[j]) > 0){
                // j 移动到 右子节点 处
                j++;
            }

            // 如果 根节点 > 子节点中较大者
            if (data[k].compareTo(data[j]) >= 0){
                // 跳出循环
                break;
            }

            // 交换 根节点 和 子节点中较大者
            swap(k, j);

            // 移动 k
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);

        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)

        for (int i = 0; i < N; i++)
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        System.out.println(maxHeap.size());

//        for (Integer item : maxHeap.data) {
//            System.out.print(item + " ");
//        }

        while (maxHeap.count != 0){
            System.out.print(maxHeap.extractMax() + " ");
        }
    }
}
