package basic;

import java.util.Scanner;

public class MultiplyStrings {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();            
            System.out.println(multiply(a,b));
        }
		
	}
	public String multiplyUtil(String a,String b){
	        
	        char first_a = a.charAt(0);
	        char first_b = b.charAt(0);
	        boolean isNeg = false;
	        if ((first_a=='-' || first_b=='-')&&
	            (first_a!='-' || first_b!='-')){
	                //System.out.print('-');
	                isNeg = true;
	            }
	        if(first_a=='-' && first_b=='-'){
	            a = a.substring(1);
	            b = b.substring(1);
	        }else if(first_a!='-' && first_b=='-'){
	            b = b.substring(1);
	        }else if(first_a=='-' && first_b!='-'){
	            a = a.substring(1);
	        }
	        
	        String str = multiply(a,b);
	        if(isNeg && !str.equals("0")){
	            return "-"+str;
	        }
	        return str;
	    }
	public static String multiply(String a, String b) {
		
		int n1 = a.length();
		int n2 = b.length();
		
		int len1 = 0;
		int len2 = 0;
		
		
		int result[] = new int [n1+n2];
		
		for(int i=n1-1;i>=0;i--) {
			
			int carry = 0;
			int num1 = a.charAt(i)-'0';
			len2 = 0;
			for(int j=n2-1;j>=0;j--) {
				
				int num2 = b.charAt(j)-'0';
				
				int sum = num1*num2 + result[len1+len2] + carry ;
				
				sum = sum%10;
				carry = sum/10;
				result[len1+len2] = sum;
				len2++;
			}
			if(carry>0) {
				result[len1+len2] += carry;
			}
			len1++;
			
		}
		int i=result.length-1;
        while(i>=0 && result[i]==0){
            i--;
        }
        if(i==-1){
            return "0";
        }
        
        /*for(int k=0;k<length;k++){
            System.out.print(result[k]+" ");
        }
        System.out.println();*/
        String ans = "";
        
        while(i>=0){
            ans += (result[i--]);
        }
        
        return ans;
	}

}
