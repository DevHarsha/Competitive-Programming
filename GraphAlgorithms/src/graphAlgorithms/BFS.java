package graphAlgorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	

	public void bfs(int i, ArrayList<ArrayList<Integer>> list, boolean[] vis) {
		
		//boolean visited[] = new boolean[];
		
		Queue<Integer> queue = new LinkedList<>();
		vis[i] = true;
		
		queue.add(i);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			System.out.print(num+" ");
			ArrayList<Integer> nList = list.get(num);
			
			Iterator<Integer> it = nList.iterator();
			
			while(it.hasNext()) {
				int val = it.next();
				if(!vis[val]) {
					vis[val] = true;
					queue.add(val);
				}
			}
			
		}
		
	}

}
