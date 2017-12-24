package com.test.aaa;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindFirstKElements {
    public int[] findFirstKElements(int[] nums,int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        return new int[]{1,2,3};
    }


    public int[] generateRandomArray(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = ((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        return arr;
    }
}

class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int num1 = (int) o1;
        int num2 = (int) o2;
        if (num1 < num2)
            return 1;
        else if (num1 > num2)
            return -1;
        return 0;
    }
}
