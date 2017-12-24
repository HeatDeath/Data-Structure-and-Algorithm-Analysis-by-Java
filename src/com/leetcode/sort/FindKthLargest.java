package com.leetcode.sort;

// 215 FindKthLargest

import java.awt.*;
import java.util.*;
import java.util.List;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new MyComparator());
        for(int num:nums)
            queue.add(num);
        while (queue.size() > nums.length - k +1)
            queue.remove();
        return queue.peek();
    }

    class MyComparator implements Comparator{
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


    // ------------------------------------------------------------------
//    public int findKthLargest(int[] nums, int k) {
//        int  n = nums.length;
//        return solve(nums, 0, n-1, k-1);
//    }
//
//    int solve(int[] nums, int l, int r, int target){
//        int  p = partition(nums, l, r);
//
//        if(target == p)
//            return nums[p];
//        else if(target > p)
//            return solve(nums, p+1, r, target);
//        else
//            return solve(nums, l, p-1, target);
//
//    }
//
//    int partition(int[] nums, int l, int r){
//        int lt = l+1, gt = r;
//
//        while(lt<=gt){
//            while(lt <= r && nums[lt] > nums[l])
//                lt++;
//            while(gt>= l+1 && nums[gt] < nums[l])
//                gt--;
//            if(lt > gt)
//                break;
//            swap(nums, lt, gt);
//            lt++;
//            gt--;
//        }
//        swap(nums, l, gt);
//        return gt;
//    }


    // ------------------------------------------------------------------
//    public int findKthLargest(int[] nums, int k) {
//        int n = nums.length;
//        return solve(nums, 0, n - 1, k-1);
//    }
//    private int solve(int[] nums, int l, int r, int target) {
//        int p = partition(nums, l, r);
//        if (p == target)
//            return nums[p];
//        else if (p > target)
//            return solve(nums, l, p-1, target);
//        else
//            return solve(nums, p+1, r, target);
//    }
//
//    private int partition(int[] nums, int l, int r) {
//        int temp = nums[l];
//        int i = l + 1, j = l;
//        for (; i <= r; i++) {
//            if (nums[i] > temp)
//                swap(nums, i, ++j);
//        }
//        swap(nums, l, j);
//        return j;
//    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int[] generateRandomArray(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = ((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        return arr;
    }

    public static void main(String[] args){
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = findKthLargest.generateRandomArray(10, 0, 30);

        for (int num: nums)
            System.out.print(num + " ");
        System.out.println();

        int target = 3;
        System.out.print(findKthLargest.findKthLargest(nums, target));
        System.out.println();

//        QuickSort.sort(nums);
//        for (int num: nums)
//            System.out.print(num + " ");
//        System.out.println();

    }
}
