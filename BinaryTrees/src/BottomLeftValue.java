import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftValue {

	
	Node root; 
     
   
	
    public static void main(String[] args) {
		
		BottomLeftValue tree = new BottomLeftValue(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.right.left = new Node(5); 
        tree.root.right.right = new Node(6); 
        tree.root.right.left.right = new Node(7); 
        tree.root.right.right.right = new Node(8); 
        tree.root.right.left.right.left = new Node(9); 
        tree.root.right.right.right.right = new Node(10); 
  
        int result = tree.deepestLeftLeaf(tree.root); 
        if (result != -1) 
            System.out.println("The deepest left child"+ 
                               " is " + result); 
        else
            System.out.println("There is no left leaf in"+ 
                               " the given tree"); 

	}

	public int deepestLeftLeaf(Node root) {
		
		if(root==null) {
			return -1;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		int bottomValue = -1;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			bottomValue = temp.data;
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
			
			while(queue.peek()!=null) {
				
				temp = queue.poll();
				//bottomValue = temp.data;
				
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
			
		}
		
		return bottomValue;
	}
	

}


class Node 
{ 
    int data; 
    Node left, right; 
   
    public Node(int data) 
    { 
        this.data = data; 
        left = right = null; 
    } 
} 