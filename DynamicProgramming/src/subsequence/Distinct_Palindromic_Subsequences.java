package subsequence;
/*Given a string of lowercase ASCII characters, find all distinct continuous palindromic sub-strings of it.*/
import java.util.Scanner;
import java.util.TreeMap;

public class Distinct_Palindromic_Subsequences {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t=0;t<T;t++) {
			String str = sc.nextLine();
			getNumberofPalindromes(str);
		}

	}

	public static void getNumberofPalindromes(String str) {
		
		int n = str.length();
		boolean dp[][] = new boolean[n][n];		
		TreeMap<String,Integer> map = new TreeMap<>();
		
		for(int i=0;i<n;i++) {			
			dp[i][i] = true;
			map.put(str.charAt(i)+"",1);
		}
		
		for(int i=0;i<n-1;i++) {
			if(str.charAt(i)==str.charAt(i+1)) {
				dp[i][i+1] = true;
				map.put(str.substring(i,i+2),1);
			}
		}
		
		for(int k=3;k<=n;k++) {
			
			for(int i=0;i<n-k+1;i++) {
				int j = i+k-1;
				
				if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]) {
					dp[i][j] = true;
					map.put(str.substring(i,j+1), 1);
				}
			}
			
		}
		
		System.out.println(map.size());
	}

}
