package com.practice.algorithms;

public class GCD {

	public static void main(String[] args) {
		
		int[] inpt = {3,6,9,12,15};
		generalizedGCD(5, inpt);
	}
	
    public static int generalizedGCD(int num, int[] arr)
    {
        int output = 1,maxelement = Integer.MIN_VALUE, minElement = Integer.MAX_VALUE, divdeBy = 2;
        boolean isEven = true, divided = false;
        for(int i=0; i<num; i++) {
        	if(arr[i] % 2 != 0) {
        		isEven = false;
        		divdeBy = 3;
        	}
        	if(arr[i] > maxelement) {
        		maxelement = arr[i];
        	}
        	if(arr[i] < minElement) {
        		minElement = arr[i];
        	}
        }
        while(divdeBy < maxelement && divdeBy >= minElement) {
        	
        	for(int i=0; i< num ; i++) {
        		if(arr[i] % divdeBy != 0) {
        			divided = false;
        			break;
        		}else {
        			divided = true;
        		}
        	}
        	if(divided) {
        		output = divdeBy;
        	}
        	if(isEven) {
        		divdeBy = divdeBy +2;
        	}else {
        		divdeBy = divdeBy +1;
        	}
        }
        System.out.println(output);
        return output;
    }

}
