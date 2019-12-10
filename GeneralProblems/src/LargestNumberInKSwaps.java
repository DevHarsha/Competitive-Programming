import java.util.Scanner;
/* https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps/0 */

/*Given a number K and string S of digits denoting a positive integer,
 *  build the largest number possible by performing swap operations on the digits of S atmost K times.*/

public class LargestNumberInKSwaps {

	static String compValue = null;//String.valueOf(number);
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int k = sc.nextInt();
			sc.nextLine();
			String number = sc.nextLine();
			compValue = number;
			char num[] = number.toCharArray();
			getLargestNumber(num,k);
			System.out.println(compValue);
		}

	}

	public static void getLargestNumber(char [] number, int k) {
		
		int n = number.length;
		
		if(k==0)
			return;
		
		for(int i=0;i<n-1;i++) {
			
			for(int j=i+1;j<n;j++) {
				
				if(number[i]<number[j]){
	                 char temp = number[i];
	                 number[i] = number[j];
	                 number[j] = temp;
	                 String newVal = String.valueOf(number);
	                 
	                 if(newVal.compareTo(compValue)>0) {
	                	 compValue = newVal;
	                 }
	                 
	                 getLargestNumber(number, k-1);
	                 temp = number[i];
	                 number[i] = number[j];
	                 number[j] = temp;
	             }			
			}
			
		}
		
		
	}

}
