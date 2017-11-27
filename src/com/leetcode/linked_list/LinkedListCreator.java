package com.leetcode.linked_list;

import java.util.List;

public class LinkedListCreator {
    public ListNode createLinkedList(List<Integer> data) {
        if (data.isEmpty())
            return null;
        ListNode head = new ListNode(data.get(0));
        head.next = createLinkedList(data.subList(1, data.size()));
        return head;
    }



}
