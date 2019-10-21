import java.util.Scanner;

public class MissingNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int N = sc.nextInt()-1;
			int arr[] = new int[N];
			for(int j=0;j<N;j++) {
				arr[j] = sc.nextInt();
			}
			//getMissingNumber(arr,N); //O(n) solution
			System.out.println(getMissingEff(arr,0,N)); //O(n/2) solution
		}

	}

	private static int getMissingEff(int[] arr,int st, int end) {
		
		int mid = (st+end)/2;
		
		if(st==end) {
			return arr[st]-1;
		}
		if(arr[mid] == mid+1) {
			return getMissingEff(arr,mid+1,end);
		}else if(arr[mid] ==mid+2) {
			return getMissingEff(arr,st,mid);
		}		
		return arr[mid]-1;	
		
	}

	private static void getMissingNumber(int[] arr, int n) {
		
		int sum = (n+1)*(n+2)/2;
		int aSum = 0;
		
		for(int i=0;i<n;i++) {
			aSum += arr[i];
		}
		System.out.println(sum-aSum);
	}

}
