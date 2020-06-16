package general;

import java.util.Scanner;

/*Given encoded message "123",  it could be decoded as "ABC" (1 2 3) or "LC" (12 3) or "AW"(1 23).
So total ways are 3.*/
public class DecondingMessages {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			System.out.println(getDecodingTotal(str,n));;
			
		}

	}

	public static int getDecodingTotal(String str, int n) {
		
		char digits[] = str.toCharArray();
		
		if(digits[0]=='0') {
			return 0;
		}
		int dp[] = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			
			if(digits[i-1]>'0') {
				dp[i] = dp[i-1];
			}
			if(digits[i-2]=='1' || digits[i-2]=='2' && digits[i-1]<'7') {
				dp[i] = dp[i] + dp[i-2];
			}			
			
		}
		return dp[n];
	}
	

}
