package com.practice.algorithms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergePointsLists {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    	int otp = -1;
    	SinglyLinkedListNode list1Node = head1;
    	SinglyLinkedListNode list2Node = head2;
    	int count1 = 0, count2 = 0;
    	System.out.println("list1");
    	while(list1Node != null) {  
    	System.out.println(list1Node.data);
    		list1Node = list1Node.next;
    		count1++;
    	}
    	System.out.println("list2");
    	while(list2Node != null) {  
        	System.out.println(list2Node.data);
        		list2Node = list2Node.next;
        		count2++;
        }

    	list1Node = head1;
    	list2Node = head2;
    	
    	if(count1 > count2) {
    		System.out.println("first cpount");
    		otp = calculateInt(list1Node, list2Node);
    	}else {
    		System.out.println("second cpount"+" "+count2);
    		otp = calculateInt(list2Node, list1Node);
    	}
		return otp;
    }
    
    public static int calculateInt(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    	int otp = -1;
    	boolean isMergePoint = false;
    	SinglyLinkedListNode list1Node = head1;
    	SinglyLinkedListNode list2Node = head2;
    	SinglyLinkedListNode list3Node = null;
    	SinglyLinkedListNode temp = null;
    	int count =0, count1 = 0, count2 = 0,count3 = 0;
    	/*while(list2Node != null) {   
    		count = count+1;
    		temp = list2Node;
    		count1 = count;
    		count2 = 0;
    		while(list1Node != null && temp != null) {
    			System.out.println("This data is "+list1Node.data + " = "+temp.data + " count ="+count1+" count2 = "+count2 );
    			if(list1Node.data == temp.data) {
    				if(otp == -1) {
    					otp = list1Node.data;
    					list3Node = list1Node;
    					count3 = count2;
    					System.out.println("otp is "+otp+" count3 "+count2);
    				}
    				
    				if(temp.next != null) {
    					temp = temp.next;
    				}
    				count1 = count1 +1;
    			}else {
    				System.out.println("In else "+otp);
    				if(otp != -1) {
    					list1Node = list3Node;    
    					count2 = count3;
    				}
    				otp = -1;
    				temp = list2Node;
    				count1 = count;
    			}
    			count2 = count2+1;
    			list1Node = list1Node.next;
    		}
    		if(temp != null) {
    			System.out.println("in this count2");
    			list2Node = list2Node.next;
    			list1Node = head1;
    		}else {
    			break;
    		}
    	}
    	System.out.println("outer loop otp "+otp);*/
		while(list1Node != null) { 
    		count = count+1;
    		temp = list1Node;
    		count1 = count;
    		count2 = 0;
    		while(list2Node != null && temp != null) {    			
    			System.out.println("This data is "+temp.data + " = "+list2Node.data + " count ="+count1+" count2 = "+count2 );
    			if(list2Node.data == temp.data) {
    				if(count2 == 0) {
    					otp = -1;
    				}
    				if(otp == -1 && count1 != 1) {
    					otp = list2Node.data;
    					list3Node = list2Node;
    					count3 = count2;
    					System.out.println("otp is "+otp+" count3 "+count2 + list3Node);
    				}
    				System.out.println("int this group");
    				temp = temp.next;
    				count1 = count1 +1;
    			}else {
    				System.out.println("In else "+otp);
    				
    				if(otp != -1 && list3Node != null) {
    					list2Node = list3Node;    
    					count2 = count3;
    				}
    				otp = -1;
    				temp = list1Node;
    				count1 = count;
    				System.out.println("list2Node.next "+list2Node.next+ " - "+temp);
    			}
    			count2 = count2+1;
    			list2Node = list2Node.next;
    		}
    		if(temp == null && otp != -1 && list2Node == null) { 
    			System.out.println("int otp -1 ");
    			break;
    		}else if (list1Node.next == null) {
    			otp = list1Node.data;
    		}else {
    			System.out.println("in this count2 "+otp);
    			list1Node = list1Node.next;
    			list2Node = head2;
    			otp = -1;
    		}
    	}

		return otp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }
          
          	SinglyLinkedList llist2 = new SinglyLinkedList();
          	
            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }
          
          	SinglyLinkedListNode ptr1 = llist1.head;
            SinglyLinkedListNode ptr2 = llist2.head;

            for (int i = 0; i < llist1Count; i++) {
                if (i < index) {
                    ptr1 = ptr1.next;
                }
            }

            for (int i = 0; i < llist2Count; i++) {
                if (i != llist2Count-1) {
                    ptr2 = ptr2.next;
                }
            }

            ptr2.next = ptr1;

            int result = findMergeNode(llist1.head, llist2.head);
            System.out.println(" -- "+result);
        }

        scanner.close();
    }
}
