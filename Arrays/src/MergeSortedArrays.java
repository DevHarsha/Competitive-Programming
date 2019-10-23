import java.util.Scanner;

//Given two sorted arrays, we need to merge them in O((n+m)*log(n+m)) time with O(1) extra space into a sorted array,
//when n is the size of the first array, and m is the size of the second array.


public class MergeSortedArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[m];
			for(int j=0;j<n;j++) {
				a[j] = sc.nextInt();
			}
			for(int j=0;j<m;j++) {
				b[j] = sc.nextInt();
			}
			
			getSortedArrays(a,b,n,m);
		}
		
	}

	private static void getSortedArrays(int[] a, int[] b, int n, int m) {
		
		
		
	}

}
