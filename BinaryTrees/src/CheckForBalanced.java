import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckForBalanced {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			String s = br.readLine();
			Node root = buildTree(s);
			
			
			TreeBalance tb = new TreeBalance();
			
			boolean isBalanced = tb.isBalanced(root);
			
			if(isBalanced) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
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
class TreeBalance{
	
	boolean isBalanced(Node root) {
		
		if(root==null) {
			return true;
		}
		if(root.left==null && root.right==null) {
			return true;
		}
		
		int left_h = height(root.left);
		int right_h = height(root.right);
		
		if(Math.abs(right_h-left_h)>1) {
			return false;
		}
		
		return isBalanced(root.left) && isBalanced(root.right);
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