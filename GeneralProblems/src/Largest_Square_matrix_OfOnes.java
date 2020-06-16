import java.util.Scanner;

/*Given a binary matrix, find out the maximum size square sub-matrix with all 1s.*/
public class Largest_Square_matrix_OfOnes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T  = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int mat[][] = new int[n][m];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			
			System.out.println(getLargestSquare(mat,n,m));
		}
		
	}

	public static int getLargestSquare(int[][] mat, int n, int m) {
		
		int result = 0;
		
		int M[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			M[i][0] = mat[i][0];
		}
		
		for(int j=0;j<m;j++) {
			M[0][j] = mat[0][j];
		}
		
		for(int i=1;i<n;i++) {
			
			for(int j=1;j<m;j++) {
				
				if(mat[i][j]==1) {
					M[i][j] = Math.min(M[i-1][j], Math.min(M[i][j-1], M[i-1][j-1]))+1;
				}
				else {
					M[i][j] = 0;
				}
				
			}
			
		}
		int max_sum = 0;
		
		for(int i=0;i<n;i++) {					
			for(int j=0;j<m;j++) {				
				if(M[i][j]>max_sum) {
					max_sum = M[i][j];
				}				
			}
		}
		
		
		return max_sum;
	}

}
