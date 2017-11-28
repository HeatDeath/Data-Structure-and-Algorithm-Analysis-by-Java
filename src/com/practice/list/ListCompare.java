package com.practice.list;

import java.util.*;

public class ListCompare {
    private static final Integer N = 100000;
    private static final Integer LOOP_TIME = 1;
    private static List<Integer> array_list = new ArrayList<>();
    private static List<Integer> vector_list = new Vector<>();
    private static List<Integer> linked_list = new LinkedList<>();
    private static long startTime;
    private static long endTime;
    private static long runtime;

    private static void deleteElement(List list) {
        runtime = 0;
        for (int i = 0; i < LOOP_TIME; i++) {
            startTime = System.currentTimeMillis();   //获取开始时间
            for (int j = 0; j < N-1; j++) {
                list.remove(1);
//                list.remove(list.size()-1);
//                list.remove((int)(Math.random()*(list.size()-1)));
            }
            endTime = System.currentTimeMillis(); //获取结束时间
            runtime += (endTime - startTime);
        }
        runtime /= LOOP_TIME;
        System.out.println(getListName(list) + " remove(int index) 删除" +
                "操作运行时间：" + runtime + " ms");
    }

    // 随机访问
    private static void randomVisit(List list) {
        runtime = 0;
        for (int i = 0; i < LOOP_TIME; i++) {
            startTime = System.currentTimeMillis();   //获取开始时间
            for (int j = 0; j < N; j++) {
                list.get((int)(Math.random()*(N-1)));
            }
            endTime = System.currentTimeMillis(); //获取结束时间
            runtime += (endTime - startTime);
        }
        runtime /= LOOP_TIME;
        System.out.println(getListName(list) + " get(int index) 随机访问" +
                "操作运行时间：" + runtime + " ms");
    }

    // 随机位置插入元素
    private static void addElement(List list) {
        runtime = 0;
        for (int i = 0; i < LOOP_TIME; i++) {
            startTime = System.currentTimeMillis();   //获取开始时间
            for (int j = 0; j < N; j++) {
//                list.add((int)(Math.random()*j), j);
                list.add(0, j);
            }
            endTime = System.currentTimeMillis(); //获取结束时间
            runtime += (endTime - startTime);
        }
        runtime /= LOOP_TIME;
        System.out.println(getListName(list) + " add(int index, Object object) 插入" +
                "操作运行时间：" + runtime + " ms");
    }

    // 顺序访问
    private static void orderVisit(List list) {
        runtime = 0;
        for (int i = 0; i < LOOP_TIME; i++) {
            startTime = System.currentTimeMillis();   //获取开始时间
            for (Object num:list){
                continue;
            }
            endTime = System.currentTimeMillis(); //获取结束时间
            runtime += (endTime - startTime);
        }
        runtime /= LOOP_TIME;
        System.out.println(getListName(list) + "  顺序访问" +
                "操作运行时间：" + runtime + " ms");
    }

    // 获取list的名称
    private static String getListName(List list) {
        if (list instanceof LinkedList) {
            return "LinkedList";
        } else if (list instanceof ArrayList) {
            return "ArrayList";
        } else if (list instanceof Vector) {
            return "Vector";
        } else {
            return "List";
        }
    }


    public static void main(String[] args) {

        System.out.println("测试数据量为：" + N + "\r\n" + "求" + LOOP_TIME + "次测试的平均运行时间");
        System.out.println("--------------------------------");

        // 插入元素
        addElement(array_list);     // O(n)
        addElement(vector_list);    // O(n)
        addElement(linked_list);    // O(1)
        System.out.println("--------------------------------");

        // 随机读取
        randomVisit(array_list);    // O(1)
        randomVisit(vector_list);   // O(1)
        randomVisit(linked_list);   // O(n)
        System.out.println("--------------------------------");

        // 顺序读取
        orderVisit(array_list);    // O(1)
        orderVisit(vector_list);   // O(1)
        orderVisit(linked_list);   // O(1)
        System.out.println("--------------------------------");

        // 删除元素
        deleteElement(array_list);      // O(n)
        deleteElement(vector_list);     // O(n)
        deleteElement(linked_list);     // O(1)
        System.out.println("--------------------------------");
    }
}
