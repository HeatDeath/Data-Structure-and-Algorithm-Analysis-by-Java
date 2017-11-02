package com.leetcode.array;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findDisappearedNumbers {
//	public List<Integer> findDisappearedNumbers(int[] nums) {
//		Set<Integer> set_1 = new HashSet<>();
//		Set<Integer> set_2 = new HashSet<>();
//		for (int i = 0; i < nums.length; i++) {
//			set_1.add(nums[i]);
//			set_2.add(i+1);
//		}
//		set_2.removeAll(set_1);
//		List list = (List) Arrays.asList(set_2.toArray());
//		return list;
//	}
	
	public ArrayList<Integer> findDisappearedNumbers(int[] nums) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] a = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			if (a[nums[i]] == 0) {
				a[nums[i]] = 1;
			}else {
				a[nums[i]] ++;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0 && i != 0) {
				list.add(i);
			}
		}
		
		return list;
	}
}
