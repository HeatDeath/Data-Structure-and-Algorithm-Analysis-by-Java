package com.leetcode.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr1 = dummy1, curr2 = dummy2;
        int pos = 1;
        while (head != null){
            if (pos % 2 == 1){
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
            pos++;
        }
        curr1.next = dummy2.next;
        curr2.next = null;
        return dummy1.next;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        Odd_Even_Linked_List odd_even_linked_list = new Odd_Even_Linked_List();

//        ListNode head = creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
//        ListNode head = creator.createLinkedList(Arrays.asList(1));
//        ListNode head = creator.createLinkedList(Arrays.asList(1, 2));
        ListNode head = creator.createLinkedList(new ArrayList<>());

        ListNode.printLinkedList(head);
        ListNode.printLinkedList(odd_even_linked_list.oddEvenList(head));
    }

}
