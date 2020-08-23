package order.traversals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
										/*PRINT THE BINARY TREE IN DIAGONAL ORDER*/
import java.util.Scanner;
import java.util.Vector;

public class DiagonalPrint
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t --  >0 )
		{	
                        int n=sc.nextInt();
			TreeNode root=null;
			if(n==1)
			{
				int a=sc.nextInt();
				System.out.println(a);
				continue;
			}
			else
			{	
		while(n-->0){
				int n1=Integer.parseInt(sc.next());
				int n2=Integer.parseInt(sc.next());
				char lr=sc.next().charAt(0);
				if(root==null)
				{
					root=new TreeNode(n1);
					switch(lr)
					{
						case 'L':
						root.left=new TreeNode(n2);
						break;
						case 'R':
						root.right=new TreeNode(n2);
						break;
					}
				}
				else{
					insert(root,n1,n2,lr);
				}
			}
			}
			GfG tree = new GfG();
        tree.diagonalPrint(root);
		System.out.println();
			
    }
	}
	public static void insert(TreeNode root,int n1,int n2,char lr){
		if(root==null)
			return;
		if(root.data==n1){
		switch(lr)
					{
						case 'L':
						root.left=new TreeNode(n2);
						break;
						case 'R':
						root.right=new TreeNode(n2);
						break;
					}
		}
		else{
			insert(root.left,n1,n2,lr);
			insert(root.right,n1,n2,lr);
		}
	}
}

class TreeNode
{
    int data; //node data
    TreeNode left, right; //left and right child's reference
    // Tree node constructor
    TreeNode(int d)
    {
        data = d;
        left = right = null;
    }
}

/*Idea is to keep track of vertical distance from root node, for left decrease the distance by 1 and for right keep it constant*/
class GfG
{
	HashMap<Integer,Vector<Integer>> diagonalList = new HashMap<>();
     public void diagonalPrint(TreeNode root)
      {
           int distance = 0;
           diagonalPrintUtil(root,distance);
           
           for(Entry<Integer,Vector<Integer>> entry : diagonalList.entrySet()) {
        	   
        	   Vector<Integer> vec = entry.getValue();
               Iterator it = vec.iterator();
               while(it.hasNext()){
                  System.out.print(it.next()+" ");            	  
               }
        	   
           }
      }
	  public void diagonalPrintUtil(TreeNode root, int distance) {
	  	
		  if(root==null) {
			  return;
		  }
		  Vector<Integer> tempList = diagonalList.get(distance);
		  
		  if(tempList==null) {
			  tempList = new Vector<Integer>();
			  tempList.add(root.data);
		  }
		  else {
			  tempList.add(root.data);
		  }
		  diagonalList.put(distance,tempList);
	  		
		  if(root.left!=null) {
			  diagonalPrintUtil(root.left,distance-1);
		  }
		  if(root.right!=null) {
			  diagonalPrintUtil(root.right,distance);
		  }
		  
	  }
}
