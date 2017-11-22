package com.leetcode.sort;

import java.util.Arrays;

// 88 Merge Sorted Array

public class MergeSortedArray {
    // 简单的归并排序思路
    public void merge(int[] nums1, int m, int[] nums2, int n) {

//        int[] aux = Arrays.copyOfRange(nums1, 0, m);
//        int i = 0, j = 0;
//        for (int k = 0; k < m + n; k++) {
//            if (i >= m) {
//                nums1[k] = nums2[j];
//                j++;
//            }else if (j >= n){
//                nums1[k] = aux[i];
//                i++;
//            }else if (aux[i] > nums2[j]) {
//                nums1[k] = nums2[j];
//                j++;
//            } else if(aux[i] <= nums2[j]){
//                nums1[k] = aux[i];
//                i++;
//            }
//        }

        int i = m - 1;  // 指向 nums1[] 中数据的末尾
        int j = n - 1;  // 指向 nums2[] 中数据的末尾
        int k = m + n - 1;  // 指向 nums1[] 中需要写入数据的最后一个下标
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }

    // 从后向前 向 nums1[] 数组[m...m+n-1]区间内填充数据，不需要额外空间
    // 即使 nums2[] 中的数据先被用尽，nums2[] 中原有的数据也是相对有序的
//    public void merge(int nums1[], int m, int nums2[], int n) {
//        int i = m - 1;  // 指向 nums1[] 中数据的末尾
//        int j = n - 1;  // 指向 nums2[] 中数据的末尾
//        int k = m + n - 1;  // 指向 nums1[] 中需要写入数据的最后一个下标
//        while (i >= 0 && j >= 0)    // 当 nums1 和 nums2 中还有数据时，向 num1[k] 中存入较大的数据
//            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
//        while (j >= 0)  // 当原来 nums1[] 中的数据用尽后，将 nums2 中剩下的数据存入 nums1 中
//            nums1[k--] = nums2[j--];
//    }

    public static void main(String[] args) {
        int[] nums1 = {6, 7, 0, 0, 0};
        int m = 2;
        int[] nums2 = {2};
        int n = 1;
//        int[] nums1 = {1};
//        int m = 1;
//        int[] nums2 = {};
//        int n = 0;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, m, nums2, n);
        for (int num : nums1)
            System.out.print(num + " ");
    }
}
