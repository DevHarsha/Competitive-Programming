import java.util.Scanner;

public class PairwiseSwap {

	static Node head;
	static Node last;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			int n = sc.nextInt();
			int a1 = sc.nextInt();
			
			Node head = new Node(a1);
			addToLast(head);
			
			for(int i=1;i<n;i++) {
				int a = sc.nextInt();
				addToLast(new Node(a));
			}
			
			Pairwise p = new Pairwise();
			head = p.pairWiseSwap(head);
			printList(head);
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

	public static void addToLast(Node node) {
		
		if(head==null) {
			head = node;
			last = head;
		}
		else {
			last.next = node;
			last = last.next;
		}
	}

}

class Pairwise{

	public Node pairWiseSwap(Node head) {
		
		Node temp = head;
		if(temp==null || temp.next==null) {
			return head;
		}
		while(temp!=null && temp.next!=null) {
			
			int a = temp.next.data;
			temp.next.data = temp.data;
			temp.data = a;
			temp = temp.next.next;
		}
		return head;
	}
	
}
