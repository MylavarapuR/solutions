package com.practice.algorithms;

import java.io.IOException;
import java.util.Scanner;

public class TwoDArrays {
	
	 // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int maxCount = 0, sum  =0, n =0; 
    	for(int i=0; i< 4 ; i++) {   
    		for(int j=0; j<4 ; j++) {  
        		for(int k=j; k<=j+2 ; k++) {
        			sum = sum + arr[i][k]; 
        			sum = sum + arr[i+2][k];        			
        			if(k == j+2) {
        				n = k-1;
        			}
        		}
        		sum = sum + arr[i+1][n]; 
        		if(sum > maxCount) {
        			maxCount = sum;        			
        		}
        		if( i == 0 && j == 0) {
        			maxCount = sum;
        		}
        	}    		
    	}
    	System.out.println(maxCount);
		return maxCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];
        boolean valid = true;
        
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
                if(arrItem < -9 && arrItem > 9) {
                	valid = false;
                }
            }
        }
        int result = 0;
        if(valid) {
        	result = hourglassSum(arr);
        }

        scanner.close();
    }
}
