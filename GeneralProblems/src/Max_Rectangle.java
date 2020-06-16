import java.util.Scanner;
//msx rectanle area with all 1s
/*https://practice.geeksforgeeks.org/problems/max-rectangle/1*/
public class Max_Rectangle {

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
			
			System.out.println(getMaxAreaRectangle(mat,n,m));
		}

	}
	//Idea at first, same as maximum sum rectangle where we add sums of all rows and then apply kandane's algo to find max rectangle
	
	public static int getMaxAreaRectangle(int[][] mat, int n, int m) {
		
		
		
		int max_sum = -1;
		int min_sum = Integer.MIN_VALUE;
		
		for(int i=0;i<n-1;i++) {
			
			for(int j=i+1;j<n;j++) {
				int sum = 0;
				
				for(int col=0;col<m;col++) {
					
					sum = mat[j][col]-mat[i][col];
					
					while(sum ==  (j-i-1) &&  true )
					
					if(sum < 0) {
						if(min_sum<sum)
							min_sum = sum;
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
