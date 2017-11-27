package com.leetcode.linked_list;

import java.util.Arrays;

public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = node;
            cur = node;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return dummy.next;
    }

    /*
    * 1560 / 1562 test cases passed.
    * Input:
    * [2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]
    * [5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]
    * 溢出
    * */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long num1 = 0;
//        int pos = 0;
//        while (l1 != null) {
//            num1 += (long) (l1.val * Math.pow(10, pos++));
//            l1 = l1.next;
//        }
//
//        long num2 = 0;
//        pos = 0;
//        while (l2 != null) {
//            num2 += (long) (l2.val * Math.pow(10, pos++));
//            l2 = l2.next;
//        }
//
//        long sum = num1 + num2;
//        ListNode dummy = new ListNode(0);
//        if (sum == 0) {
//            return dummy;
//        }
//
//        ListNode cur = dummy;
//        while (sum != 0) {
//            ListNode node = new ListNode((int) (sum % 10));
//            cur.next = node;
//            cur = node;
//            sum /= 10;
//        }
//        cur.next = null;
//        return dummy.next;
//    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        Add_Two_Numbers add_two_numbers = new Add_Two_Numbers();

//        ListNode l1 = creator.createLinkedList(Arrays.asList(1, 2, 3));
//        ListNode l2 = creator.createLinkedList(Arrays.asList(1));

        // 溢出的情况，将 int 换为 long
//        ListNode l1 = creator.createLinkedList(Arrays.asList(9));
//        ListNode l2 = creator.createLinkedList(Arrays.asList(1, 9, 9, 9, 9, 9, 9, 9, 9, 9));

        ListNode l1 = creator.createLinkedList(Arrays.asList(3, 9, 9, 9, 9, 9, 9, 9, 9, 9));
        ListNode l2 = creator.createLinkedList(Arrays.asList(7));

        ListNode.printLinkedList(add_two_numbers.addTwoNumbers(l1, l2));
    }

}
