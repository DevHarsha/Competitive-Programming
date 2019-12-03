import java.util.Scanner;

public class Largest_palindrome_formed_product_of_two_Numbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {			
			int n = sc.nextInt();
			System.out.println(getLargestPalindrome(n));
			
		}

	}

	public static int getLargestPalindrome(int n) {
		
		int upper_limit = 0;
		int lower_limit = 1;
		
		int largest_palindrome = 0;
		
		for(int i=1;i<=n;i++) {
			upper_limit = upper_limit*10;
			upper_limit = upper_limit+9;
		}
		
		for(int i=2;i<=n;i++) {
			lower_limit = lower_limit*10;
		}
		
		
		for(int i=upper_limit;i>=lower_limit;i--) {
			
			for(int j=i;j>=lower_limit;j--) {
				
				int product = i*j;
				
				if(product<=largest_palindrome) {
					break;
				}
				
				if(checkPalindrome(product)) {
					//System.out.println(product);
					if(product>largest_palindrome) {
						largest_palindrome = product;
					}
				}
				
			}
			
		}
		return largest_palindrome;
	}

	public static boolean checkPalindrome(int prod) {
		
		int reverse = 0; 
        int product = prod;
        while (product != 0) 
        { 
            reverse = reverse * 10 + product % 10; 
            product /= 10; 
        } 
		
		return reverse==prod?true: false;
	}

}
