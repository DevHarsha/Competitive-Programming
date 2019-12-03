import java.util.Scanner;

public class Largest_Prime_Factor {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			
			int n = sc.nextInt();
			System.out.println(getLargestPrimeFactor(n));
			
		}

	}

	public static int getLargestPrimeFactor(int n) {
		
		if(n==0||n==1) {
			return n;
		}
		
		int largest_factor = Integer.MIN_VALUE;
		
		while(n%2==0) {
			n = n/2;
			largest_factor = 2;
		}
		
		for(int i=3;i<=Math.sqrt(n);i=i+2) {
			
			while(n%i==0) {
				n = n/i;
				largest_factor = i;
			}
			
		}
		
		if(n>2) {
			largest_factor = n;
		}
		
		return largest_factor;
	}

}
