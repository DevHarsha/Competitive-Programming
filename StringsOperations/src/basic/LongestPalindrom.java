package basic;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPalindrom {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t=0;t<T;t++) {
			String input = sc.nextLine();
			System.out.println(getLongestPalindrome(input));
		}

	}

	public static String getLongestPalindrome(String str) {
		
		if(str=="") {
			return str;
		}
		
		int max_palindrome = 1;
		int start = 0,end = 1;
		
		int n = str.length();
		int[][] DP = new int[n][n];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(DP[i], 0);
		}
		
		for(int i=0;i<n;i++) {
			DP[i][i] = 1;
		}
		
		boolean istrue = false;
		for(int i=0;i<n-1;i++) {
			
			if(str.charAt(i)==str.charAt(i+1)) {
				DP[i][i+1] = 2;
				
				if(!istrue) {
					max_palindrome = 2;
					start = i;
					end = i+2;
					istrue = !istrue;
				}
					
			}
			
		}
		
		for(int k = 3;k <=n; k++) {
			
			for(int i=0;i<=n-k;i++) {
			
				int j = i+k-1;
				
				if(DP[i+1][j-1]!=0 && str.charAt(i)==str.charAt(j)) {
					
					DP[i][j] = DP[i+1][j-1]+1;
					
					if(k>max_palindrome) {
						max_palindrome = k;
						start = i;
						end = i+k;
					}
				}
				
			}
			
		}
		
		return str.substring(start, end);
		
	}

}
