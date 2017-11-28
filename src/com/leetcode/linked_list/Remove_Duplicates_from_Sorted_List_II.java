package com.leetcode.linked_list;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        Remove_Duplicates_from_Sorted_List_II remove = new Remove_Duplicates_from_Sorted_List_II();

//        ListNode head = creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 5, 4, 3));
        ListNode head = creator.createLinkedList(Arrays.asList(1, 1));
        ListNode.printLinkedList(remove.deleteDuplicates(head));

    }
}
