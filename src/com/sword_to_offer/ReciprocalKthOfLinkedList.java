package com.sword_to_offer;

import java.util.Stack;

public class ReciprocalKthOfLinkedList {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        // 链表节点入栈
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.size() < k || k == 0) // 链表的长度 < k 或是 k == 0 的情况
            return null;

        while (k > 1) {
            stack.pop();
            k--;
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ReciprocalKthOfLinkedList reciprocalKthOfLinkedList = new ReciprocalKthOfLinkedList();
        ListNode head = reciprocalKthOfLinkedList.new ListNode(1);
        head.next = reciprocalKthOfLinkedList.new ListNode(9);
        head.next.next = reciprocalKthOfLinkedList.new ListNode(7);

        System.out.println(reciprocalKthOfLinkedList.FindKthToTail(head, 1).val);
    }
}


