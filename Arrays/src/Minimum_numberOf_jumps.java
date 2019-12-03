import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Minimum_numberOf_jumps {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int j=0;j<n;j++) {
				a[j] = sc.nextInt();
			}
			System.out.println(getJumps(a,n));
		}

	}

	public static int getJumps(int[] a, int n) {
		
		boolean visited[] = new boolean[n];
		visited[0] = true;
		
		Queue<QueueObj> queue = new LinkedList<>();
		queue.add(new QueueObj(0,0));
		int steps = -1;
		
		while(!queue.isEmpty()) {
			
			QueueObj temp = queue.poll();
			int distance = temp.distance;
			int index = temp.index;
			
			if( index ==n-1 ) {
				steps = distance;
				break;
				
			}
			int jumps = a[index];
			for(int i=1;i<=jumps;i++) {
				
				if(i+index<n && !visited[i+index]) {
					
					queue.add(new QueueObj(distance+1,index+i));
					visited[i+index] = true;
					
				}
				
			}
			
		}		
		return steps;
	}

	
}
class QueueObj{
	
	int distance;
	int index;
	
	QueueObj(int d,int i) {
		this.distance = d;
		this.index = i;
	}
	
}
