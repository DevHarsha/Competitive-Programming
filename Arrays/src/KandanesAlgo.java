import java.util.Scanner;

//Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

public class KandanesAlgo {

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
		
		int sum = 0;
		int max_sum = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			
			sum = sum+arr[i];
			
			if(max_sum < sum) {
				max_sum = sum;
			}
			
			if(sum < 0) {
				sum = 0;
			}
		}
		return max_sum;
	}

}
