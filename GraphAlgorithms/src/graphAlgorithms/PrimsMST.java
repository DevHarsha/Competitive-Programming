//Given a weighted, undirected and connected graph. The task is to find the sum of weights of  the edges of the Minimum Spanning Tree.

package graphAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimsMST {
	public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0; i<V; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j = 0; j < V; j++)
                    temp.add(Integer.MAX_VALUE);
                graph.add(temp);
            }
            str = read.readLine().trim().split(" ");
            int k = 0;
            while(E-- > 0)
            {
                int u = Integer.parseInt(str[k++]);
                int v = Integer.parseInt(str[k++]);
                int w = Integer.parseInt(str[k++]);
                u--;
                v--;
                graph.get(u).set(v, w);
                graph.get(v).set(u, w);
            }
            System.out.println(new PrimsMST().spanningTree(V,E,graph));
        }
    }

	private int spanningTree(int V, int e, ArrayList<ArrayList<Integer>> graph) {
		
		boolean mstSet[] = new boolean[V];
		int parent[] = new int[V];
		int key[] = new int[V];
		
		Arrays.fill(key,Integer.MAX_VALUE);
		
		parent[0] = -1;
		key[0] = 0;
		
		for(int count=0;count<V-1;count++) {
			
			int u = minKey(mstSet,key,V);
			mstSet[u] = true;
			ArrayList<Integer> list = graph.get(u);
			
			for(int v=0;v<V;v++) {
				
				if(list.get(v)<key[v] && !mstSet[v] && list.get(v)!=0) {
					key[v] = list.get(v);
					parent[v] = u;
				}
				
			}
		}		
		return cost(parent,graph);
	}

	private int cost(int[] parent, ArrayList<ArrayList<Integer>> graph) {
		
		int cost = 0;
        for (int i = 1; i<parent.length; i++) {
            cost += graph.get(i).get(parent[i]);
        }
        return cost;
		
	}

	private int minKey(boolean[] mstSet, int[] key, int V) {
		
		int min_value = Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int v=0;v<V;v++) {
			if(!mstSet[v] && key[v] <min_value) {
				min_value = key[v];
				min_index = v;
			}
		}
		return min_index;
	}
}
