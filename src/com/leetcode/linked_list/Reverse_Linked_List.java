package com.leetcode.linked_list;


public class Reverse_Linked_List {
	// 非递归写法
//	public ListNode reverseList(ListNode head) {
//		ListNode newHead = null;
//        while(head!=null){
//            ListNode next = head.next;
//            head.next = newHead;
//            newHead = head;
//            head = next;
//        }
//        return newHead;
//	}

	// 递归写法
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}


}
