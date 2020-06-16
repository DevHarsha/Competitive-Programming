import java.util.Scanner;
/*or an integer n find number of trailing zeroes in n! . */
public class TrailingZeroes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			getNumberZeores(n);
		}

	}
	
	//Trailinf zeroes in n! can be counted by ( n/5 + n/25 + n/125 + .....) since 5*2 = 10 which results in zeros
	
	public static void getNumberZeores(int n) {
		
		int zeroes = 0;
		
		for(int i=5;n/i>=1;i=i*5) {
			zeroes += n/i;
		}
		System.out.println(zeroes);
	}

}
