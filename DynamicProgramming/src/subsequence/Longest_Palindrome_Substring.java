package subsequence;
import java.util.Scanner;

/* https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0 */

public class Longest_Palindrome_Substring {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	   	 int T = sc.nextInt();
	   	 sc.nextLine();
	   	 for(int i=0;i<T;i++){
	   	     String st = sc.nextLine();
	   	     getLongestPal(st);
	   	 }

	}

	public static void getLongestPal(String st) {
		
		int n = st.length();
		int max_length = 0;
		
		boolean matrix[][] = new boolean[n][n];
		int start = 0;
		
		for(int i=0;i<n;i++) {
			matrix[i][i] = true;
			max_length = 1;
		}
		
		boolean flag = true;
		
		for(int i=0;i<n-1;i++) {
			
			if(st.charAt(i)==st.charAt(i+1)) {
				matrix[i][i+1] = true;
				
				if(flag) {
					start = i;
					flag = false;
				}
				
				max_length = 2;
			}
			
		}
		
		
		for(int k=3;k<n;k++) {
			
			for(int i=0;i<n-k+1;i++) {
				
				int j = i+k-1;
				
				if(matrix[i+1][j-1] && st.charAt(i)==st.charAt(j)) {
					matrix[i][j] = true;					
					
					if(k> max_length) {
						start = i;
						max_length = k;
					}
					
				}
				
			}
			
		}
		
		System.out.println(st.substring(start,start+max_length));
		
	}

}
