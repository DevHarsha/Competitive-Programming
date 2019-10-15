package graphAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            BFS traverse = new BFS();
            DFS traverse1 = new DFS();
            
            traverse1.dfs(0, list, vis);// for DFS
            
            traverse.bfs(0,list,vis); // for BFS
            System.out.println();
        }

	}

}
