package graphAlgorithms;

import java.util.ArrayList;
import java.util.Iterator;

public class DFS {

	public void dfs(int i, ArrayList<ArrayList<Integer>> list, boolean[] vis) {
		
		vis[i] = true;
		System.out.print(i+" ");
		ArrayList<Integer> nList = list.get(i);
		Iterator<Integer> it = nList.iterator();
		
		while(it.hasNext()) {
			int next = it.next();
			if(!vis[next]) {
				dfs(next,list,vis);
			}
		}
		
		
	}

}
