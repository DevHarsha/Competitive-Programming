import java.util.Scanner;

/*You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes.
 *  The task is to delete the node. Pointer/ reference to head node is not given. */

public class Delete_Without_Header
{
	Node head;
	
	void printList(Node head)
	{
		Node tnode = head;
		while(tnode != null)
		{
			System.out.print(tnode.data+ " ");
			tnode = tnode.next;
		}
		System.out.println();
	}
	
	void addToTheLast(Node node)
	{
		
		if(head == null)
		{
			head = node;
		}else
		{
			Node temp = head;
			while(temp.next != null)
			temp = temp.next;
			
			temp.next = node;
		}
	}
	
	Node search_Node(Node head, int k)
	{
		Node current = head;
		while(current != null)
		{
			if(current.data == k)
				break;
			current = current.next;
		}
	return current;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			Delete_Without_Header llist = new Delete_Without_Header();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
			int k = sc.nextInt();
			Node del = llist.search_Node(llist.head,k);
			
			Delete_Node g = new Delete_Node();
			if(del != null && del.next != null)
			{
				g.deleteNode(del);
			}
			llist.printList(llist.head);
		t--;
		}
	}
}


class Delete_Node  {
	
	public void deleteNode(Node node) {
		
		if(node==null) {
			return;
		}
		if(node.next==null) {
			node = null;
		}
		int temp = node.next.data;
		node.data = temp;
		node.next = node.next.next;
		
	}
	
}

