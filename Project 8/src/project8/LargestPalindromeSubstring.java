package project8;

import java.util.Scanner;

public class LargestPalindromeSubstring {
	private static boolean isPalindrome(String str) {
		int s = 0, n = str.length()-1;
		
		while(s < n) {
			if(str.charAt(s++) != str.charAt(n--))
				return false;
		}
		return true;
	}
	
	private static String largestPalindromicSubstring(String str) {
		StringBuffer sb = new StringBuffer(str);
		if(sb.length() == 1)
			return sb.toString();
		
		String longest = "";
		for(int i = 0; i < str.length(); i++) {
			for(int j = str.length()-1; j >= i; j--) {
				String substring = sb.substring(i,j);
				if(isPalindrome(substring) && substring.length() > longest.length()) {
					longest = substring;
					break;
				}
			}
		}
		
		return longest;
	}
	private static final Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter a string: ");
		String str = in.nextLine();
		
		String ans = largestPalindromicSubstring(str);
		System.out.println("Largest Palindromic Substring: " + ans);
	}
}
