/*A string is k palindrome if it can be transformed into a palindrome on removing at most k characters from it.
 *Your task is to complete the function is_k_palin which takes two arguments a string str and a number N .
 *Your function should return true if the string is k palindrome else it should return false.
 */

package basic;

import java.util.Scanner;

public class Is_K_Palindrome {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while(T>0)
		{
			String str1 = sc.nextLine();
			String arr[] = str1.split(" ");
			
			String str = arr[arr.length-2];
			int K = Integer.parseInt(arr[arr.length-1]);
			
            boolean b = is_k_palin(str,0,str.length()-1, K);
			if(b == true)
				System.out.println(1);
			else
				System.out.println(0);			
			
		T--;
		}

	}

	public static boolean is_k_palin(String str,int i,int j, int k) {
				
		
		while(i<j) {
		
			if(str.charAt(i)!=str.charAt(j)) {
				
				if(k>0) {
					return is_k_palin(str,i+1,j, k-1) || is_k_palin(str, i, j-1, k-1);
				}
				else {
					return false;
				}
				
			}
			i++;
			j--;
			
		}
		
		return true;
	}

}
