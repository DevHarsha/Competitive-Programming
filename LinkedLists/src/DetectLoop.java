import java.util.HashSet;
import java.util.Scanner;

public class DetectLoop {
	
	static Node head;
	
	public static void push(int new_data) {
		
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
		
	}

	public static void main(String[] args) {
		
		int t,d,n,i,x,c;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		for(d=0;d<t;d++) {
			n = sc.nextInt();
			
			head = null;
			Node q;
			
			for(i=0;i<n;i++) {
				x = sc.nextInt();
				push(x);
			}
			Node p;
			p = head;
			q = head;
			
			while(q.next!=null) { q = q.next; }
			
			c = sc.nextInt();
			
			if(c>0) {
				
				c = c-1;
				for(i=0;i<c;i++) {
					p = p.next;
				}
				q.next = p;
				
			}
			Solution sln = new Solution();
			//int hash = sln.detectLoopHash(head); //Solution using HashSet Time O(n) Space O(n)
			int hash = sln.detectLoop(head); //Smarter solution Time O(n) Space O(1) using 2 pointers 
			if(hash==1) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
		}

	}

}
class Solution{

	public int detectLoop(Node head) {
		
		Node slow = head;
		Node fast = head;
		
		while(fast!=null && fast.next!=null) {
			
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				return 1;
			}
			
		}
		//Node ptr1 = slow;
		
		return 0;
	}

	public int detectLoopHash(Node node) {
		
		
		  HashSet<Node> set = new HashSet<>(); Node temp = node;
		  
		  while(temp!=null) { 
			  			  
			  if(set.contains(temp)) { 
				  return 1;
			  } 
			  
			  set.add(temp); 
			  temp = temp.next;
		 }
		 
		return 0;
	}
	
	
	
}
