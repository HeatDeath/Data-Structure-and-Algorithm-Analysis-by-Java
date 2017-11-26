package com.dataStructure.linked_list;

import java.util.ArrayList;
import java.util.Arrays;


public class LinkedListReverse {
    /*
    * @param 用于反转的链表的 head
    * @return 反转后的链表的 head
    * */
    public Node reverseLinkedList(Node head){
        if (head == null || head.getNext() == null)
            return head;
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] args){
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        LinkedListReverse reverse = new LinkedListReverse();
        Node.printLinkedList(reverse.reverseLinkedList(linkedListCreator.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(reverse.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(reverse.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
    }
}
