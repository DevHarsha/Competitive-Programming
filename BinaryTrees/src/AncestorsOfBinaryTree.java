import java.util.*;
import node.object.Node;

//Given a Binary Tree and a target key, 
//your task is to complete the function printAncestors() that prints all the ancestors of the key in the given binary tree.

public class AncestorsOfBinaryTree {

	static Node child;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
            int n = sc.nextInt();
            Node root = null;
            if(n == 1)
            {
                int a = sc.nextInt();
                System.out.println(a);
            }
            else
            {
                for(int i = 0; i < n; i++)
                {
                    Node parent = null;
                    int n1 = sc.nextInt();
                    int n2 = sc.nextInt();
                    char c = sc.next().charAt(0);
                    
                    if(hm.containsKey(n1) == false)
                    {
                        parent = new Node(n1);
                        hm.put(n1,parent);
                        if(root == null)
                          root = parent;
                    }
                    else
                      parent = hm.get(n1);
                      
                      child = new Node(n2);
                      hm.put(n2,child);
                      if(c == 'L')
                       parent.left = child;
                      else
                       parent.right = child;
                       hm.put(n2, child);
                }
                int target = sc.nextInt();
	            printAncestors(root, target);
	            System.out.println();
            }
        }
    }
    
    
	private static boolean printAncestors(Node root, int target) {
		
		if(root==null) {
			return false;
		}
		if(root.data==target) {
			return true;
		}
		if(printAncestors(root.left,target) || printAncestors(root.right,target)) {
			System.out.print(root.data+" ");
			return true;
		}
		return false;
		
	}
}


