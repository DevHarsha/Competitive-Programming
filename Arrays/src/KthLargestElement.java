import java.util.Arrays;
import java.util.Scanner;

public class KthLargestElement {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int arr[] = new int[N];
			for(int j=0;j<N;j++) {
				arr[j] = sc.nextInt();
			}
			getKthLargest(arr,N,K);
		}

	}

	private static void getKthLargest(int[] arr, int n,int k) {
		
		Arrays.sort(arr);
		System.out.println(arr[n-k]);
	}

}
