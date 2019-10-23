import java.util.Arrays;
import java.util.Scanner;

public class NumberofPairs {

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
			
			System.out.println(getPairs(a,b,n,m));

		}
	}

	private static int getPairs(int[] X, int[] Y, int m, int n) {
		
		int NoOfY[] = new int[5]; 
        for (int i = 0; i < n; i++) 
            if (Y[i] < 5) 
                NoOfY[Y[i]]++; 
       
        // Sort Y[] so that we can do binary search in it 
        Arrays.sort(Y); 
       
        int total_pairs = 0; // Initialize result 
       
        // Take every element of X and count pairs with it 
        for (int i=0; i<m; i++) 
            total_pairs += count(X[i], Y, n, NoOfY); 
       
        return total_pairs; 
		
	}

	private static int count(int x, int[] Y, int n, int[] NoOfY) {
		// If x is 0, then there cannot be any value in Y such that 
        // x^Y[i] > Y[i]^x 
        if (x == 0) return 0; 
       
        // If x is 1, then the number of pais is equal to number of 
        // zeroes in Y[] 
        if (x == 1) return NoOfY[0]; 
       
        // Find number of elements in Y[] with values greater than x 
        // getting upperbound of x with binary search 
        int idx = Arrays.binarySearch(Y, x); 
        int ans; 
        if(idx < 0){ 
            idx = Math.abs(idx+1); 
            ans = Y.length - idx; 
        } 
        else{ 
            while (idx<n && Y[idx]==x) { 
                idx++; 
            } 
            ans = Y.length - idx; 
        } 
       
        // If we have reached here, then x must be greater than 1, 
        // increase number of pairs for y=0 and y=1 
        ans += (NoOfY[0] + NoOfY[1]); 
       
        // Decrease number of pairs for x=2 and (y=4 or y=3) 
        if (x == 2)  ans -= (NoOfY[3] + NoOfY[4]); 
       
        // Increase number of pairs for x=3 and y=2 
        if (x == 3)  ans += NoOfY[2]; 
       
        return ans;
		
	}

	
	
	/*
	 * private static void getPairs(int[] a, int[] b, int n, int m) {
	 * 
	 * int count=0; //System.out.println(n+" "+m); for(int i=0;i<n;i++) {
	 * 
	 * for(int j=0;j<m;j++) {
	 * 
	 * int x = a[i]; int y = b[j]; //System.out.println(x+" "+y); if(Math.pow(x,
	 * y)>Math.pow(y, x)) {
	 * 
	 * count++; }
	 * 
	 * }
	 * 
	 * } System.out.println(count); }
	 */

}
