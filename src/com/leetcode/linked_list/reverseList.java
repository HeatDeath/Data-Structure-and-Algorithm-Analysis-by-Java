package com.leetcode.linked_list;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class reverseList {
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
	}
}
