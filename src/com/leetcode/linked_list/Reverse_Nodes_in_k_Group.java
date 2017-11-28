package com.leetcode.linked_list;

import java.util.Arrays;

public class Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode dummy_1 = new ListNode(0);
        ListNode cur_1 = dummy_1;
        ListNode dummy_2 = new ListNode(0);
        ListNode cur_2 = dummy_2;
        ListNode dummy_3 = new ListNode(0);
        ListNode cur_3 = dummy_3;
        int pos = 1;
        while (head != null) {
            if (pos % k == 0) {
                cur_1.next = head;
                cur_1 = head;
            } else {
                cur_2.next = head;
                cur_2 = head;
            }
            head = head.next;
            pos++;
        }
        cur_1.next = null;
        cur_2.next = null;

        dummy_1 = dummy_1.next;
        dummy_2 = dummy_2.next;
        int count = 0;
        while (dummy_1 != null) {
            cur_3.next = dummy_1;
            cur_3 = cur_3.next;
            dummy_1 = dummy_1.next;

            while (count < k - 1) {
                cur_3.next = dummy_2;
                cur_3 = cur_3.next;
                dummy_2 = dummy_2.next;
                count++;
            }
        }
        cur_3.next = dummy_2;
        return dummy_3.next;

    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        Reverse_Nodes_in_k_Group reverse = new Reverse_Nodes_in_k_Group();

//        ListNode head = creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 5, 4, 3));
        ListNode head = creator.createLinkedList(Arrays.asList(1,2,3));

        ListNode.printLinkedList(head);
//        ListNode head = creator.createLinkedList(Arrays.asList(1, 2));
        ListNode.printLinkedList(reverse.reverseKGroup(head, 3));
    }

}
