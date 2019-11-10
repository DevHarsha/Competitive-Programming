import java.util.Scanner;

/*Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S. */

public class SubArrayWithGivensum {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int size = sc.nextInt();
			int sum = sc.nextInt();
			int arr[] = new int[size];
			for(int j=0;j<size;j++) {
				arr[j] = sc.nextInt();
			}
			//getIndexesSimpler(arr,size,sum); // O(n^2)
			getIndexesEfficient(arr,size,sum);
		}
	}

	private static void getIndexesEfficient(int[] arr, int size, int sum) {
		
		int curSum = 0;//arr[0];
		int start = 0;
		boolean flag = false;
		
		for(int i=0;i<size;i++) {
			
			curSum = curSum+arr[i];
			
			while(curSum>sum && start < i) {
				curSum = curSum-arr[start];
				start++;
			}
			if(curSum==sum) {
				System.out.println((start+1)+" "+(i+1));
				flag =true;
				break;
			}
			
		}
		
		if(!flag) {
			System.out.println("No Sub Array found");
		}
		
	}

	private static void getIndexesSimpler(int[] arr, int size, int sum) {
		
		int tsum = 0;
		boolean flag = false;
		
		for(int i=0;i<size-1;i++) {
			tsum = arr[i];
			for(int j=i+1;j<size;j++) {
				
				if(tsum==sum) {
					flag = true;
					System.out.println(i+" "+(j-1));
				}
				if(tsum>sum || j==size)
					break;
				tsum += arr[j];
			}
		}
		if(!flag) {
			System.out.println("No subarray found");
		}
	}
	

	
}
