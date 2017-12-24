package com.sword_to_offer;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePrintLinkedList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result_list = new ArrayList<>();

        if (listNode != null)
            if (listNode.next != null)
                result_list = printListFromTailToHead(listNode.next);
            result_list.add(listNode.val);

        return result_list;
    }


//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        Stack<Integer> stack = new Stack<>();
//        while (listNode != null){
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        ArrayList<Integer> result_list = new ArrayList<>();
//        while (!stack.isEmpty())
//            result_list.add(stack.pop());
//        return result_list;
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(9);
        head.next.next = new ListNode(7);
        ArrayList<Integer> list = new ReversePrintLinkedList().printListFromTailToHead(head);
        for (Integer num: list)
            System.out.println(num);
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

