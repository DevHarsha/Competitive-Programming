import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-->0) {
			
			String s = br.readLine();
			Node root = buildTree(s);
			String X = br.readLine();
			String arr[] = X.split(" ");
			int x, y;
			
			x = Integer.parseInt(arr[0]);
			y = Integer.parseInt(arr[1]);
			
			LCA lca = new LCA();
			System.out.println(lca.getLowestCommonAncestor(root,x,y).data);
			
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

class LCA{

	public Node getLowestCommonAncestor(Node root,int n1,int n2) {
		
		if(root==null) {
			return null;
		}
		
		if(root.data==n1 || root.data==n2) {
			return root;
		}
		Node left_lca = getLowestCommonAncestor(root.left, n1, n2);
		Node right_lca = getLowestCommonAncestor(root.right, n1, n2);
		
		
		if(left_lca!=null && right_lca!=null) {
			return root;
		}
		
		return left_lca==null?right_lca : left_lca;	
		
	}
	
	
	
}