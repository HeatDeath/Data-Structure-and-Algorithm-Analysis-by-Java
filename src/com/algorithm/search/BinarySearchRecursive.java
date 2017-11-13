package com.algorithm.search;

public class BinarySearchRecursive {
    private BinarySearchRecursive() {
    }

    public static int find(Integer[] arr, Integer target) {
        return find(arr, 0, arr.length - 1, target);
    }

    private static int find(Integer[] arr, int l, int r, Integer target) {

        if (l > r) return -1;

        // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
        int mid = l + (r - l) / 2;

        if (arr[mid].compareTo(target) > 0) {
            return find(arr, l, mid - 1, target);
        } else if (arr[mid].compareTo(target) < 0) {
            return find(arr, mid + 1, r, target);
        } else { // arr[mid].compareTo(target) == 0
            return mid;
        }
    }

    // 测试递归的二分查找算法
    public static void main(String[] args) {

        int N = 1000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Integer(i);

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for (int i = 0; i < 2 * N; i++) {
            int v = BinarySearchRecursive.find(arr, new Integer(i));
            if (i < N) {
                System.out.print(i);
                System.out.println(v == i);
            } else {
                System.out.print(i);
                System.out.println(v == -1);
            }
        }

        return;
    }


}
