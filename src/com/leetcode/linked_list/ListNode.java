package com.leetcode.linked_list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void printLinkedList(ListNode head){
//        if (head == null){
//            System.out.println();
//            return;
//        }
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("NULL\r\n");
    }
}
