package com.practice.algorithms;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {
	// Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	if(n > Math.pow(10, 6) || n < 2) {
    		return 0;
    	}
    	int count =0,valleyCount = 0;
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i) == 'U') {
    			count ++;
    		}else {
    			count --;
    		}
    		if(count == 0 && s.charAt(i) == 'U') {
    			valleyCount++;
    		}
    	}
		return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
       
        
        int result = countingValleys(n, s);
        scanner.close();
    }
}
