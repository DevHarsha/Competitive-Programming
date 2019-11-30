import java.util.Arrays;
import java.util.Scanner;

/*Consider a big party where a log register for guest’s entry and exit times is maintained. 
 * Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.*/
public class MaximumIntervals {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			int a[] = new int[n];
			int d[] = new int[n];
			for(int j=0;j<n;j++) {
				a[j] = sc.nextInt();
			}
			for(int j=0;j<n;j++) {
				d[j] = sc.nextInt();
			}
			
			getMaximumIntervals(a,d,n);
		}
		
	}

	public static int getMaximumIntervals(int[] a, int[] d, int n) {
		
		Arrays.sort(a);
		Arrays.sort(d);
		
		int max_guests = 0;
		int guests = 1;
		
		int i=1,j=0;
		int val = 0;
				
		while(i<n && j<n){
			
			if(a[i]<=d[j]) {
				guests++;
				
				if(max_guests<guests) {
					max_guests = guests;
					val = a[i];
				}
				i++;				
				
			}
			else {
				guests--;
				j++;
			}
			
			
		}
		System.out.println(max_guests+" "+val);
		return max_guests;
		
	}

}
