import java.util.*;
import java.lang.*;
import java.io.*;

//Given an array A[] of N numbers and another number x, determine whether or not there exist three elements in A[] whose sum is exactly x.

public class TripletSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int N = sc.nextInt();
			int sum = sc.nextInt();
			int arr[] = new int[N];
			for(int j=0;j<N;j++) {
				arr[j] = sc.nextInt();
			}
			System.out.println(getTriplets(arr,N,sum));
		}
		

	}

	private static int getTriplets(int[] arr, int n, int sum) {
		
		int curSum = 0;
		
		
		for(int i=0;i<n-1;i++) {
			
			HashSet<Integer> set = new HashSet<>();
			curSum = sum-arr[i];
			
			for(int j=i+1;j<n;j++) {
				
				if(set.contains(curSum-arr[j])) {
					return 1;
				}
				else {
					set.add(arr[j]);
				}
			}
			
		}
		return 0;
		
	}

}
