import java.util.Scanner;

public class MergeTwoLinkedLists {

	
	Node head;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		 
		 while(t>0)
        {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			MergeTwoLinkedLists llist1 = new MergeTwoLinkedLists();
			MergeTwoLinkedLists llist2 = new MergeTwoLinkedLists();
			
				int a1=sc.nextInt();
				Node head1= new Node(a1);
				llist1.addToTheLast(head1);
				if (sc.hasNextInt())
				for (int i = 1; i < n1; i++) 
				{ 
					//int a;

					 int a = sc.nextInt(); 
					llist1.addToTheLast(new Node(a));
				}
			
			
				int b1=sc.nextInt();
				Node head2 = new Node(b1);
				llist2.addToTheLast(head2);
				if (sc.hasNextInt()) 
				for (int i = 1; i < n2; i++) 
				{
					//int b;
					
					 int b = sc.nextInt(); 
					llist2.addToTheLast(new Node(b));
				}
				llist1.head= new LinkedList().sortedMerge(llist1.head,llist2.head);
				llist1.printList();
			
			t--;
			
        }

	}

	void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }

	public void addToTheLast(Node node)
    {

      if (head == null) {
           head = node;
          } else {
           Node temp = head;
           while (temp.next != null)
            temp = temp.next;
        
           temp.next = node;
        }
    }

}

class LinkedList{

	public Node sortedMerge(Node headA, Node headB) {
		
		if(headA==null) {
			return headB;
		}
		if(headB==null) {
			return headA;
		}
		
		Node temp, temp2;
		
		if(headA.data<=headB.data) {
			temp = headA;
			headA = headA.next;
		}
		else {
			temp = headB;
			headB = headB.next;
		}
		Node head = temp;
		
		while(headA!=null && headB!=null) {
			
			if(headA.data<=headB.data) {
				temp.next = headA;
				headA = headA.next;
				temp = temp.next;
			}else {
				temp.next = headB;
				headB = headB.next;
				temp = temp.next;
			}
			
		}
		while(headA!=null) {
			temp.next = headA;
			headA = headA.next;
			temp = temp.next;
		}
		while(headB!=null) {
			temp.next = headB;
			headB = headB.next;
			temp = temp.next;
		}
		
		return head;
	}
	
}
