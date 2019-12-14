package com.example.generator;

/**
 * this class is used to generate random vehicle numbers
 * @author user
 *
 */
public class CustomGenerator {

	/**
	 * 
	 * @return registration number
	 */
	public static String generateNumber() {
		 StringBuilder s = new StringBuilder();
		    for (int i = 0; i < 3; i++) {
		        char ch = (char) (Math.random() * 26 + 'A');
		        s.append(ch);
		    }
		    for (int i = 0; i < 4; i++) {
		        char digit1 = (char) (Math.random() * 10 + '0');
		        s.append(digit1);
		    }
		   String regNumber=s.toString();
		return regNumber;
	}
}
