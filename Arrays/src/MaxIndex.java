import java.util.Scanner;

//Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].
public class MaxIndex {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int j=0;j<n;j++) {
				arr[j] = sc.nextInt();
			}
			getMaxIndexDiff(arr,n);
			
			getMaxIndexPractice(arr,n);  // StockBuy sell approach wont work because here we need max (j-i) regardless of increasing or decreasing seq.
										//  Need to satisy only conds  (j-i) should be greater and A[i]<=A[j]
		}				
		
	}
//-------------------------------------------------------------------/*Approach*/-----------------------------------------------------------------\\

	/*MAINTAIN two arrays LeftMin that has min elements from left so far and RightMax that has Max element so far from Right
	  check i,j in leftMin and rightMax respectively such that (j-i) is greater and leftMin[i] < = rightMax[j] 
	 */
	
	public static void getMaxIndexPractice(int[] arr, int n) {
		
		int left[] = new int[n];
		int right[] = new int[n];
		
		for(int i=0;i<n;i++) {
			
			if(i==0) {
				left[i] = arr[i];
			}
			else {
				left[i] = Math.min(arr[i], left[i-1]);
			}
		}
		for(int j=n-1;j>=0;j--) {
			
			if(j==n-1) {
				right[j] = arr[j];
			}
			else {
				right[j] = Math.max(arr[j], right[j+1]);
			}
			
		}
		
		int i=0,j=0;
		int max_val = Integer.MIN_VALUE;
		boolean flag = false;
		while(i<n && j<n) {
			
			if(left[i]<=right[j]) {
				if(max_val< j-i) {
					max_val = j-i;
					flag = true;
				}
				j++;				
			}
			else {
				i++;
			}
			
		}
		if(flag) {
			System.out.println(max_val);
		}else {
			System.out.println(0);
		}
		
	}

	public static void getMaxIndexDiff(int[] arr, int n) {
		
		int leftMin[] = new int[n];
		int rightMax[] = new int[n];
		
		for(int i=0;i<n;i++) {
			
			if(i==0) {
				leftMin[i] = arr[i];
			}
			else {
				leftMin[i] = Math.min(leftMin[i-1], arr[i]);
			}
			
		}
		
		for(int i=n-1;i>=0;i--) {
			
			if(i==n-1) {
				rightMax[i] = arr[i];
			}
			else {
				rightMax[i] = Math.max(rightMax[i+1], arr[i]);
			}
			
		}
		
		int i=0,j=0;
		int max_diff = Integer.MIN_VALUE;
		
		while(i<n && j<n) {
			
			if(leftMin[i]<=rightMax[j]) {
				max_diff = Math.max(max_diff, j-i);
				j++;
			}
			else {
				i++;
			}
			
		}
		System.out.println(max_diff);
	}

}
