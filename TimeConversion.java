package com.practice.algorithms;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.*;

public class TimeConversion {
	  /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) throws ParseException {
    	String otp = null;
    	if(s != null ) {
    	String regex = "\\d+";
    	String[] splitStr = s.split(":");
    	if(splitStr.length == 3){
    		for (int i = 0; i < 3; i++) {
    			if(i == 0) {
    				if(Pattern.matches(regex, splitStr[i]) && Integer.parseInt(splitStr[i]) >= 0 && Integer.parseInt(splitStr[i]) <= 12){
    					continue;
    				}else {
    					return otp;
    				}
    			}else if(i == 1) {
    				if(Pattern.matches(regex, splitStr[i]) && Integer.parseInt(splitStr[i]) >= 0){
    					continue;
    				}else {
    					return otp;
    				}
    			}else {
    				if(Pattern.matches(regex+"AM", splitStr[i]) || Pattern.matches(regex+"PM", splitStr[i]) && Integer.parseInt(splitStr[i].substring(0, 2)) <= 59 
    						&& (splitStr[i].substring(2, 4).equals("AM") || splitStr[i].substring(2, 4).equals("PM"))){
    					continue;
    				}else {
    					return otp;
    				}
    			}
    			
    		}
    	}
    	SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    	SimpleDateFormat df1 = new SimpleDateFormat("hh:mm:ssa");
    	Date d = df1.parse(s);
    	otp = df.format(d);
    	}
		return otp;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException {

        String s = scan.nextLine();

        String result = timeConversion(s);

    }
}
