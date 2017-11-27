package com.leetcode.linked_list;

import java.util.Arrays;

public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }

//        public ListNode reverseBetween(ListNode head, int m, int n) {
//        if (head.next == null || head == null || m == n)
//            return head;
//
//        ListNode pos_n = head;
//        int pos = 1;
//        ListNode pre_m;
//        ListNode pos_m;
//        if (m != 1) {
//            pre_m = head;
//            while (pos < m - 1) {
//                pre_m = pre_m.next;
//                pos++;
//            }
//            pos_m = pre_m.next;
//        } else {
//            pre_m = null;
//            pos_m = head;
//        }
//
//
//        while (pos < n) {
//            pos_n = pos_n.next;
//            pos++;
//        }
//        ListNode after_n = pos_n.next;
//
//        if (after_n != null){
//            pos_n = pos_n.next;
//            after_n = pos_n.next;
//        }
//
//
//        ListNode newHead = after_n;
//        while (m <= n) {
//            ListNode nextNode = pos_m.next;
//            pos_m.next = newHead;
//            newHead = pos_m;
//            pos_m = nextNode;
//            m++;
//        }
//        if (pre_m != null)
//            pre_m.next = newHead;
//
//        if (pre_m == head)  // m == 2 的情况
//            return pre_m;
//
//        if (after_n == null || pre_m == null)   // 对于 m == 1 或是 n == list.length 的情况
//            return newHead;
//
//        return head;
//    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        Reverse_Linked_List_II reverse = new Reverse_Linked_List_II();

        ListNode head = creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 5, 4, 3));
        ListNode.printLinkedList(head);
        ListNode.printLinkedList(reverse.reverseBetween(head, 3, 7));

        ListNode head_1 = creator.createLinkedList(Arrays.asList(5));
        ListNode.printLinkedList(head_1);
        ListNode.printLinkedList(reverse.reverseBetween(head_1, 1, 1));

        ListNode head_2 = creator.createLinkedList(Arrays.asList(3, 5));
        ListNode.printLinkedList(head_2);
        ListNode.printLinkedList(reverse.reverseBetween(head_2, 2, 2));

//        ListNode head_3 = creator.createLinkedList(Arrays.asList(3, 5, 6, 7, 8));
//        ListNode.printLinkedList(head_3);
//        ListNode.printLinkedList(reverse.reverseBetween(head_3, 1, 5));
//        ListNode.printLinkedList(reverse.reverseBetween(head_3, 2, 5));
//        ListNode.printLinkedList(reverse.reverseBetween(head_3, 1, 4));

        ListNode head_4 = creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode.printLinkedList(head_4);
        ListNode.printLinkedList(reverse.reverseBetween(head_4, 1, 4));


    }
}
