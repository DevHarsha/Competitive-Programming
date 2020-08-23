import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;

public class VerticalOrderPrint {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			String s = br.readLine();
			Node root = buildTree(s);
			BinaryTree obj = new BinaryTree();
			ArrayList<Integer> list = obj.verticalOrder(root);
			
			for(Integer i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
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
// USE QUEUE FOR MOST ORDER TRAVERSALS, VERTICAL PRINT AND BOTTOM VIEW OF TREE REQUIRE QUEUE 

class BinaryTree{

	public ArrayList<Integer> verticalOrder(Node root) {
		
		Queue<Pair> queue = new LinkedList<>();
		Map<Integer,ArrayList<Integer>> m = new TreeMap<>();
		ArrayList<Integer> rList = new ArrayList<>();
		
		queue.add(new Pair(root,0));
		
		while(!queue.isEmpty()) {
			
			Pair p = queue.poll();
			int hd = p.hd;
			Node curr = p.node;
			
			if(m.containsKey(hd)) {
				
				m.get(hd).add(curr.data);
				
			}
			else {
				
				ArrayList<Integer> list = new ArrayList<>();
				list.add(curr.data);
				m.put(hd, list);
				
			}
			if(curr.left!=null) {
				queue.add(new Pair(curr.left,hd-1));
			}
			if(curr.right!=null) {
				queue.add(new Pair(curr.right, hd+1));
			}
			
		}
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
			
			for(Integer i : entry.getValue()) {
				rList.add(i);
			}
			
		}
		
		return rList;
	}

	
	//Below recursive Approach doesn't work because of traversal issue
	/*public ArrayList<Integer> verticalOrder(Node root) {
		
		TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		verticalOrderUtil(root,0,m);
		
		for(Map.Entry<Integer, Vector<Integer>> entry : m.entrySet()) {
			
			Vector<Integer> v=entry.getValue();
			
            for(Integer i : v)
            	list.add(i);
			
		}
		return list;
		
	}*/

	/*public void verticalOrderUtil(Node root, int i, TreeMap<Integer, Vector<Integer>> m) {
		
		if(root==null) {
			return;
		}
		//System.out.println(root.data);
		Vector<Integer> vec = m.get(i);
		if(vec==null) {
			vec = new Vector<>();
			vec.add(root.data);
		}
		else {
			vec.add(root.data);
		}
		m.put(i, vec);
		verticalOrderUtil(root.left,i-1, m);
		verticalOrderUtil(root.right,i+1, m);
		
	}*/

	
}

class Pair{
	
	Node node;
	int hd;
	
	Pair(Node node,int hd){
		this.hd = hd;
		this.node = node;
	}
	
}