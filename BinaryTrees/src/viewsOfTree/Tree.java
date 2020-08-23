package viewsOfTree;

import java.util.*;
import java.util.Map.Entry;

import node.object.Node;

public class Tree {

	static int max_level = 0;

	void leftView(Node root) {
		leftViewUtil(root, 1);
		max_level = 0;
	}

	public void leftViewUtil(Node root, int level) {

		if (root == null)
			return;
		if (level > max_level) {
			System.out.print(root.data + " ");
			max_level = level;

		}
		leftViewUtil(root.left, level + 1);
		leftViewUtil(root.right, level + 1);

	}

	public void rightView(Node root) {

		rightViewUtil(root, 1);
		max_level = 0;
	}

	private void rightViewUtil(Node root, int level) {

		if (root == null) {
			return;
		}
		if (max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}
		rightViewUtil(root.right, level + 1);
		rightViewUtil(root.left, level + 1);

	}
	
	  public void bottomView(Node root) {
	  
		  if(root==null) { return; }
		  
		  Queue<QueueObj> queue = new LinkedList<>(); 
		  TreeMap<Integer,QueueObj> map = new TreeMap<>(); int hd = 0;
		  
		  queue.add(new QueueObj(root,hd));
	  
		  while(queue.size()!=0) {
		  
			  QueueObj q = queue.poll(); hd = q.hd;
		  
			  map.put(hd,q);
		  
			  if(q.node.left!=null) { 
				  
				  queue.add(new QueueObj(q.node.left, hd-1));
				  
			  }
			  if(q.node.right!=null) { 
				  
				  queue.add(new QueueObj(q.node.right, hd+1));
				  
			  }
			  
		  }	  
	  
		  for(Entry<Integer, QueueObj> entry : map.entrySet()) {
			  
			  System.out.print(entry.getValue().node.data+" ");
			  
		  }
	  
	  }	 
	  
	  
	  /*
		 * public void bottomView(Node root) { if(root==null){ return; }
		 * 
		 * class QueueObj{
		 * 
		 * Node node; int hd; QueueObj(Node n,int h){ node = n; hd = h; }
		 * 
		 * }
		 * 
		 * Queue<QueueObj> queue = new LinkedList<QueueObj>(); Map<Integer,Node> map =
		 * new TreeMap<Integer,Node>(); queue.add(new QueueObj(root,0));
		 * 
		 * while(!queue.isEmpty()){
		 * 
		 * QueueObj q = queue.poll(); map.put(q.hd,q.node); if(q.node.left!=null){
		 * queue.add(new QueueObj(q.node.left,q.hd-1)); } if(q.node.right!=null){
		 * queue.add(new QueueObj(q.node.right,q.hd+1)); } }
		 * 
		 * for(Entry<Integer, Node> entry: map.entrySet()) {
		 * System.out.print(entry.getValue().data + " "); }
		 * 
		 * }
	*/

}
