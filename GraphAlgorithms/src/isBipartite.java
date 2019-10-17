import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class isBipartite {

	public static void main(String[] args) {		
		
	        Scanner sc=new Scanner(System.in);
			int t = sc.nextInt();
			while(t-->0){
	        int V = sc.nextInt();
			int[][] G = new int[V][V];
			for(int i = 0; i < V; i++)
				for(int j = 0; j < V; j++)
					G[i][j] = sc.nextInt();
			isBipartite b = new isBipartite();
	        if (b.isBipartite(G, V))
	           System.out.println("1");
	        else
	           System.out.println("0");
			}	    

	}

	private boolean isBipartite(int[][] g, int v) {
		int colorSet[] = new int[v];
		Arrays.fill(colorSet, -1);
		
		for(int i=0;i<v;i++) {
			if(colorSet[i]==-1) {
				if(!isBipartiteUtil(g,i,colorSet,v)) {
					return false;
				}
			}
		}
		
		return true;
	}

	private boolean isBipartiteUtil(int[][] g,int src, int[] colorSet,int V) {
		
		colorSet[src] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			
			if(g[u][u]==1) {
				return false;
			}
			for(int v=0;v<V;v++) {
				
				if(g[u][v]==1 && colorSet[v]==-1) {
					colorSet[v] = 1-colorSet[u];
					queue.add(v);
				}
				else if(g[u][v]==1 && colorSet[v]==colorSet[u]) {
					return false;
				}				
				
			}
		}
		
		return true;		
		
	}

}
