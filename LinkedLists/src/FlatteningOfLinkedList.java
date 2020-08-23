import java.util.Scanner;


public class FlatteningOfLinkedList {

	Node head;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		FlatteningOfLinkedList list = new FlatteningOfLinkedList();
		
		while(t>0) {
			
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;
			int flag = 1;
			int flag1 = 1;
			
			for(int i=0;i<N;i++) {
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				
				if(flag==1) {
					
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
					
				}
				else {
					
					pre.next = temp;
					pre = temp;
					flag1 = 1;
					
				}
				
				for(int j=0;j<m;j++) {
					
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1==1) {
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else {
						preB.bottom = tempB;
						preB = tempB;
					}
					
				}
			}
			
			Flattening_Nodes fn = new Flattening_Nodes();
			Node root = fn.flatten(list.head);
			list.printList(root);
			
			t--;
		}

	}
	public void printList(Node root) {
		
		while(root!=null) {
			System.out.print(root.data+" ");
			root = root.bottom;
		}
		System.out.println();
	}

}
class Flattening_Nodes{
	
	Node flatten(Node root)
    {
		if(root.next==null || root==null) {
			return root;
		}
		
		root.next = flatten(root.next);
		root = Merger(root,root.next);
		
		return root;
    }

	public Node Merger(Node a, Node b) {
		
		if(a==null) {
			return b;
		}
		if(b==null) {
			return a;
		}
		Node result;
		
		if(a.data<=b.data) {
			
			result = a;
			result.bottom = Merger(a.bottom, b);
			
		}
		else {
			result = b;
			result.bottom = Merger(a, b.bottom);
		}
		
		return result;
	}
	
}

