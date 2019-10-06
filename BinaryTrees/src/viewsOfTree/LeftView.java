package viewsOfTree;
import java.util.*;
import node.object.Node;

public class LeftView {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		//Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
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
            Tree g = new Tree();
			g.leftView(root);
			System.out.println();
         t--;	
        }
		

	}

}
class Tree{

	static int max_level=0;
    
    void leftView(Node root) {
		leftViewUtil(root,1);
		max_level=0;
	}
    
	public void leftViewUtil(Node root, int level) {
		
		if(root==null)
			return;
		if(level>max_level) {
			System.out.print(root.data+" ");
			max_level = level;
			
		}
		leftViewUtil(root.left,level+1);
		leftViewUtil(root.right,level+1);
		
	}
	
}
