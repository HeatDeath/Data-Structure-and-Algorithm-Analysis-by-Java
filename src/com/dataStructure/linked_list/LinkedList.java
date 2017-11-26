package com.dataStructure.linked_list;

public class LinkedList {
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(Node node) {
            this.val = node.val;
            this.next = node.next;
        }
    }

    private Node head;
    private int pos;

    public LinkedList() {
        head = null;
        pos = 0;
    }

    public void addHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public Node deleteHead() {
        Node temp = head;
        head = temp.next;
        return temp;
    }

    public void insertTo(int index, int val) {
        Node node = new Node(val);
        Node cur = head;
        Node pre = head;
        while (pos != index) {
            pre = cur;
            cur = cur.next;
            pos++;
        }
        node.next = cur;
        pre.next = node;
        pos = 0;
    }

    public Node deleteBy(int index) {
        Node cur = head;
        Node pre = head;
        while (pos != index) {
            pre = cur;
            cur = cur.next;
            pos++;
        }
        pre.next = cur.next;
        cur.next = null;
        return cur;
    }


}
