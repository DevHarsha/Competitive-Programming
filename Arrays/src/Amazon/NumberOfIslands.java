package Amazon;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfIslands {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);
			
			for(int i=0;i<N;i++) {
				
				ArrayList<Integer> temp = new ArrayList<>(M);
				list.add(i,temp);
				
			}
			
			for(int i=0;i<N;i++) {
				
				for(int j=0;j<M;j++) {
					
					int val = sc.nextInt();
					list.get(i).add(j,val);
					
				}
				
			}
			
			System.out.println(new Islands().findIslands(list,N,M));
		}

	}

}

class Islands{

	static int N,M;
	
	public static int findIslands(ArrayList<ArrayList<Integer>> list, int n, int m) {
		
		int islands = 0;
		N = n;
		M = m;
		
		ArrayList<ArrayList<Boolean>> visited = new ArrayList<>(n);
		
		for(int i=0;i<n;i++) {
			
			ArrayList<Boolean> temp = new ArrayList<>(m);
			
			for(int j=0;j<m;j++) {
				
				temp.add(j,false);
				
			}
			visited.add(i,temp);
			
		}
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				
				if(!visited.get(i).get(j) && list.get(i).get(j)==1) {
					islands++;
					BFSUtil(list,i,j,visited);
					
				}
				
			}
			
		}
		
		
		return islands;
	}

	private static void BFSUtil(ArrayList<ArrayList<Integer>> list, int i, int j, ArrayList<ArrayList<Boolean>> visited) {
		
		visited.get(i).set(j, true);
		
		int row[] = {-1,-1,-1,0,1,1,1,0};
		int col[] = {-1,0,1,1,1,0,-1,-1};
		
		for(int k=0;k<8;k++) {
			
			if(isValidPoint(list,i+row[k],j+col[k],visited)) {
					
					BFSUtil(list,i+row[k],j+col[k],visited);
					
				}
				
			}
		
	}

	private static boolean isValidPoint(ArrayList<ArrayList<Integer>> list, int row, int col,
			ArrayList<ArrayList<Boolean>> visited) {
		
		
		if((row>=0 && row<N) && (col>=0 && col<M) && !visited.get(row).get(col) && list.get(row).get(col)==1) {
			return true;
		}
		
		return false;
	}
	
	
	
}
