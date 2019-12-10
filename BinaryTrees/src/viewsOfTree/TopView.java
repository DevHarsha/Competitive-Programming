package viewsOfTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import node.object.Node;

public class TopView {

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
		
            new View().topView(root);
            System.out.println();
            t--;
			
        }

	}

}
class View
{
    
    
    static void topView(Node root)
    {
        if(root==null){
            return;
        }
        LinkedList<QueueObj> queue = new LinkedList<>();
        TreeMap<Integer,QueueObj> map = new TreeMap<>();    
        
        queue.addLast(new QueueObj(root,0));
        
        while(!queue.isEmpty()){
            
            QueueObj temp = queue.removeFirst();
            if(!map.containsKey(temp.hd)){
                //System.out.print(temp.node.data+" ");
                map.put(temp.hd,temp);
            }
            if(temp.node.left!=null){
                queue.add(new QueueObj(temp.node.left,temp.hd-1));
            }
            if(temp.node.right!=null){
                queue.add(new QueueObj(temp.node.right,temp.hd+1));
            }
            
        }
        
        for(Map.Entry<Integer,QueueObj> val: map.entrySet()){
            System.out.print(val.getValue().node.data+" ");
        }
        
    }
    
}