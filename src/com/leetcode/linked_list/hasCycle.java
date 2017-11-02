package com.leetcode.linked_list;

public class hasCycle {
	public boolean hasCycle(ListNode head) {
		ListNode pre = head;
		ListNode p = head;
		while (p != null && p.next != null) {
			if (p.next == head) {
				return true;
			}
			p = p.next;
			pre.next = head;
			pre = p;
		}
		return false;
	}
}
