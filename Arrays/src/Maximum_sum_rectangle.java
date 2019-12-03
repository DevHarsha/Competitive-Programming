import java.util.Scanner;
/*Given a 2D array, find the maximum sum subarray in it. Of some given size N*M */
public class Maximum_sum_rectangle {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	   	 int T = sc.nextInt();
	   	 for(int t=0;t<T;t++){
	   	     int n = sc.nextInt();
	   	     int m = sc.nextInt();
	   	     int matrix[][] = new int[n][m];
	   	     for(int i=0;i<n;i++){
	   	         
	   	         for(int j=0;j<m;j++){
	   	             matrix[i][j] = sc.nextInt();
	   	         }
	   	         
	   	     }
	   	     System.out.println(getMaximumSum(matrix,n,m));
	   	 }

	}

	private static int getMaximumSum(int[][] matrix, int n, int m) {
		
		int rowSum[][] = new int[n+1][m];
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				
				rowSum[i+1][j] = rowSum[i][j] + matrix[i][j]; 
				
			}
			
		}
		int max_sum = -1;
		int min_sum = Integer.MIN_VALUE;
		for(int row=0;row<n;row++) {
			
			for(int srow = row;srow<n;srow++) {
				
				int sum = 0;
				
				for(int col=0;col<m;col++) {
					
					sum += rowSum[srow+1][col] - rowSum[row][col];
					if(sum<0) {
						if(min_sum<sum){
	                         min_sum = sum;
	                     }
						sum = 0;
					}
					else if(max_sum < sum) {
						max_sum = sum;
					}
				}
				
			}
			
		}
		
		return max_sum==-1?min_sum:max_sum;
	}

}
