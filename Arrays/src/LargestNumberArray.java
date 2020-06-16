import java.util.Scanner;

public class LargestNumberArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			getLargestNumber(a,n);
			System.out.println();
		}

	}

	public static void getLargestNumber(int[] a, int n) {
		
		String X = "",Y = "";
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				
				if( ((a[i]+"")+(a[j]+"")).compareTo( (a[j]+"")+(a[i]+"") )<=0 ) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
				
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(a[i]);
		}
		 
	}

}
