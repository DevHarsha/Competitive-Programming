import java.util.Scanner;

public class Reverse {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			
			int n = sc.nextInt();
			Node head = new Node(sc.nextInt());
			Node tail = head;
			
			for(int i=0;i<n-1;i++) {
			
				tail.next = new Node(sc.nextInt());
				tail = tail.next;
				
			}
			
			ReverseLL g = new ReverseLL();
			//head = g.reverseList(head); // Iterative approach
			Node recursive = g.reverseListRecursive(head);
			printList(recursive);
			t--;
		}
	}

	static void printList(Node node) {
		
		while(node!=null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		
	}

}
class ReverseLL
{
	   Node reverseList(Node head) //Iterative approach
	   {
		   Node prev = null;
		   Node curr = head;
		   Node next = null;
		   
		   while(curr!=null) {
			   
			   next = curr.next;
			   curr.next = prev;
			   prev = curr;
			   curr = next;
			   
		   }
		   head = prev;
		   return head;
	        
	   }
   
	   Node reverseListRecursive(Node head) {
		   
		   if(head==null || head.next==null) {
			   return head;
		   }
		   Node rest = reverseListRecursive(head.next);
		   head.next.next = head;
		   head.next = null;
		   
		   
		   return rest;
		   
	   }
   
}













