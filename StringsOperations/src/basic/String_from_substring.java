package basic;

import java.util.Scanner;
/*Given a string ‘str’, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
 * For example "abab" can be created by appending "ab" to "ab", but "abac" cannot be created by appending a substring to itself.
 * */
public class String_from_substring {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	   	 int T = sc.nextInt();
	   	 sc.nextLine();
	   	 for(int i=0;i<T;i++){
	   	     String str = sc.nextLine();
	   	     if(isStringPossible(str)){
	   	         System.out.println("True");
	   	     }else{
	   	         System.out.println("False");
	   	     }
	   	}

	}
   /* Replace the substrings that are to be repeated with empty strings, if the resulting is empty string then true else false */
	public static boolean isStringPossible(String str) {
		
		int n = str.length();
	     
	     if(n==0 || n==1){
	         return false;
	     }
	     for(int i=1;i<str.length();i++){
	         
	         String sub=str.substring(0,i);
	         if(str.replace(sub,"").length()==0){
	             return true;
	         }
	         
	     }
		return false;
	}

}
