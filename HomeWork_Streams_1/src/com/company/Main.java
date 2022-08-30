package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        //  System.out.println(filter(intList));
        for (int num : filter(intList)) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> filter(List<Integer> intList) {
        List<Integer> newIntList = new ArrayList<>();
        for (int num : intList) {
            if ((num > 0) && (num % 2 == 0)) {
                newIntList.add(num);
            }
        }
        newIntList.sort(Integer::compareTo);
        return newIntList;
    }

}
