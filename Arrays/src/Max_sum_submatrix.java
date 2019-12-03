import java.util.Scanner;

/*Given a matrix, your aim is to find the maximum sum among all axb sub matrices of the matrix.
 * The rows and columns of the submatrix must be contiguous. For example:*/
public class Max_sum_submatrix {

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
		    int times = sc.nextInt();
	       	 
		    for(int k=0;k<times;k++){
			    int a = sc.nextInt();
			    int b = sc.nextInt();
			    getMaxSum(matrix,n,m,a,b);    
		    }
		    System.out.println();
		}

	}
	
	//consider every submatrix of given dimensions and their sum, select the max_sum out of them. Basic approach
	public static void getMaxSum(int[][] matrix, int N, int M, int a, int b) {
		
		int max_sum = Integer.MIN_VALUE;
		
		
		for(int i=0;i<=N-a;i++) {
			
			for(int j=0;j<=M-b;j++) {
				
				int sum = 0;
				for(int n=0;n<a;n++) {
					
					for(int m=0;m<b;m++) {
						
						sum = sum+matrix[i+n][j+m];
						
					}
					
				}
				if(max_sum<sum) {
					max_sum = sum;
				}
			}
			
		}
		System.out.println(max_sum);
	}

}
