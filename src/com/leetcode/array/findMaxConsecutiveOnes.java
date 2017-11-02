package com.leetcode.array;

public class findMaxConsecutiveOnes {
	public static int findMaxConsecutiveOnes(int[] nums) {	
		int max_conse = 0;
		int cur_conse = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				cur_conse++;
				if (cur_conse > max_conse) {
					max_conse = cur_conse;
				}
			}
			else {				
				cur_conse = 0;
			}			
		}
		
		return max_conse;
	}
	
	public static void main(String[] args) {
		int[] n = {0, 1};
		System.out.println(findMaxConsecutiveOnes(n));
	}
}
