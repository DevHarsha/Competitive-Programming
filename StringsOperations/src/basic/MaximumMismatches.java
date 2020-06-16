package basic;

import java.util.Scanner;

public class MaximumMismatches {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			sc.nextLine();
			String string = sc.nextLine();
			
			System.out.println(getMaxMismatches(string,n));
		}

	}

	public static int getMaxMismatches(String string, int n) {
		
		System.out.println(string+" "+n);
		
		StringBuilder sb = new StringBuilder(string);
		String revString = sb.reverse().toString();
		
		int count = 0;
		
		for(int i=0;i<n;i++) {
			if(string.charAt(i)!=revString.charAt(i)) {
				
				count++;
				
			}
		}
		
		return count;
	}

}
