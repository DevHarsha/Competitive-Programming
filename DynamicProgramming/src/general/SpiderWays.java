package general;

import java.util.Scanner;

public class SpiderWays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(getWays(x,y));
			System.out.println(getNewWays(x,y));
		}

	}

	public static int getNewWays(int x, int y) {
		
		x = Math.abs(x);
		y = Math.abs(y);
		
		int []n = new int[x+1];
		
		for(int i=0;i<x+1;i++) {
			n[i] = 1;
		}
		
		for(int i=0;i<y;i++) {
			
			for(int j=1;j<x+1;j++) {
				n[j] = n[j-1] + n[j];
			}
			
		}
		return n[y];
	}

	public static int getWays(int a, int b) {
		
		int x = Math.abs(a);
		int y = Math.abs(b);
		
		int DP[][] = new int[x+1][y+1];
		
		for(int i=0;i<=x;i++) {
			
			for(int j=0;j<=y;j++) {
				
				if(i==0 || j==0) {
					DP[i][j] = 1;
				}
				else {
					DP[i][j] = DP[i-1][j]+DP[i][j-1];
				}
				
			}
			
		}
		return DP[x][y];
		
	}

}
