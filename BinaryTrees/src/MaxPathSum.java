import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxPathSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			String s = br.readLine();
			Node root = buildTree(s);
			
			MaxPath mp = new MaxPath();
			System.out.println(mp.getMaxPathSum(root));
			System.out.println(mp.getMaxPathSumRe(root));
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

class MaxPath{	
	
	public static int getMaxPathSum(Node node) {
		Res res = new Res();
		getMaxPathSumUtil(node, res);
		return res.data;
	}
	
	
	public int getMaxPathSumRe(Node root) {
		
		if(root==null) {
			return 0;
		}
		Res result = new Res();
		int res = getMaxPathReUtil(root,result);
		
		return result.data;
	}
	public int getMaxPathReUtil(Node root, Res result) {
		
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return root.data;
		}
		int left_Sum = getMaxPathReUtil(root.left, result);
		int right_Sum = getMaxPathReUtil(root.right, result);
		
		if(root.left!=null && root.right!=null) {
			result.data = Math.max(result.data, left_Sum+right_Sum+root.data);
			return Math.max(left_Sum, right_Sum)+root.data;
		}
		
		
		
		
		return root.left==null?right_Sum+root.data : left_Sum+root.data;
	}
	
	
	
	
	public static int getMaxPathSumUtil(Node root,Res res) {
		
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return root.data;
		}
		
		int leftMAX = getMaxPathSumUtil(root.left,res);
		int rightMAX = getMaxPathSumUtil(root.right,res);
		
				
		if(root.left!=null && root.right!=null) {
			res.data = Math.max(res.data, leftMAX+rightMAX+root.data);
			return Math.max(leftMAX, rightMAX)+root.data;
		}
		
		
		return root.left==null? rightMAX+root.data : leftMAX+root.data;
	}		
	
}
class Res{
	
	int data;
    Res(){
        this.data = Integer.MIN_VALUE;
    }
	
}
