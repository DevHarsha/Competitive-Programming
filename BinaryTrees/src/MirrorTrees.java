import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MirrorTrees {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			String s = br.readLine();
			Node root = buildTree(s);
			
			
			Symmetric s1 = new Symmetric();
			
			boolean isSymmetric= s1.isSymmetric(root);
			
			if(isSymmetric) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
			
		}

	}
	
	public static Node buildTree(String s) {
		
		if(s.length()==0 || s.charAt(0)=='N') {
			return null;
		}
		
		String ip[] = s.split(" ");
		Node root = new Node(Integer.parseInt(ip[0]));
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while(queue.size()>0 && i<ip.length) {
			
			Node currNode = queue.peek();
			queue.remove();
			
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
class Symmetric{

	public boolean isSymmetric(Node root) {
		
		if(root==null) {
			return true;
		}
		if(root.left==null && root.right==null) {
			return true;
		}
				
		return isSymmetricUtil(root.left,root.right);
	}

	public boolean isSymmetricUtil(Node left, Node right) {
		
		if(left==null && right==null) {
			return true;
		}
		
		if(left==null || right==null) {			
			return false;			
		}
		
		if(left.data==right.data) {
			return isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
		}
		
		return false;
	}
		
}

	//	INORDER TRAVERSAL USING STACK
	
	/*
	 * public String inorderTraversal(Node root) {
	 * 
	 * String traversal = "";
	 * 
	 * if(root==null) { return traversal; }
	 * 
	 * Stack<Node> stack = new Stack<Node>(); Node curr = root;
	 * 
	 * while(curr!=null || stack.size()>0) {
	 * 
	 * while(curr!=null) {
	 * 
	 * stack.push(curr); curr = curr.left;
	 * 
	 * }
	 * 
	 * curr = stack.pop(); traversal = traversal+curr.data+" ";
	 * 
	 * curr = curr.right;
	 * 
	 * }
	 * 
	 * return traversal; }
	 */
	
	
	

