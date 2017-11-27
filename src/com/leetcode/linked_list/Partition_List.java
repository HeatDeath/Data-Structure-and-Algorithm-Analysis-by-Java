package com.leetcode.linked_list;

import java.util.Arrays;

public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        Partition_List partition_list = new Partition_List();

//        ListNode head = creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 2, 1, 2));
//        ListNode.printLinkedList(head);
//        ListNode.printLinkedList(partition_list.partition(head, 3));

        ListNode head = creator.createLinkedList(Arrays.asList(1, 4, 3, 2, 5, 2));
        ListNode.printLinkedList(head);
        ListNode.printLinkedList(partition_list.partition(head, 3));
    }
}
