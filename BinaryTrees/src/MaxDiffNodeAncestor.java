import java.util.*;

import node.object.Node;
/*
 * Given a Binary Tree you need to find maximum value which you can get by subtracting value of node B from value of node A, 
 * where A and B are two nodes of the binary tree and A is an ancestor of B
 */
public class MaxDiffNodeAncestor {

	public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t=sc.nextInt();
          
           while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }         
            
            System.out.println(maxDiff(root));
            
        }
    }

	public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
	
	static int max_value =Integer.MIN_VALUE;
	
	public static int maxDiff(Node root) {
		
		maxDiffUtil(root);
		return max_value;
	}

	public static int maxDiffUtil(Node root) {
		
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		if(root.left==null && root.right==null) {
			return root.data;
		}
		int left = maxDiffUtil(root.left);
		int right = maxDiffUtil(root.right);
		
		int temp = Math.min(left, right);
		max_value = Math.max(max_value, root.data-temp);
			
		
		return Math.min(root.data,temp);
		
	}
	
    
    
}


