package general;
/*Given three strings A, B and C your task is to complete the function isInterleave which returns true if C is an interleaving of A and B else returns false.
 *  C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.
 */

import java.util.Scanner;

public class InterleavingString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<T;i++) {			
			String input[] = sc.nextLine().split("\\s+");
			boolean result = checkIfInterleavinf(input[0],input[1],input[2]);
			if(result) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}

	}

	public static boolean checkIfInterleavinf(String A, String B, String C) {
		
		int n1 = A.length();
		int n2 = B.length();
		int n = C.length();
		
		if(n!=(n1+n2)){
			return false;
		}
		
		boolean dp[][] = new boolean[n1+1][n2+1];
		
		for(int i=0;i<=n1;i++) {
			for(int j=0;j<=n2;j++) {
				
				if(i==0 && j==0) {
					dp[i][j] = true;
				}
				else if(i==0) {
					
					if(B.charAt(j-1)==C.charAt(j-1)) {
						dp[i][j] = dp[i][j-1];
					}
					
				}
				else if(j==0) {
					
					if(A.charAt(i-1)==C.charAt(i-1)) {
						dp[i][j] = dp[i-1][j];
					}
					
				}
				else if(A.charAt(i-1)==C.charAt(i+j-1) && B.charAt(j-1)!=C.charAt(i+j-1)) {
				
					dp[i][j] = dp[i-1][j];
					
				}
				else if(A.charAt(i-1)!=C.charAt(i+j-1) && B.charAt(j-1)==C.charAt(i+j-1)) {
					
					dp[i][j] = dp[i][j-1];
					
				}
				else if(A.charAt(i-1)==C.charAt(i+j-1) && B.charAt(j-1)==C.charAt(i+j-1)) {
					
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
					
				}
				
			}
		}
		
		
		return dp[n1][n2];
	}

}
