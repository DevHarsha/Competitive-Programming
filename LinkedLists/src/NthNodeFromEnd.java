import java.util.Scanner;

public class NthNodeFromEnd {

	Node head,tail;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			NthNodeFromEnd llist = new NthNodeFromEnd();
			
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToLast(head);
			
			for(int i=1;i<n;i++) {
				int a = sc.nextInt();
				llist.addToLast(new Node(a));
			}
			
			NthNode nth = new NthNode();
			System.out.println(nth.getNthFromLast(llist.head, k));
			
			t--;
		}

	}

	public void addToLast(Node node) {
		
		if(head==null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
		
	}
	
	public void printList(Node head) {
		
		Node temp = head;
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
		
	}
}
class NthNode
{    
    int getNthFromLast(Node head, int n)
    {
    	Node temp = head;
    	
    	while(temp!=null && n>0) {
    		temp = temp.next;
    		n--;
    	}
    	//System.out.println(n);
    	if(temp==null && n==0) {
    		return head.data;
    	}
    	else if(temp==null && n>0) {
    		return -1;
    	}
    	
    	Node temp2 = head;
    	
    	while(temp!=null && temp2!=null) {
    		temp = temp.next;
    		temp2 = temp2.next;
    	}
    	
    	
		return temp2.data;
    	
    }
}
