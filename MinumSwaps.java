package com.practice.algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumSwaps {
	static int count = 0;

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	int midElement = 0;
    	if(arr.length%2 == 0) {
    		midElement = arr.length/2 +1;
    	}else {
    		midElement = arr.length/2 ;
    	}
    	findHighest(arr[midElement], arr, midElement);
    	System.out.println("count "+count);
    	return count;
    }
    
    static void findHighest(int element, int[] arr, int midElement) {  
    	if(checkIfsorted(Arrays.copyOfRange(arr,0, midElement))) {
    		if(arr.length%2 == 0) {
        		System.out.println(arr.length/2);
        		midElement = arr.length/2 +1;
        	}else {
        		System.out.println(arr.length/2);
        		midElement = arr.length/2 ;
        	}
    		findLeastest(arr[midElement], arr, midElement, true, false);
		}
    	for(int k=0; k<arr.length ;k++) {
    		System.out.print(arr[k]+ " ");
    	}
    	System.out.println();
    	System.out.println("highest element - "+element+ " midElement - "+midElement);
    	int maxElementIndex = -1, maxElement = element, minElement = element, minElementIndex = -1 ;
    	for(int i=0; i < midElement ; i++) {
    		if(arr[i] > maxElement) {
    			maxElement = arr[i];
    			maxElementIndex = i;
    		}
    	}
    	if(maxElementIndex == -1) {
        	//findLeastest(element, arr, midElement, false, false);
    		for(int i = 0; i < arr.length ; i++) {
        		if(arr[i] < minElement) {
        			minElement = arr[i];
        			minElementIndex = i;
        		}
        	}
    		swap(midElement, minElementIndex, arr);
    		findHighest(arr[midElement-1], arr, midElement-1);
    	}else {
    			swap(midElement, maxElementIndex , arr);
        		if(midElement > 0) {
        			findHighest(arr[midElement], arr, midElement);
        		}
    	}
    }
    
    private static boolean checkIfsorted(int[] arr) {
		boolean sorted = true;
		for(int i=0; i< arr.length; i++) {
			if(arr[i] != i+1) {
				sorted = false;
			}
		}
		return sorted;
	}

	static void findLeastest(int element, int[] arr,int midElement,boolean leftArraysorted, boolean rightArraySorted ) {
		if(checkIfsorted(arr)) {
			System.out.println("check if sorted");
			return;
		}
    	for(int k=0; k<arr.length ;k++) {
    		System.out.print(arr[k]+ " ");
    	}
    	System.out.println();
		System.out.println("leastest element - "+element+ " midElement - "+midElement +" "+ leftArraysorted);
    	int minElementIndex = -1, minElement = element;
		for(int i = midElement; i < arr.length ; i++) {
    		if(arr[i] < minElement) {
    			minElement = arr[i];
    			minElementIndex = i;
    		}
    	}
		if(minElementIndex == -1) {
			if(!leftArraysorted) {
				if(midElement != arr.length -1) {
				midElement = midElement -1;
				element = arr[midElement];
				System.out.println("highest 1");
				findHighest(arr[midElement], arr, midElement);
				}
			}
				midElement = midElement +1;
				element = arr[midElement];	
	    		findLeastest(element, arr, midElement, leftArraysorted, false);
		}
		if(minElementIndex != -1)
		{
			swap(midElement , minElementIndex, arr);
		}
		
		System.out.println("thi1");
		if(!leftArraysorted) {
			System.out.println("thi2");
			findHighest(arr[midElement], arr, midElement);
		}else {
			System.out.println("thi3");
			midElement = midElement +1;
			element = arr[midElement];
			findLeastest(element, arr, midElement, leftArraysorted, false);
		}
    }

    private static void swap(int i, int j, int[] normalQueue) {
    	count++;
    	int temp = 0;
		temp = normalQueue[j];
		normalQueue[j] = normalQueue[i];
		normalQueue[i] = temp;	
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        scanner.close();
    }
}
