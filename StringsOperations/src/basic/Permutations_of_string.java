package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*Given a string S. 
 * The task is to print all permutations of a given string. For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.*/
public class Permutations_of_string {
	
	static ArrayList<String> list = new ArrayList<>();

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	   	 int T = sc.nextInt();
	   	 sc.nextLine();
	   	 for(int t=0;t<T;t++){
	   	     String input = sc.nextLine();
	   	     
	   	     //getPermutations(input,0,input.length()-1);
	   	     getPermutationsPractice(input,0,input.length()-1);
	   	     
	   	     Collections.sort(list);
	   	     for(String entry : list) {
	   	    	 System.out.print(entry+" ");
	   	     }
	   	     list.clear();
	   	     System.out.println();
	   	 }

	}

	public static void getPermutationsPractice(String input, int st, int end) { //Practice method
		
		if(st<end) {
			return;
		}
		if(st==end) {
			list.add(input);
		}
		
		for(int i=st;i<=end;i++) {
			input = swap(input,st,i);
			getPermutations(input, st+1, end);
			input = swap(input,st,i);
		}
		
	}

	private static void getPermutations(String in,int st,int end) {
		
		if(st==end){
	         list.add(in);
	         return;
	     }
		for(int i=st;i<=end;i++){
	         
	         in = swap(in,st,i);
	         getPermutations(in,st+1,end);
	         in = swap(in,st,i);
	         
	     }
	}

	private static String swap(String in, int st, int end) {
		
		char arr[] = in.toCharArray();
		char c = arr[st];
		arr[st] = arr[end];
		arr[end] = c;
		
		return String.valueOf(arr);
	}

}
