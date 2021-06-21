package com.learning.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arrays {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList();
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(6);
        arr.add(1);
        arr.add(5);
        reverseArray(arr);
    }

    public static List<Integer> reverseArray(List<Integer> input) {
        for(int i=0; i<input.size()/2; i++){
            Collections.swap(input, i, input.size() -i-1);
            Collections.reverse(input);
        }
        return input;
    }
}
