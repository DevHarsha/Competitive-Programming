import java.util.Scanner;

/*Class to remove loop from a LinkedList*/

class Loop{
    
    
    public static void removeTheLoop(Node head)
    {
    	if(head.next==null || head==null) {
    		return; 
    	}
    	Node slow = head.next;
    	Node fast = head.next.next;
    	
    	while(fast!=null && fast.next!=null) {
    		
    		if(slow==fast) {
    			removeLoop(slow,head);
    			break;
    		}
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    }

	public static void removeLoop(Node slow, Node head) {
		
		Node ptr1 = slow;
		
		int count = 1;
		
		while(ptr1.next!=slow) {
			ptr1 = ptr1.next;
			count++;
		}
		
		ptr1 = head;
		Node ptr2 = head;
		
		while(count>0) {
			ptr1 = ptr1.next;
			count--;
		}
		
		while(ptr1.next!=ptr2.next) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		ptr1.next = null;
		
		//System.out.println(count);
		
	}
    
    
}


class gfg {

	 public static Node newNode(int data)
    {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static Node insert(Node head, int data)
    {
        if (head == null)
            head = newNode(data);
        else
            head.next = insert(head.next, data);
        return head;
    }
    
    public static void makeLoop(Node head, int x)
    {
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;
        int counter = 0;
        while (counter < x)
        {
            curr = curr.next;
            counter++;
        }
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static int detectloop(Node head)
    {
        Node hare = head.next;
        Node tortoise = head;
        while (hare != tortoise && hare != null && tortoise != null)
        {
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare != null && hare.next != null)
                hare = hare.next;
            if (hare == tortoise)
                return 1;
        }
        if (hare == tortoise)
            return 1;
        return 0;
    }
    
    public static int length(Node head, boolean hasloop)
    {
        int len = 0;
        if (hasloop == false)
        {
            Node temp = head;
            while (temp != null)
            {
                len++;
                temp = temp.next;
            }
            return len;
        }
        else
        {
            Node hare = head.next;
            Node tortoise = head;
            while (hare != tortoise)
            {
                hare = hare.next;
                tortoise = tortoise.next;
                hare = hare.next;
                if (hare == tortoise)
                    break;
            }
           
            int looplen = 0;
            while (hare.next!=tortoise)
            {
                hare = hare.next;
                looplen++;
            }
            
            looplen++;
            Node begin = head;
            int startlen = 0;
            tortoise = tortoise.next;
            while (begin != tortoise)
            {
                
                begin = begin.next;
                tortoise = tortoise.next;
                startlen++;
            }
            return looplen + startlen;
            
        }
    }

}

public class Remove_loop
{
   public static void main (String[] args) {

       /* code */
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       
       while(t--> 0)
       {
           int sizeOfArray = sc.nextInt();
           int arr[] = new int[sizeOfArray];
           
           for(int i = 0; i < sizeOfArray; i++)
             arr[i] = sc.nextInt();
             
          Node head = null;
           
             for (int i = 0; i < sizeOfArray; i++)
               {
                   head = new gfg().insert(head, arr[i]);
               }
               int x = sc.nextInt();
               new gfg().makeLoop(head, x);
               
               int length = 0;
               if (new gfg().detectloop(head) == 1)
               {
                    length=new gfg().length(head, true);
               }
               else
               {
                    length = new gfg().length(head, false);
               }
               new Loop().removeTheLoop(head);
               if (new gfg().detectloop(head) == 0 && length == new gfg().length(head, false))
                   System.out.println("1");
               else
                  System.out.println("0");
       }
   }
}