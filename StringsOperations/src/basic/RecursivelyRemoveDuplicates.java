package basic;

import java.util.Scanner;

public class RecursivelyRemoveDuplicates {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t=0;t<T;t++) {
			
			String string = sc.nextLine();
			System.out.println(recurRemove(string,string.length()));
			
		}

	}

	public static String recurRemove(String string, int length) {
		
		boolean flag = true;
		int start = 0;
		
		if(length==0 || length==1) {
			return string;
		}
		
		for(int i=1;i<length;i++) {
			
			flag = true;
			while(i<length && string.charAt(i)==string.charAt(i-1)) {

				if(flag) {
					start = i-1;
					flag = false;
				}
				i++;
				
			}
			if(!flag) {
				string = string.substring(0,start)+string.substring(i,length);
				length = string.length();
				i = start;
			}
			
		}
		
		for(int i=1;i<length;i++) {
			
			if(string.charAt(i)==string.charAt(i-1)) {
				recurRemove(string, length);
			}
			
		}
		
		return string;
	}

}
