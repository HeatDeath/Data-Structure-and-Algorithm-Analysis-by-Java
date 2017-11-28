package com.leetcode.linked_list;

// 203. Remove Linked List Elements

import java.util.Arrays;

public class Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        Remove_Linked_List_Elements remove = new Remove_Linked_List_Elements();

//        ListNode head = creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 5, 4, 3));
        ListNode head = creator.createLinkedList(Arrays.asList(1, 2, 1));

        ListNode.printLinkedList(head);
        ListNode.printLinkedList(remove.removeElements(head, 1));
    }
}
