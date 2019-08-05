package com.practice.algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SockMerchant {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

    int n = scanner.nextInt(),count =0;
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[n];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
        int arItem = Integer.parseInt(arItems[i]);
        if(arItem > 100 || arItem < 1) {
        	break;
        }
        ar[i] = arItem;
        if(list.contains(arItem) && !list.isEmpty()) {
        	count++;
        	list.remove(list.indexOf(arItem));
        }else{
        	list.add(arItem);
        }
    }
    if(n > 100 || n < 0 ) {
    	count = 0;
    }
	int result = count;

    scanner.close();
}
}
