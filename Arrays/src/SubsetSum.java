import java.util.Scanner;

public class SubsetSum {

	public static void main (String[] args)
	 {
   	 Scanner sc = new Scanner(System.in);
   	 int T = sc.nextInt();
   	 for(int i=0;i<T;i++){
   	     int size = sc.nextInt();
   	     int arr[] = new int[size];
   	     int sum = 0;
   	     for(int j=0;j<size;j++){
   	         arr[j] = sc.nextInt();
   	         sum += arr[j];
   	     }
   	     boolean ans = getAnswer(arr,size,sum);
   	     
   	     if(ans) {
   	    	 System.out.println("Yes");
   	     }
   	     else {
   	    	 System.out.println("No");
   	     }
   	 }
	 }

	public static boolean getAnswer(int[] arr, int size, int sum) {
		
		if(size==0 || size ==1) {
			return false;
		}
		if(sum%2==1) {
			return false;
		}
		
		sum = sum/2;
		
		boolean[][] dp = new boolean[size+1][sum+1];
		
		for(int i=0;i<=size;i++) {
			dp[i][0] = true;
		}
		for(int i=0;i<=sum;i++) {
			dp[0][i] = false;
		}
		
		for(int i=1;i<=size;i++) {
			for(int j=1;j<=sum;j++) {
				
				if(j<arr[i-1]) {
					dp[i][j] = dp[i-1][j]; 
				}
				else {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
			}
		}
		return dp[size][sum];
		
	}
	
	
}
