package graphAlgorithms;

import java.util.Arrays;

public class DijkstrasShortestPath {
	
	static final int V = 9; 
	
	public static void main(String[] args) {
		
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
            DijkstrasShortestPath t = new DijkstrasShortestPath(); 
            t.dijkstra(graph, 0); 

	}

	private void dijkstra(int[][] graph, int src) {
		
		int dist[] = new int[V];
		boolean sptSet[] = new boolean[V];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(sptSet, false);
		
		dist[src] = 0;
		
		for (int count=0;count<V-1;count++) {
			int u = minDist(dist,sptSet);
			sptSet[u] = true;
			
			for(int v=0;v<V;v++) {
				if(!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v] ) {
					dist[v] = dist[u]+graph[u][v];
				}
			}
			
		}
		printSolution(dist); 
	}

	private void printSolution(int[] dist) {
		System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + " \t\t " + dist[i]);
	}

	private int minDist(int[] dist, boolean[] sptSet) {
		
		int min_value = Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int i=0;i<V;i++) {
			if(!sptSet[i] && dist[i] < min_value) {
				min_value = dist[i];
				min_index = i;
			}
		}
		return min_index;
	}

}
