package order.traversals;

import java.util.*;

public class BinaryTree {

	
	
	
	
	
	static Map<Integer,Vector<Integer>> map = new TreeMap<Integer,Vector<Integer>>();
    Queue<Node> queue = new LinkedList<>();
    
    public  void printTree(Node node,int hd){
        if(node==null){
            return;
        }
        node.hd = hd;
        queue.add(node);
        
        while(!queue.isEmpty()) {
        	
        	Node temp = queue.poll();
	        hd = temp.hd;
        	Vector<Integer> nList = map.get(hd);
	        
	        if(nList==null){
	            nList = new Vector<Integer>();
	        }
	        
	        nList.add(temp.data);	        
	        map.put(temp.hd,nList);
	        
	        if(temp.left!=null) {
	        	temp.left.hd = temp.hd-1;
	        	queue.add(temp.left);
	        }
	        if(temp.right!=null) {
	        	temp.right.hd = temp.hd+1;
	        	queue.add(temp.right);
	        }
	        
        }
    }
    public void verticalOrder(Node root)
    {
        printTree(root,0);
        for(Map.Entry<Integer,Vector<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Vector<Integer> value = entry.getValue();
            //System.out.println(value);
            for(int i=0;i<value.size();i++){
                System.out.print(value.get(i)+" ");    
            }
        }
        map.clear();
    }
	
	
	

}
