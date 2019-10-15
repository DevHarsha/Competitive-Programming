//DETECT CYCLE IN DIRECTED GRAPH USING DFS

package graphAlgorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DetectCycleDirected {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }

	}

}
class DetectCycle{

	public boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
		boolean visited[] = new boolean[V];
		boolean recurStack[] = new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(isCyclicUtil(i,list,visited,recurStack)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean isCyclicUtil(int i, ArrayList<ArrayList<Integer>> list, boolean[] visited, boolean[] recurStack) {
		

		if(recurStack[i]) {
			return true;
		}
		if(visited[i]) {
			return false;
		}
		visited[i] = true;
		recurStack[i] = true;
		
		ArrayList<Integer> nList = list.get(i);
		
		for(int j=0;j<nList.size();j++) {
			if(isCyclicUtil(nList.get(j),list,visited,recurStack)) {
				return true;
			}
		}
		recurStack[i] = false;
		return false;
	}
	
}
