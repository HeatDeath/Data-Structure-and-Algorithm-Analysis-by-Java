package com.leetcode.linked_list;

public class isPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		ListNode one_step = head;
		ListNode two_step = head;
		
		while (two_step.next != null && two_step.next.next != null) {
			one_step = one_step.next;
			two_step = two_step.next.next;
		}
		// 将 one_step 移动到 中间位置 偏右的位置
		one_step = one_step.next;
		ListNode temp = null;
		ListNode temp_2 = one_step;
		
//		if (two_step.next == null) {
//			// 链表的长度为奇数（2n-1），two_step 应该为 链表的最后一个节点
//			// one_step 为链表的中点（n）			
//			
//		}else {
//			// 链表的长度为偶数（2n），two_step 应该为 链表的最后一个节点前的一个节点
//			// one_step 为链表的中点（n）
//			
//			two_step = two_step.next;	
//			
//		}
		
		// 当表长为偶数时，将 two_step 后移一位
		if (two_step.next != null) {
			two_step = two_step.next;	
		}
		
		// 反转链表的后半段
		while (one_step != two_step) {
			one_step = one_step.next;
			temp_2.next = temp;
			temp = temp_2;
			temp_2 = one_step;
		}
//		two_step.next = one_step;
		
		// 将链表的后半部分与前半部分进行比较，判断时候为回文链表
		while (one_step != null) {
			if (one_step.val == head.val) {
				one_step = one_step.next;
				head = head.next;
			}else {
				return false;
			}
		}
		
		return true;
	}
}
