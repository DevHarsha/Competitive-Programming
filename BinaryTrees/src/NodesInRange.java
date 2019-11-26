import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import node.object.Node;

//Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.
public class NodesInRange {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    Node root=null;
		    int sizeOfArray=sc.nextInt();
		    int arr[]=new int[sizeOfArray];
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        int x=sc.nextInt();
		        arr[i]=x;
		    }
		   
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        root=Geeks.newNode(root,arr[i]);
		    }
		    int l,h;
		    l=sc.nextInt();
		    h=sc.nextInt();
		    System.out.println(Geeks.getCountOfNode(root,l,h));
		
		}

	}

}
class Geeks{

	public static Node newNode(Node root, int data) {
		
		if(root==null)
	        root=createNewNode(data);
	    else if(data<root.data)
	        root.left=newNode(root.left,data);
	    else
	        root.right=newNode(root.right,data);
	        
	        return root;
	}
//-------------------------------------------------------------------/*Approach*/-----------------------------------------------------------------\\

	/*Traverse through the Tree using a Queue, same as we do in case of level order traversal*/	
	public static int getCountOfNode(Node root, int l, int h) {
		
		if(root==null) {
			return 0;
		}
		
		int count = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			if(l<=temp.data && temp.data<=h) {
				count++;
			}
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
			
		}	
		
		return count;
	}

	public static Node createNewNode(int value) {
		
		Node temp=new Node(value);        
        return temp;
        
	}
	
	
}
