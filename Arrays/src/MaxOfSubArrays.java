
import java.util.*;

public class MaxOfSubArrays {

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
		}

	}

	private static void getMaxNum(int[] arr, int k, int n) {
		
		Deque<Integer> dque = new LinkedList<Integer>();
		
		for(int i=0;i<k;i++) {
			
			while(!dque.isEmpty() && arr[dque.peekLast()]<=arr[i] ) {
				dque.removeLast();
			}
			dque.addLast(i);
		}
		
		for(int i=k;i<n;i++) {
			
			System.out.print(arr[dque.peek()]+" ");
			
			while(!dque.isEmpty() && dque.peek()<=i-k) {
				dque.remove();
			}
			while(!dque.isEmpty() && arr[dque.peekLast()]<=arr[i]) {
				dque.removeLast();
			}
			dque.addLast(i);
		}
		System.out.print(arr[dque.peek()]);
	}

}
