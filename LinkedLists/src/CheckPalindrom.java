import java.util.Scanner;

public class CheckPalindrom {

	static Node head;
	static Node last;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0) {
			int n = sc.nextInt();
			CheckPalindrom cp = new CheckPalindrom();
			
			int a1 = sc.nextInt();
			
			Node head = new Node(a1);
			addToLast(head);
			
			for(int i=1;i<n;i++) {
				int a = sc.nextInt();
				addToLast(new Node(a));
			}
			
			Palindrome p = new Palindrome();
			
			if(p.isPalindrome(head)==true) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
						
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

class Palindrome {

	public boolean isPalindrome(Node head) {
		
		
		Node temp = head;
		String st = "";
		
		if(temp==null || temp.next==null) {
			return true;
		}
		
		while(temp!=null) {
			//System.out.print(temp.data+" ");
			st = st+temp.data;
			temp = temp.next;
			
		}
		
		int i = 0,j = st.length()-1;
		
		while(i<j) {
		
			if(st.charAt(i)!=st.charAt(j)) {
				return false;
			}
			i++;
			j--;
			//System.out.println("hehe");
		}
		
		return true;
	}	
	
}