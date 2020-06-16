import java.util.Scanner;

public class RotateLinkedList {

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
			int k = sc.nextInt();
			Rotate g = new Rotate();			
			Node recursive = g.rotate(head, k);
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

class Rotate {
    
    
   public Node rotate(Node head, int k) {
       
	   
	   if(head==null || head.next==null || k==0) {
		   return head;
	   }
	   
	   Node temp = head;
       
       while(k>1 && temp.next!=null) {
    	   
    	   temp = temp.next;
    	   k--;
    	   
       }
       
       Node result = temp.next;
		
       if(result==null) { return head; }  //If the K is same as length of linked list then simply return org list
		 
       temp.next = null;
       temp = result;
       
       while(temp.next!=null) {
    	   temp = temp.next;
       }
       temp.next = head;
       
	   return result;
	   
   }
   
}