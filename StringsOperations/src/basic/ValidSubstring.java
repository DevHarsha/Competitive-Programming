package basic;

import java.util.Scanner;
import java.util.Stack;

/*Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid substring.*/
public class ValidSubstring {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t=0;t<T;t++) {
			String input = sc.nextLine();
			System.out.println(getLongestValidSubstring(input));
		}

	}

	private static int getLongestValidSubstring(String input) {
		
		int n = input.length();
		if(n==0 || n==1) {
			return 0;
		}
		
		Stack<Character> stack = new Stack<>();
		int max_length = Integer.MIN_VALUE;
		int max = 0;
		
		for(int i=0;i<n;i++) {
			
			if(input.charAt(i)=='(') {
				stack.push('(');
			}
			else if(input.charAt(i)==')') {
				
				if(stack.isEmpty()) {
					max=0;
				}
				else {
					char ch = stack.pop();
					if(ch=='(') {
						max++;
						//System.out.println(ch+" "+max);
						if(max>max_length) {
							max_length = max;
						}
					}
					else {
						max=0;
					}
					
				}				
			}
			
			
		}
		
		return max_length*2;
	}

}
