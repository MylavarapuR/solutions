package com.practice.algorithms;

import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {
	// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long repeats = n/s.length();
    	long leftletters = n%s.length();
    	long count = s.chars().filter(ch -> ch == 'a').count();
    	count = count * repeats;
    	count += s.substring(0, (int)leftletters).chars().filter(ch -> ch == 'a').count();    	
		return count;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        long result = 0;
        if(s.length() == 1 && s.equals("a")) {
        	result = n;
        }else if(n >=1 && n <= Math.pow(10, 12) && s.length()<=100 && s.length() >=1){
        	result = repeatedString(s, n);
        }
        
        System.out.println(result);
        scanner.close();
    }
}
