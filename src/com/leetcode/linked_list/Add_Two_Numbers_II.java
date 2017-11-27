package com.leetcode.linked_list;

import java.util.Arrays;
import java.util.Stack;

public class Add_Two_Numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack_1 = new Stack<>();
        Stack<Integer> stack_2 = new Stack<>();
        while (l1 != null) {
            stack_1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack_2.push(l2.val);
            l2 = l2.next;
        }
        ListNode cur = null;
        int carry = 0;
        while (!stack_1.isEmpty() || !stack_2.isEmpty() || carry != 0) {
            int sum = (stack_1.isEmpty() ? 0 : stack_1.pop()) + (stack_2.isEmpty() ? 0 : stack_2.pop()) + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            node.next = cur;
            cur = node;
        }
        return cur;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        Add_Two_Numbers_II add_two_numbers = new Add_Two_Numbers_II();

//        ListNode l1 = creator.createLinkedList(Arrays.asList(1, 2, 3));
//        ListNode l2 = creator.createLinkedList(Arrays.asList(1));

//        ListNode l1 = creator.createLinkedList(Arrays.asList(1, 2, 3));
//        ListNode l2 = creator.createLinkedList(Arrays.asList(1, 2, 3, 2, 1, 3, 1, 1));

        ListNode l1 = creator.createLinkedList(Arrays.asList(5));
        ListNode l2 = creator.createLinkedList(Arrays.asList(5));

        ListNode.printLinkedList(add_two_numbers.addTwoNumbers(l1, l2));

    }
}
