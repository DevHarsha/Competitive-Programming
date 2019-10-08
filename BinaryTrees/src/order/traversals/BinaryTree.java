package order.traversals;

import java.util.*;

public class BinaryTree {

	
	
	
	/*
	 * static Map<Integer,Vector<Integer>> map = new
	 * TreeMap<Integer,Vector<Integer>>();
	 * 
	 * public static void printTree(Node node,int hd){ if(node==null){ return; }
	 * Vector<Integer> temp = map.get(hd); if(temp==null){ temp = new
	 * Vector<Integer>(); temp.add(node.data); }else{ temp.add(node.data); }
	 * map.put(hd,temp); printTree(node.left,hd-1); printTree(node.right,hd+1); }
	 * static void verticalOrder(Node root) { printTree(root,0);
	 * for(Map.Entry<Integer,Vector<Integer>> entry : map.entrySet()) { Integer key
	 * = entry.getKey(); Vector<Integer> value = entry.getValue();
	 * //System.out.println(value); for(int i=0;i<value.size();i++){
	 * System.out.print(value.get(i)+" "); } } map.clear(); }
	 */	
	
	
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
	
	
	/*
	 * static Map<Integer,Vector<Integer>> map = new
	 * TreeMap<Integer,Vector<Integer>>();
	 * 
	 * static void verticalOrder(Node root) {
	 * 
	 * verticalOrderUtil(root,0);
	 * 
	 * for(Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) { Integer key
	 * = entry.getKey(); Vector<Integer> value = entry.getValue(); for(int
	 * i=0;i<value.size();i++){ System.out.print(value.get(i)+" "); }
	 * 
	 * } map.clear(); }
	 * 
	 * static void verticalOrderUtil(Node root, int hd) {
	 * 
	 * if(root==null) { return; } Vector<Integer> llist = map.get(hd);
	 * 
	 * if(llist==null) { llist = new Vector<Integer>(); llist.add(root.data); }else
	 * { llist.add(root.data); }
	 * 
	 * map.put(hd, llist); verticalOrderUtil(root.left, hd-1);
	 * verticalOrderUtil(root.right, hd+1);
	 * 
	 * }
	 */

}
