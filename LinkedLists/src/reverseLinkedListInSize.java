import java.util.Scanner;

public class reverseLinkedListInSize {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			
			int n = sc.nextInt();
			int a1 = sc.nextInt();

			Node head = new Node(a1);
			Node tail = head;
			
			for(int i=1;i<n;i++) {
				
				int a = sc.nextInt();
				tail.next = new Node(a);
				tail = tail.next;
				
			}
			int k = sc.nextInt();
			reverseSize g = new reverseSize();			
			Node recursive = g.reverseInGroups(head,k);
			printList(recursive);
			System.out.println();
			t--;
		}

	}

	public static void printList(Node node) {
		
		while(node!=null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		
	}

}

class reverseSize{
	
    
	public Node reverseInGroups(Node node,int k) {
		
		
		Node curr = node;
		Node prev = null;
		Node next = null;
		int size = k;
		while(k>0 && curr!=null) {
		
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			k--;			
		}
		if(node!=null) {
			node.next = reverseInGroups(curr, size);
		}
		return prev;
		
	}
	
	
}