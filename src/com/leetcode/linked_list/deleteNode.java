package com.leetcode.linked_list;

//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//	}
//}

public class deleteNode {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
