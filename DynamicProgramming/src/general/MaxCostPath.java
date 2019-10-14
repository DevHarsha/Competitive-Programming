/*
Given a N X N  matrix Matrix[N][N] of positive integers.  There are only three possible moves from a cell Matrix[r][c].

1. Matrix[r+1][c]

2. Matrix[r+1][c-1]

3. Matrix[r+1][c+1]

Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.

*/

package general;

import java.util.Scanner;

public class MaxCostPath {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
   	    int T = sc.nextInt();
   	 
   	    for(int i=0;i<T;i++){
   	    	int N = sc.nextInt();
   	    	int matrix[][] = new int[N][N];
   	     
   	    	for(int m=0;m<N;m++){
   	    		for(int n=0;n<N;n++){
   	    			matrix[m][n] = sc.nextInt();
   	    	}
   	    		
   	    }   	    
   	    getAnswer(matrix,N);   	    
   	    }		
	}

	private static void getAnswer(int[][] matrix, int n) {
		int table[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			table[0][i] = matrix[0][i];
		}
		
		for(int i=1;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				if(j==0) {
					table[i][j] = Math.max(table[i-1][j], table[i-1][j+1])+matrix[i][j];
				}
				else if(j==n-1) {
					table[i][j] = Math.max(table[i-1][j-1], table[i-1][j]) +matrix[i][j];
				}
				else {
					table[i][j] = Math.max(table[i-1][j], Math.max(table[i-1][j-1], table[i-1][j+1]))+matrix[i][j];
				}
			}
			
		}
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			if(max<table[n-1][i]) {
				max = table[n-1][i];
			}
		}
		System.out.println(max);
		
	}

}
