package com.dataStructure.linked_list;

public class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printLinkedList(Node head){
//        if (head == null){
//            System.out.println();
//            return;
//        }
        while (head != null){
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }
        System.out.println();
    }
}
