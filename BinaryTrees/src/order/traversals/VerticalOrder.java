package order.traversals;

import java.io.*;
import java.util.*;

class Node
{
    int data, hd;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}
public class VerticalOrder {

		public static void main (String[] args)throws IOException {
	        
	        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(read.readLine());
	        
	        while(t-- > 0)
	        {
	            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
	            int n = Integer.parseInt(read.readLine());
	            Node root = null;
	            String str[] = read.readLine().replace("  ", " ").trim().split(" ");
	            int k = 0;
	            while(n-- > 0)
	            {
	                int n1 = Integer.parseInt(str[k++]);
	                int n2 = Integer.parseInt(str[k++]);
		        	char lr= str[k++].charAt(0);
					
	                
	                Node parent = m.get(n1);
	                if (parent == null)
	                {
	                    parent = new Node(n1);
	                    m.put(n1, parent);
	                    if (root == null)
	                        root = parent;
	                }
	                Node child = new Node(n2);
	                if (lr == 'L')
	                    parent.left = child;
	                else
	                    parent.right = child;
	                m.put(n2, child);
	            }
	            
	            BinaryTree obj = new BinaryTree();
	            obj.verticalOrder(root);
	            System.out.println();
	        }
	    }
	
}
