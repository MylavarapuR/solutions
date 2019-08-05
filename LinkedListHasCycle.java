package com.practice.algorithms;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.practice.algorithms.InsertAtPositionLinkedList.SinglyLinkedList;
import com.practice.algorithms.InsertAtPositionLinkedList.SinglyLinkedListNode;

public class LinkedListHasCycle {
	 class Node {
	        int data;
	        Node next;
	    }
	static boolean hasCycle(SinglyLinkedListNode head) {
		SinglyLinkedListNode slow = head;
		SinglyLinkedListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) return false;
        
        slow = slow.next;
        fast = fast.next.next;
        System.out.println(fast.data);
    }
	return true;
    
	}
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

	    SinglyLinkedList llist = new SinglyLinkedList();

	    int llistCount = scanner.nextInt();
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    for (int i = 0; i < llistCount; i++) {
	        int llistItem = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        llist.insertNode(llistItem);
	    }
	    System.out.println(hasCycle(llist.head));
	}
}
