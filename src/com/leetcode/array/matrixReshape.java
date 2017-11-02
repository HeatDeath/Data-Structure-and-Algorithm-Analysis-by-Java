package com.leetcode.array;

import java.util.ArrayList;

public class matrixReshape {
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int row_num = nums.length;
		int col_num = nums[0].length;

		if (r*c != row_num*col_num) {
			return nums;
		}
		
		int[][] result_arr = new int[r][c];
		
		ArrayList<Integer> middle_arr = new ArrayList<Integer>();
		
		for (int[] num:nums) {
			for (int element : num) {
				middle_arr.add(element);
			}
		}
		
	
		for(int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result_arr[i][j] = middle_arr.get(i*c + j);
			}
		}
		
		return result_arr;
	
	}
	
	public static void main(String[] args) {
		int[][] n = {{1,2},{3,4}};
		
		matrixReshape(n , 1, 4);
		
		
		
	}
}
