package subsequence;

import java.util.*;

public class LongestCommon {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			String first = sc.nextLine();
			String second = sc.nextLine();
			getAnswer(first,second,N,M);
		}
	}

	private static void getAnswer(String first, String second, int n, int m) {
		
		char X[] = first.toCharArray();
		char Y[] = second.toCharArray();
		
		int table[][] = new int[n+1][m+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				
				if(i==0||j==0) {      // when either of strings is null
					table[i][j] = 0;
				}
				else if(X[i-1]==Y[j-1]) {          //when characters match at given index
					table[i][j] = table[i-1][j-1]+1;
				}else {
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);   //longest matched so far
				}
				
			}
		}
		
		System.out.println(table[n][m]);
		
	}
}
