package com.practice.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FaceToInterface {
    public static List changeArrToList(Integer[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int num : arr)
            result.add(num);
        result = Arrays.asList(arr);
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10000];
        for (Integer i = 0; i < 10000; i++)
            arr[i] = i;
        List<Integer> result = FaceToInterface.changeArrToList(arr);
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next());

    }

}
