import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import node.object.Node;

public class DiamterOfBinaryTree {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t>0) {
			String s = br.readLine();
			Node root = buildTree(s);
			Tree g = new Tree();
			System.out.println(g.diameter(root));
			t--;
		}

	}

	public static Node buildTree(String s) {
		
		if(s.length()==0 || s.charAt(0)=='N') {
			return null;
		}
		
		String ip[] = s.split(" ");
		Node root = new Node(Integer.parseInt(ip[0]));
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		int i = 1;
		
		while(q.size()>0 && i<ip.length) {
			
			Node currNode = q.peek();
			q.remove();
			
			String currVal = ip[i];
			
			if(!currVal.equals("N")) {
				
				currNode.left = new Node(Integer.parseInt(currVal));
				q.add(currNode.left);
				
			}
			
			//for adding right child
			
			i++;
			if(i>=ip.length) { break; }
			
			currVal = ip[i];
			if(!currVal.equals("N")) {
				
				currNode.right = new Node(Integer.parseInt(currVal));
				q.add(currNode.right);
				
			}
			i++;
			
		}				
		return root;
	}
	static void printInorder(Node root) {
		
		if(root==null) {
			return;
		}
		
		printInorder(root.left);
		System.out.println(root.data+" ");
		printInorder(root.right);
		
	}
	
}

class Tree{
	
	static int max_val = Integer.MIN_VALUE;
	
	int diameter(Node root) {
		
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		
		int leftD = diameter(root.left);
		int righD = diameter(root.right);
		
		int leftH = height(root.left);
		int righH = height(root.right);
		
		int max_diamter = Math.max(leftD, righD);
		int max_among_diameter_height = Math.max(max_diamter, leftH+righH+1);
		
		max_val = Math.max(max_val, max_among_diameter_height);
		
		return max_among_diameter_height;
    }

	public int height(Node node) {
		
		if(node==null) {
			return 0;
		}
		int left = height(node.left);
		int right = height(node.right);
		
		return Math.max(left, right)+1;
		
		
	}
	
}