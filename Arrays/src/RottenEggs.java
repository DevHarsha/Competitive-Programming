import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenEggs {
	
	
	static int n;
	static int m;
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			int arr[][] = new int[n][m];
			
			for(int i=0;i<n;i++) {
				
				for(int j=0;j<m;j++) {
					
					arr[i][j] = sc.nextInt();
					
				}
				
			}
			
			System.out.println(rottenEggs(arr,n,m));
		}
		
	}

	private static int rottenEggs(int[][] arr, int n, int m) {
		
		Queue<Coordinate> queue = new LinkedList<>();
		Coordinate temp;
		
		int count = 0;
		int result = 0;
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				
				if(arr[i][j]==2) {
					
					Coordinate point = new Coordinate(i,j);
					//System.out.println(i+"-"+j);
					queue.add(point);
					
				}
				
			}
			
		}
		
		//Adding a delimiter
		
		queue.add(new Coordinate(-1, -1));
		
		while(!queue.isEmpty()){
			
			boolean flag = false;
			result++;
			
			while(!isDelimiter(queue.peek())) {
				
				temp = queue.peek();
				//System.out.println(temp.x+"-"+temp.y);
				
				//System.out.println(isValid(temp.x,temp.y+1));
				
				if(isValid(temp.x+1,temp.y) && arr[temp.x+1][temp.y]==1 ) {
					
					if(!flag) {
						count++;
						flag  = true;
					}					
					arr[temp.x+1][temp.y]=2;
					queue.add(new Coordinate(temp.x+1,temp.y));
					
				}
				if(isValid(temp.x-1,temp.y) && arr[temp.x-1][temp.y]==1 ) {
					
					if(!flag) {
						count++;
						flag  = true;
					}
					arr[temp.x-1][temp.y]=2;
					queue.add(new Coordinate(temp.x-1,temp.y));
					
				}
				if(isValid(temp.x,temp.y+1) && arr[temp.x][temp.y+1]==1 ) {
					
					if(!flag) {
						count++;
						flag  = true;
					}
					arr[temp.x][temp.y+1]=2;
					queue.add(new Coordinate(temp.x,temp.y+1));
					
				}
				if(isValid(temp.x,temp.y-1) && arr[temp.x][temp.y-1]==1 ) {
					
					if(!flag) {
						count++;
						flag  = true;
					}
					arr[temp.x][temp.y-1]=2;
					queue.add(new Coordinate(temp.x,temp.y-1));
					
				}				
				
				queue.remove();
			}
			
			queue.remove();
			
			if(queue.size()!=0) {
				queue.add(new Coordinate(-1,-1));
			}
			
		}
		
		return checkAll(arr)==true?count:-1;
		
		
	}

	private static boolean checkAll(int[][] arr) {
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				
				if(arr[i][j]==1) {
					return false;
				}
				
			}
			
		}
		return true;
	}

	private static boolean isDelimiter(Coordinate temp) {
		if(temp.x==-1 && temp.y==-1) {
			return true;
		}
		return false;
	}

	public static boolean isValid(int x, int y) {
		
		//System.out.println("Valid "+x+"-"+y);
		//System.out.println(n+" - "+m);
		if((x>=0&& x<n) && (y>=0 && y<m)) {
			return true;
		}		
		return false;
	}

	
	
}

class Coordinate{
	
	int x;
	int y;
	
	Coordinate(int x,int y){
		this.x = x;
		this.y = y;
	}
	
}
