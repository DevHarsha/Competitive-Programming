import java.util.Scanner;
/* A[j]-A[i] has to be maximum where i<j */
public class Max_Difference {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int j=0;j<n;j++) {
				a[j] = sc.nextInt();
			}
			getMaxDiff(a,n);
		}

	}
    /* traverse from left to right, keep track of Min so far.. if min_sofar - current_ele is greater update max_diff */
	public static void getMaxDiff(int[] a, int n) {
		
		int min_ele = a[0]; // Minimum element so far from left
		int max_diff = Integer.MIN_VALUE;
		
		for(int i=1;i<n;i++) {
			
			max_diff = Math.max(max_diff, a[i]-min_ele); //update max_diff with a[i]-min_ele
			min_ele = Math.min(min_ele, a[i]); // update minimum element so far
			
		}
		if(max_diff==0)
	        System.out.println(-1);
	     else
	        System.out.println(max_diff);
	}

}
