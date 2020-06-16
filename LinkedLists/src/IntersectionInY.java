import java.util.*;
import java.util.Scanner;

public class IntersectionInY {

	Node head = null;
	Node tail = null;
	
	public void addToLast(Node node) {
		
		if(head==null) {
			head = node;
			tail = head;
		}
		else {
			
			tail.next = node;
			tail = node;
			
		}
		
	}
	void printList() {
		Node temp = head;
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			
			IntersectionInY list1 = new IntersectionInY();
			IntersectionInY list2 = new IntersectionInY();
			IntersectionInY list3 = new IntersectionInY();
			
			int a1 = sc.nextInt();
			Node head1 = new Node(a1);			
			Node tail1 = head1;
			
			for(int i=1;i<n1;i++) {
				int a = sc.nextInt();
				tail1.next = (new Node(a));
				tail1 = tail1.next;
			}
			
			int b1 = sc.nextInt();
			Node head2 = new Node(b1);
			Node tail2 = head2;
			
			for(int i=1;i<n2;i++) {
				int b = sc.nextInt();
				tail2.next = (new Node(b));
				tail2 = tail2.next;
			}
			
			int c1 = sc.nextInt();
			Node head3 = new Node(c1);
			Node tail3 = head3;
			
			for(int i=1;i<n3;i++) {
				int c = sc.nextInt();
				tail3.next = (new Node(c));
				tail3 = tail3.next;
			}
			
			Intersect obj = new Intersect();
			System.out.println(obj.intersectPoint(head1,head2)); // Normal solution using hashmap Time O(n1+n2), Space O(n1)
			System.out.println(obj.intPointSmarterSol(head1, head2)); //Smarter soution without using extra space Time O(n1+n2), Space O(1)
			
			t--;
		}
		
	}
	
}
class Intersect{

	public int intersectPoint(Node head1, Node head2) { // Using HashMap
		
		HashSet<Node> map = new HashSet<>();
		Node temp = head1;
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			map.add(temp);
			temp = temp.next;
		}
		System.out.println();
		temp = head2;
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			if(map.contains(temp)) {
				return temp.data;
			}
			temp = temp.next;
		}
		
		return -1;
	}
	
	public int intPointSmarterSol(Node head1,Node head2) {
		
		Node temp = head1;
		
		while(temp!=null) {
			temp.data = temp.data*-1;
			temp = temp.next;
		}
		temp = head2;
		
		while(temp!=null) {
			
			if(temp.data<0) {
				return temp.data*-1;
			}
			temp = temp.next; 
			
		}
		
		return -1;
	}
	
	
	
}
 