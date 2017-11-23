package com.leetcode.array;

// 167 Two_Sum_II

public class Two_Sum_II {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;  // 数组头指针
        int j = numbers.length - 1; // 数组尾指针
        while (i < j) { // 两指针相遇之前
            if (numbers[i] + numbers[j] > target)   // 尾指针左移
                j--;
            else if (numbers[i] + numbers[j] < target)  // 头指针右移
                i++;
            else    // numbers[i] + numbers[j] == target 跳出循环
                break;
        }
        return new int[]{i + 1, j + 1};
    }

    public static void main(String[] args) {
//        Input: numbers={2, 7, 11, 15}, target=9
//        Output: index1=1, index2=2
//        int[] numbers = {2, 7, 11, 15};
//        int target = 9;
        int[] numbers = {2, 7, 11, 15};
        int target = 22;
        Two_Sum_II two_sum_ii = new Two_Sum_II();
        int[] result = two_sum_ii.twoSum(numbers, target);
        for (int k : result)
            System.out.print(k + " ");
    }


}
