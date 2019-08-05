/*
Log File
You have been given a task of recording some data 40M a log file. In the log file, every line is a space-delimited list of strings. All lines begin with an alphanumeric identifier. There will be no lines consisting only of an identifier.
After the alphanumeric identifier a line will consist of either:from aonecode.com
- a list of words using only lowercase English lettersfrom aonecode.com
- or list of only integers.
You have to reorder the data such that all of the lines with words are at the top of the log file. The lines with words are ordered lexicographically. ignoring the identifier except in the case of ties In the case of ties (if there are two lines that are identical except for the identifier) the identifier is used to order lexicographically. Alphanumeric should be sorted in ASCII order (numbers come before letters) The identifiers most still be pan of the lines in the output Strings. Lines with integers must be left in the original order they were in the file.from aonecode.com
Write an algorithm to reorder the data in the log file, according to the rules above.from aonecode.com
Input
The input to the function/method consists of two argument - logFileSize, an integer representing the number of log lines. 
logLines, a list of strings representing the log file.

from aonecode.com from aonecode.com
Outputfrom aonecode.com
Return a list of strings representing the reordered log file data.from aonecode.com

Note
Identifier consists of only lower case english character and numbers.from aonecode.com

Example from aonecode.com

Input
logFileSize = 5from aonecode.com
logLines = 
[a1 9 2 3 1] 
[g1 act car] [zo4 4 7] 
[ab1 off key dog]from aonecode.com
[a8 act zoo]

Output
[g1 act car]from aonecode.com
[a8 act zoo]
[ab1 off key dog]from aonecode.com
[zo4 4 7]
[a1 9 2 3 1]
*/

import java.util.Arrays;
import java.util.Comparator;

public class AmazonWords1 {

	 public static void main(String[] args) {
	    	String[] inp = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
	    	
	    	reorderLogFiles(inp);
		}

	private static void reorderLogFiles(String[] inp) {
		Arrays.sort(inp, new myComparator());
		for(int i=0; i<inp.length;i++) {
        	System.out.println(inp[i]);
        }
	}
	
	static class myComparator implements Comparator<String> {	
		
		@Override
		public int compare(String str1, String str2) {
			String[] str1Arr = str1.split(" ");
			String[] str2Arr = str2.split(" ");

            boolean isDigit1 = Character.isDigit(str1Arr[1].charAt(0));
            boolean isDigit2 = Character.isDigit(str2Arr[1].charAt(0));
			if(!isDigit1&& !isDigit2){
				int comp =  str1Arr[1].compareTo(str2Arr[1]);
				if(comp !=0 ) return comp;
				int digit1 = 0,digit2 = 0;
				for(char ch : str1Arr[0].toCharArray()) {
					if(Character.isDigit(ch)) {
						digit1 = Integer.parseInt(ch+"");
						break;
					}
				}
				for(char ch : str1Arr[0].toCharArray()) {
					if(Character.isDigit(ch)) {
						digit2 = Integer.parseInt(ch+"");
						break;
					}
				}
				return digit1 > digit2 ? -1 : 1;
			}
			 return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
		}
	}

}
