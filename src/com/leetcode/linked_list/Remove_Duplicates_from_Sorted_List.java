package com.leetcode.linked_list;

public class Remove_Duplicates_from_Sorted_List {
    public ListNode removeDuplicates(ListNode head){
        ListNode temp = head;
        while (temp != null && temp.next != null)
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        return head;
    }

}
