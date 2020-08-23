package Amazon;

import java.util.Scanner;

//Given a binary array and an integer m, find the position of zeroes flipping which creates maximum number of consecutive 1’s in array.
/*
 * Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
   m = 2
   Output:  5 7
 * */

public class ZeroesTobeFlipped {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			
			int N = sc.nextInt();
			int a[] = new int[N];
			for(int i=0;i<N;i++) {
				
				a[i] = sc.nextInt();
				
			}
			int m = sc.nextInt();
			getCountOfZeroes(a,N,m);
			
		}

	}

	public static void getCountOfZeroes(int[] a, int n, int m) {
		
		int zeroCount = 0;
		int wL = 0;
		int wR = 0;
		int bandWidth = 0, position = 0;
		
		while(wR<n) {
			
			if(zeroCount<=m) {
				
				if(a[wR]==0) {
					zeroCount++;
				}				
				wR++;
				
			}
			
			if(zeroCount>m) {
				
				if(a[wL]==0) {
					zeroCount--;
				}
				wL++;
				
			}
			
			if((wR-wL > bandWidth) && (zeroCount<=m)) {
				
				bandWidth = wR-wL;
				position = wL;
			}
			
		}
		
		for(int i=0;i<bandWidth;i++) {
			if(a[i+position]==0) {
				//System.out.print((i+position)+" "); // Solution for Amazon question, print the positions os zeroes to be flipped
			}
		}
		System.out.println(bandWidth);
	}

}
