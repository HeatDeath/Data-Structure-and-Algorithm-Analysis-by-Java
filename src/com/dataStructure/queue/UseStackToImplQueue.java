package com.dataStructure.queue;

import java.util.Stack;

public class UseStackToImplQueue {
    private Stack<Integer> stack_1;
    private Stack<Integer> stack_2;
    private int count;
    public UseStackToImplQueue(){
        stack_1 = new Stack<>();
        stack_2 = new Stack<>();
        count = 0;
    }

    public void enqueue(int num){
//        if (stack_1.isEmpty() && stack_2.isEmpty()){
//            stack_1.push(num);
//        }else if (!stack_2.isEmpty()){
//            while (!stack_2.isEmpty()){
//                stack_1.push(stack_2.pop());
//            }
//            stack_1.push(num);
//        }

        while (!stack_2.isEmpty()){
            stack_1.push(stack_2.pop());
        }
        stack_1.push(num);
        count++;
    }

    public int dequeue(){
//        if (!stack_2.isEmpty()){
//            return stack_2.pop();
//        }else {
//            while (!stack_1.isEmpty()){
//                stack_2.push(stack_1.pop());
//            }
//            return stack_2.pop();
//        }

        while (!stack_1.isEmpty()){
            stack_2.push(stack_1.pop());
        }
        count--;
        return stack_2.pop();
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public static void main(String[] args){
        UseStackToImplQueue queue = new UseStackToImplQueue();
        queue.enqueue(6);
        queue.enqueue(2);
        queue.enqueue(1);
        System.out.print(queue.dequeue() + " ");
        queue.enqueue(3);
        System.out.print(queue.dequeue() + " ");
        queue.enqueue(5);
        queue.enqueue(7);
        System.out.print(queue.dequeue() + " ");
        while (!queue.isEmpty()){
            System.out.print(queue.dequeue() + " ");
        }

//        System.out.println();
//        System.out.println("----------------------------");
//
//        Stack<Integer> stack = new Stack<>();
//        stack.push(6);
//        stack.push(2);
//        stack.push(1);
//        stack.push(3);
//        stack.push(5);
//        stack.push(7);
//        while (!stack.isEmpty()){
//            System.out.print(stack.pop() + " ");
//        }
//


    }

}
