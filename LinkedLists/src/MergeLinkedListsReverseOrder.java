import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeLinkedListsReverseOrder {
	Node head;
	
    void addToTheLast(Node node)
    {
        if(head == null)
            head = node;
        else
        {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
    void printList(Node node)
    {
        while(node!= null)
        {
            System.out.print(node.data+ " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException
    {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0)
        {
            String nums[] = br.readLine().split(" ");
            int n1 = Integer.parseInt(nums[0]);
            int n2 = Integer.parseInt(nums[1]);
            MergeLinkedListsReverseOrder list = new MergeLinkedListsReverseOrder();
            nums = br.readLine().split(" ");
            int a1 = Integer.parseInt(nums[0]);
            Node head = new Node(a1);
            list.addToTheLast(head);
            for(int i=1;i<n1;i++)
            {
                int a = Integer.parseInt(nums[i]);
                list.addToTheLast(new Node(a));
            }
            //list.printList(list.head);
            MergeLinkedListsReverseOrder list2 = new MergeLinkedListsReverseOrder();
            nums = br.readLine().split(" ");
            int b1 = Integer.parseInt(nums[0]);
            Node head1 = new Node(b1);
            list2.addToTheLast(new Node(b1));
            for(int j=1;j<n2;j++)
            {
                int b = Integer.parseInt(nums[j]);
                list2.addToTheLast(new Node(b));				
            }
            
            Node result = mergeResult(list.head, list2.head);
            list.printList(result);
            t--;
        }
    }
	
        
    public static Node mergeResult(Node head1, Node head2) {
    	
    	Node next = null;
    	
    	Node first = head1;
    	Node second = head2;
    	Node head = null;
    	
    	while(first!=null && second!=null) {
    	
    		if(head==null) {
    			
    			if(first.data <= second.data) {
    				head = new Node(first.data);
    				first = first.next;
    			}else {
    				head = new Node(second.data);
    				second = second.next;
    			}
    			head.next = next;
    			next = head;
    		}else {
    			
    			if(first.data<=second.data) {
    				Node temp = new Node(first.data);
    				temp.next = head;
    				head = temp;
    				first = first.next;
    			}else {
    				Node temp = new Node(second.data);
    				temp.next = head;
    				head = temp;
    				second = second.next;
    			}
    			
    		}
    		   		
    	}
    	while(first!=null) {
    		Node temp = new Node(first.data);
    		temp.next = head;
    		head = temp;
    		first = first.next;
    	}
    	while(second!=null) {
    		Node temp = new Node(second.data);
    		temp.next = head;
    		head = temp;
    		second = second.next;
    	}
    	return head;
	}
}
