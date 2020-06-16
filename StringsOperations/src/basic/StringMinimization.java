package basic;

import java.util.Scanner;

public class StringMinimization {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String string  = sc.nextLine();
		
		System.out.println(minimizeString(string));

	}

	public static String minimizeString(String string) {
		
		int n = string.length();
		int mid = n/2;
		System.out.println(string);
		if(n==1) {
			return string;
		}
		if(n==2) {
			if(string.charAt(0)==string.charAt(1)) {
				return "";
			}
			return string;
		}
		
		if(string.charAt(0)!=string.charAt(n-1)) {
			return string;
		}
		
		int i=0,j=n-1;
		
		System.out.println(i+" "+j);
		
		boolean flag = true;
		boolean isEqual = true;
		char ch = ' ';
		while( i<j ) {
			
			if(string.charAt(i)==string.charAt(j)) {
				if(flag) {
					ch = string.charAt(i);
					flag = false;
				}
				else {
					if(string.charAt(i)!=ch) {
						isEqual = false;
					}
				}
			}
			else {
				break;
			}
			System.out.println(string.charAt(i)+" "+string.charAt(j));
			i++;
			j--;
			
		}
		
		if(isEqual) {
			
			while( i<mid && string.charAt(i)==ch) {
				i++;
			}
			
			while(j>0 && string.charAt(j)==ch) {
				j--;
			}
			
		}
		
		
		String first = string.substring(i, mid);
		String second = string.substring(mid, j+1);
		
		System.out.println(first+" "+second);
		
		String appended = new StringBuilder(second).append(first).toString();
		
		
		
		return minimizeString(appended);
	}

}
