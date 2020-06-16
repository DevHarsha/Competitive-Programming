import java.util.ArrayList;
import java.util.Scanner;
/*A group of connected 1's forms an island. The task is to complete the method findIslands() which returns the number of islands present.
 * The function takes three arguments the first is the boolean matrix A and then the next two arguments are N and M denoting the size(N*M) of the matrix A .*/

public class NumberOfIslands {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);
            
            // creating arraylist of arraylist
            for(int i = 0; i < N; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }
            
            // adding elements to the arraylist of arraylist
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < M; j++)
                {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }
            
            
            System.out.println("No of islands :"+findIslands(list, N, M)+", max island size :"+island_size);

        }

	}
	static int R = 0,C = 0, islands = 0;
	static int island_size = Integer.MIN_VALUE;
	
	public static int findIslands(ArrayList<ArrayList<Integer>> list, int n, int m) {
		
		R = n;
		C = m;
		int result = 0;
		
		
		  ArrayList<ArrayList<Boolean>> visited = new ArrayList<ArrayList<Boolean>>();
		  
		  for(int i=0;i<R;i++) { ArrayList<Boolean> temp = new ArrayList<>();
		  
		  for(int j=0;j<C;j++) { temp.add(false); } visited.add(temp); }	 
		
		
		
		for(int i=0;i<R;i++) {
			
			for(int j=0;j<C;j++) {
				
				if(visited.get(i).get(j)==false && list.get(i).get(j)==1) {
					result++;
					islands = 1;
					dfsSearch(list,i,j,visited);
					island_size = Math.max(island_size, islands);
				}
				
			}
			
		}		
		
		return result;
	}
	
	public static void dfsSearch(ArrayList<ArrayList<Integer>> list, int i, int j,
			ArrayList<ArrayList<Boolean>> visited) {		
		
		
		visited.get(i).set(j, true);
		
		int rows[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
		int cols[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
		
		for(int r=0;r<8;r++) {
			
			if(isValidCoordinate(list, i+rows[r], j+cols[r], visited)) {
				islands++;
				dfsSearch(list,i+rows[r],j+cols[r],visited);
				
			}
			
		}
		
		
	}
	public static boolean isValidCoordinate(ArrayList<ArrayList<Integer>> list,int row,int col,ArrayList<ArrayList<Boolean>> visited) {
		
		
		  if((row>=0 && col>=0) && (row < R && col < C)) {
		  
			  if(visited.get(row).get(col)==false && list.get(row).get(col)==1 ) {
				
				  return  true; 
				  
			  }
			  
		  }
		return false;
		 
		
		//return (row>=0) && (row<R) && (col>=0) && (col<C) && (list.get(row).get(col)==1) && (visited.get(row).get(col)==false);
	}
}
