package com.practice.heap;

public class MaxHeap {
    private Integer[] data;
    private int capacity;
    private int count;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        count = 0;
        data = new Integer[capacity + 1];
    }

    public MaxHeap(Integer[] inputData) {
        capacity = inputData.length;
        data = new Integer[capacity + 1];
        count = inputData.length;

        System.arraycopy(inputData, 0, data, 1, inputData.length);
//        for (int i = 0; i < inputData.length; i++) {
//            data[i+1] = inputData[i];
//        }

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Integer element) {
        data[++count] = element;
        shiftUp(count);
    }

    public Integer extractMax() {
        Integer maxOfHeap = data[1];
        swap(data, 1, count);
        shiftDown(1);
        count--;
        return maxOfHeap;
    }

//    private void shiftDown(int pos) {
//        int leftChildPos = pos * 2;
//        while (leftChildPos <= count) {   // 当左孩子存在时
//            int swapPos = leftChildPos;
//            if (leftChildPos + 1 < count)   // 右孩子存在
//                if (data[leftChildPos + 1] > data[leftChildPos])    // 左孩子 < 右孩子
//                    swapPos = leftChildPos + 1;
//            if (data[pos] > data[swapPos])
//                break;
//            swap(data, pos, swapPos);
//            shiftDown(swapPos);
//        }
//    }
    private void shiftDown(int pos) {
        while (pos * 2 <= count) {   // 当左孩子存在时
            int swapPos = pos * 2;
            if (swapPos + 1 < count)   // 右孩子存在
                if (data[swapPos + 1] > data[swapPos])    // 左孩子 < 右孩子
                    swapPos++;
            if (data[pos] > data[swapPos])
                break;
            swap(data, pos, swapPos);
            pos = swapPos;
        }
    }

//    private void shiftUp(int pos) {
//        int parent_pos = pos / 2;
//        while (parent_pos != 0 && data[pos] > data[parent_pos]) {
//            swap(data, pos, parent_pos);
//            shiftUp(parent_pos);
//        }
//    }

    private void shiftUp(int pos) {
        while (pos > 1 && data[pos] > data[pos / 2]) {
            swap(data, pos, pos / 2);
            pos /= 2;
        }
    }

    private void swap(Integer[] data, int i, int j) {
        Integer temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(10);
        heap.insert(12);
        heap.insert(8);
        heap.insert(13);
        heap.insert(11);
        heap.insert(18);

        for (Integer num : heap.data)
            System.out.print(num + " ");

        System.out.println();

        heap.extractMax();
        for (Integer num : heap.data)
            System.out.print(num + " ");

        System.out.println("-----------------------------");

        Integer[] inputData = {10, 12, 8, 13, 11, 18};
        MaxHeap heap1 = new MaxHeap(inputData);

        for (Integer num : heap1.data)
            System.out.print(num + " ");

        System.out.println();

        heap1.extractMax();
        for (Integer num : heap1.data)
            System.out.print(num + " ");
    }

}
