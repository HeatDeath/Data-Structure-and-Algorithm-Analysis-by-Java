package com.dataStructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class UseQueueToImplStack {
    private Queue<Integer> queue_1;
    private Queue<Integer> queue_2;
    private int count;
    public UseQueueToImplStack(){
        queue_1 = new LinkedList<>();
        queue_2 = new LinkedList<>();
        count = 0;
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public void push(int num){
        queue_1.add(num);
        count++;
    }

    public int pop(){
        while (queue_1.size() > 1)
            queue_2.add(queue_1.remove());
        int result = queue_1.remove();
        count--;

        while (!queue_2.isEmpty())
            queue_1.add(queue_2.remove());

        return result;
    }

    public static void main(String[] args){
        UseQueueToImplStack stack = new UseQueueToImplStack();
        stack.push(6);
        stack.push(2);
        stack.push(1);
        System.out.print(stack.pop() + " ");
        stack.push(3);
        System.out.print(stack.pop() + " ");
        stack.push(5);
        System.out.print(stack.pop() + " ");
        stack.push(7);

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }

}
