package com.dataStructure.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListCreator {
    /*
    * 通过一个 list 创建一个 linkedList
    *
    * @param 创建链表用的 list
    * @return 链表的 head。返回链表的最后一个节点的 next 为 null
    * */
    public Node createLinkedList(List<Integer> data) {
        if (data.isEmpty())
            return null;
        Node head = new Node(data.get(0));
        head.setNext(createLinkedList(data.subList(1, data.size())));
        return head;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        Node.printLinkedList(linkedListCreator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));
    }

}
