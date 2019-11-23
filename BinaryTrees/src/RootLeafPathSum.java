import java.util.*;

import node.object.Node;

/*Given a Binary Tree and a sum s, your task is to check whether there is a root to leaf path in that tree with the following sum*/

public class RootLeafPathSum {

	// driver function to test the above functions
    public static void main(String args[])
    {
		//Index index_obj = new Index();
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {	
			
				int n1 = sc.nextInt();
                int n2 = sc.nextInt();
				char lr= sc.next().charAt(0);
				
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
                n--;
            }
			int a = sc.nextInt();
			
			boolean b = hasPathSum(root,a);
			if(b==true)
				System.out.println(1);
			else
				System.out.println(0);
			 t--;
        }
    }

	public static boolean hasPathSum(Node root, int sum) {
		
		if(root==null) {
			return false;
		}
		if(root.left==null && root.right==null) {
			if((sum-root.data)==0) {
				return true;
			}
			return false;
		}
		
		sum = sum - root.data;
		return hasPathSum(root.left,sum) || hasPathSum(root.right, sum);
	}
}

