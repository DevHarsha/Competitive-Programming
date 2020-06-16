import java.util.Scanner;

//Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array.
//Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

public class EquillibriumPoint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int j=0;j<N;j++) {
				arr[j] = sc.nextInt();
			}
			System.out.println(getAnswer(arr,N));
			
		}
		
	}

	private static int getAnswer(int[] arr, int n) {
		
		int i=0,j=n-1;
		int left_sum = 0, right_sum = 0;
		
		while(i<j) {
			
			if(left_sum<right_sum) {
				left_sum += arr[i++];
			}
			else {
				right_sum += arr[j--];
			}
			
		}
		if(left_sum==right_sum) {
			return i+1;
		}
		
		return -1;
		
	}

}

/*
 * int start = 0;
		int end = n-1;
		
		int left_sum = 0;
		int right_sum = 0;
		
		while(start<end) {
			
			if(left_sum<right_sum) {
				left_sum += arr[start++];
			}else {
				right_sum += arr[end--];
			}
			
		}
		if(left_sum==right_sum) {
			return start+1;
		}
		
		return -1;
 * 
 * 
 */