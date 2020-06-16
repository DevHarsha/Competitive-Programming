package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class CircleOfStrings {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			sc.nextLine();
			String inp[] = sc.nextLine().trim().split("\\s+");
			
			Graph gp = new Graph(26);
			for(int i=0;i<inp.length;i++) {
				
				char st = inp[i].charAt(0);
				char end = inp[i].charAt(inp[i].length()-1);
				gp.addEdge(st-'a',end-'a');		
											
			}				
			boolean result = gp.isEulerian();	
			if(result) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}	
}
class Graph{
	
	int V;
	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	int count[] = new int[26];
	
	Graph(int v){
	
		this.V = v;
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<Integer>());
		}
		
	}
	public void addEdge(int st, int end) {
		
		list.get(st).add(end);
		count[end]++;
		
	}
	public boolean isEulerian() {
		
		if(!isStronglyConnected()) {
			return false;
		}
		
		for(int i=0;i<V;i++) {
			if(list.get(i).size()!=count[i]) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean isStronglyConnected() {
		
		boolean visited[] = new boolean[V];
		
		for(int i=0;i<V;i++) {
			visited[i] = false;
		}
		
		int i=0;
		int start = 0;
		
		for(i=0;i<V;i++) {
			ArrayList<Integer> temp = list.get(i);
			if(temp.size()>0) {
				start = i;
				break;
			}
		}
		DFS(start,visited);
		
		for(int v=0;v<V;v++) {
			
			if(list.get(v).size()>0 && !visited[v]) {
				return false;
			}
			
		}
		
		Graph TGraph = getTranspose();
		for(int v=0;v<V;v++) {
			visited[v] = false;
		}
		
		TGraph.DFS(start, visited);
		
		for(int v=0;v<V;v++) {
			
			if(list.get(v).size()>0 && !visited[v]) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	public void DFS(int start, boolean[] visited) {
		
		visited[start] = true;
		ArrayList<Integer> temp = list.get(start);
		for(int i=0;i<temp.size();i++) {
			int j = temp.get(i);
			if(!visited[j]) {
				DFS(j,visited);
			}
		}
		
	}
	public Graph getTranspose() {
		
		Graph g = new Graph(V);
		
		for(int i=0;i<V;i++) {
			
			ArrayList<Integer> temp = list.get(i);
			
			for(int j=0;j<temp.size();j++) {
				g.addEdge(temp.get(j), i);
			}
			
		}		
		return g;		
	}
}
