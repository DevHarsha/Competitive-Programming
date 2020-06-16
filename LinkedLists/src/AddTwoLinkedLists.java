import java.util.Scanner;

public class AddTwoLinkedLists {

	Node head;
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        // System.out.println("");
    }
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n1 = sc.nextInt();
            AddTwoLinkedLists list1 = new AddTwoLinkedLists();
            for (int i = 1; i <= n1; i++) {
                int a = sc.nextInt();
                list1.push(a);
            }
            int n2 = sc.nextInt();
            AddTwoLinkedLists list2 = new AddTwoLinkedLists();
            for (int i = 0; i < n2; i++) {
                int b = sc.nextInt();
                list2.push(b);
            }
            AddTwoLinkedLists list3 = new AddTwoLinkedLists();
            Add g = new Add();
            Node rs = g.addTwoLists(list1.head, list2.head);
            list3.printList(rs);
            System.out.println();
            T--;
        }
    }

}
class Add {
    
    
    Node addTwoLists(Node first, Node second) {
		
    	if(first==null && second ==null) {
    		return null;
    	}
    	else if(first==null || second==null) {
    		return first==null?second : first;
    	}
    	
    	Node temp = null;//new Node();
    	Node result = null;
    	int sum = 0;
    	int carry = 0;
    	
    	while(first!=null && second!=null) {
    		sum = (first.data+second.data)+carry;
    		carry = sum/10;
    		sum = sum%10;
    		
    		if(temp == null) {
    			temp = new Node(sum);
    			result = temp;
    		}
    		else {
    			temp.next = new Node(sum);
    			temp = temp.next;
    		}
    		first = first.next;
    		second = second.next;
    	}
    	
    	while(first!=null) {
    		sum = first.data+carry;
    		carry = sum/10;
    		sum = sum%10;
    		
    		temp.next = new Node(sum);
    		temp = temp.next;
    		first = first.next;
    	}
    	while(second!=null) {
    		sum = second.data+carry;
    		carry = sum/10;
    		sum = sum%10;
    		
    		temp.next = new Node(sum);
    		temp = temp.next;
    		second = second.next;
    	}
    	
    	if(carry!=0) {
    		temp.next = new Node(carry);
    		temp = temp.next;
    		temp.next = null;
    	}
    	
    	return result;
        
    }
}
