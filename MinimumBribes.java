package com.practice.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NewYearChaos {


    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    	int count=0;
    	int[] normalQueue = new int[q.length];
    	Map<Integer, Integer> bribers = new HashMap<Integer, Integer>();
    	Map<Integer, Integer> positions = new HashMap<Integer, Integer>();
    	for(int i=0; i < q.length;i++ ) {
    		normalQueue[i] = i+1;
    		bribers.put(i+1, 0);
    		positions.put(i+1, i);
    	}
    	for(int i=0; i<q.length;i++) {
    		int internalCounter = 0,interVar = q[i], normalVar = normalQueue[i];
    		while(interVar != normalVar && internalCounter < 3){
    			bribers.put(q[i], bribers.get(q[i])+1);
    			if(bribers.get(q[i]) == 3) {
    				System.out.println("Too chaotic");
    				return;
    			}
    			bribe(positions.get(q[i]), positions.get(q[i])-1, normalQueue, positions);
    			normalVar = normalQueue[i];
    			count++;
    			internalCounter++;
    		}
    	}
    	System.out.println(count);
    }

    private static void bribe(int i, int j, int[] normalQueue,Map<Integer, Integer> positions) {
    	int temp = 0;
		temp = normalQueue[j];
		positions.put(normalQueue[i], i -1);
		positions.put(normalQueue[j], j +1);
		normalQueue[j] = normalQueue[i];
		normalQueue[i] = temp;	
	}

	private static final Scanner scanner = new Scanner(System.in);	

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println(qItems[0]);
            for (int i = 0; i < n; i++) {
            	System.out.println(" entered"+ qItems[i]);
            	System.out.println();
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
