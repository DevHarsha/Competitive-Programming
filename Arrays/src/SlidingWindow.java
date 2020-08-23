import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SlidingWindow {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++){
		    int size = sc.nextInt();
		    int k = sc.nextInt();
		    int arr[] = new int[size];
		    for(int j=0;j<size;j++){
		        arr[j] = sc.nextInt();
		    }
		    getMaxNum(arr, k, size);
		    System.out.println();
		}
	
}

public static void getMaxNum(int[] arr, int k, int size) {
	
	Deque<Integer> queue = new LinkedList<>();
	int i = 0;
	
	while(i<k) {
		
		while(!queue.isEmpty() && arr[queue.peekLast()]<=arr[i]) {
			queue.removeLast();
		}
		queue.addLast(i);
		i++;
	}
	
	while(i<size) {
		
		System.out.print(arr[queue.peek()]+" ");
		
		while(!queue.isEmpty() && queue.peek()<=(i-k)) {
			queue.poll();
		}
		
		while(!queue.isEmpty() && arr[queue.peekLast()]<=arr[i]) {
			queue.removeLast();
		}
		queue.add(i);
		i++;
	}
	System.out.print(arr[queue.peek()]);
}
	
}
