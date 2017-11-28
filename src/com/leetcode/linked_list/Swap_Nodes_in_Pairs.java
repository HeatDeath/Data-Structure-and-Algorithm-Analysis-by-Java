package com.leetcode.linked_list;

import java.util.Arrays;

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode beh = head.next;
        while (beh != null) {
            cur.next = beh.next;
            beh.next = pre.next;
            pre.next = beh;

            pre = cur;
            cur = cur.next;
            if (cur == null)
                break;

            beh = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        LinkedListCreator creator = new LinkedListCreator();
        Swap_Nodes_in_Pairs swap = new Swap_Nodes_in_Pairs();

//        ListNode head = creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 5, 4, 3));
        ListNode head = creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 5, 4));

        ListNode.printLinkedList(head);
//        ListNode head = creator.createLinkedList(Arrays.asList(1, 2));
        ListNode.printLinkedList(swap.swapPairs(head));
    }
}
