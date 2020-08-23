package order.traversals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;

public class LevelOrderSpiral {

	public static void main(String[] args) throws IOException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-->0) {
			
			String s = br.readLine();
			Node root = buildTree(s);
			Spiral sp = new Spiral();
			sp.getLevelOrderTraversal(root);
			System.out.println();
		}
	}

	private static Node buildTree(String str) {
		
		if(str.length()==0 || str.charAt(0)=='N') {
			return null;
		}
		
		String ip[] = str.split(" ");
		
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		int i = 1;
		
		while(!queue.isEmpty() && i<ip.length) {
			
			Node currNode = queue.poll();
			String currVal = ip[i];
			
			if(!currVal.equals("N")) {
				currNode.left = new Node(Integer.parseInt(currVal));
				queue.add(currNode.left);
			}
			
			i++;
			
			if(i>=ip.length) {
				break;
			}
			
			currVal = ip[i];
			
			if(!currVal.equals("N")) {
				currNode.right = new Node(Integer.parseInt(currVal));
				queue.add(currNode.right);
			}
			i++;
			
		}
		
		return root;
	}

}

class Spiral{

	public void getLevelOrderTraversal(Node root) {
		
		
		if(root==null) {
			return;
		}
		if(root.left==null && root.right==null) {
			System.out.print(root.data+" ");
		}
		
		Queue<Node> queue = new LinkedList<>();		
		
		queue.add(root);
		queue.add(null);
		
		int count = 0;
		Map<Integer,Vector<Integer>> map = new TreeMap<>();
		
		while(!queue.isEmpty()) {
			
			
			while(queue.peek()!=null) {
				
				Node temp = queue.poll();
				//System.out.print(temp.data);
				
				Vector v = map.get(count);
				
				if(v==null) {
					v = new Vector<Integer>();
					v.add(temp.data);
					map.put(count, v);
				}		
				else {				
					v.add(temp.data);
					map.put(count, v);
				}
				
				if(temp.left!=null) {
					queue.add(temp.left);
				}
				if(temp.right!=null) {
					queue.add(temp.right);
				}
				
			}		
			
			queue.poll();
			if(queue.size()!=0) {
				queue.add(null);
			}
			
			count++;
			
		}
		
		for(Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
			
			Integer i = entry.getKey();
			Vector<Integer> v = entry.getValue();
			
			if(i%2==0) {				
				for(int j=v.size()-1;j>=0;j--) {
					
					System.out.print(v.get(j)+" ");
					
				}				
			}
			else {				
				for(int j=0;j<=v.size()-1;j++) {
					
					System.out.print(v.get(j)+" ");
					
				}				
			}
			
		}
	}

	private void inorder(Node root) {
		
		if(root==null) {
			return;
		}
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
		
	}	
	
}