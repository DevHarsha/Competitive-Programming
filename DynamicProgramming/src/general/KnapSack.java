package general;

import java.util.Scanner;

public class KnapSack {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int timeForQuests = sc.nextInt();
			int h[] = new int[N];
			int points[] = new int[N];
			for(int i=0;i<N;i++) {
				h[i] = sc.nextInt();
			}
			for(int i=0;i<N;i++) {
				points[i] = sc.nextInt();
			}
			
			System.out.println(getMaxPoints(timeForQuests,h,points,N));
			
		}

	}
	public static int getMaxPoints(int W,int[] wt, int[] val, int n) {
		
	
		int i,w;
		int K[][] = new int[n+1][W+1];
		
		
		for(i=0;i<=n;i++) {
			
			for(w=0;w<=W;w++) {
				
				if(i==0 || w==0) {
					K[i][w] = 0;
				}
				else if(wt[i-1]<=w){ // should be small 'w'
					K[i][w] = max(val[i-1]+K[i-1][w-wt[i-1]], K[i-1][w]);
				}
				else {
					K[i][w] = K[i-1][w];
				}
			}
			
		}
		return K[n][W];
	}

	/*public static int getMaxPoints(int W, int wt[], int val[], int n) 
	{ 
		int i, w; 
		int K[][] = new int[n + 1][W + 1]; 

		
		for (i = 0; i <= n; i++) { 
			for (w = 0; w <= W; w++) { 
				if (i == 0 || w == 0) 
					K[i][w] = 0; 
				else if (wt[i - 1] <= w) 
					K[i][w] = max( 
						val[i - 1] + K[i - 1][w - wt[i - 1]], 
						K[i - 1][w]); 
				else
					K[i][w] = K[i - 1][w]; 
			} 
		} 

		return K[n][W]; 
	} */

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		return i>j?i:j;
	}

}
