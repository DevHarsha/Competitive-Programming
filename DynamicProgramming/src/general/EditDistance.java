
/*Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
	Insert
	Remove
	Replace
All of the above operations are of cost=1.
Both the strings are of lowercase.
*/


package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EditDistance
 {
	public static void main (String[] args) throws IOException
	 {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 int T = Integer.parseInt(br.readLine());
    	 
    	 for(int t=0;t<T;t++){
    	    String line[] = br.readLine().trim().split("\\s+");
    	    int N = Integer.parseInt(line[0]);
    	    int M = Integer.parseInt(line[1]);
    	    String input[] = br.readLine().trim().split("\\s+");
    	    System.out.println(getAnswer(input[0],input[1],N,M));
    	 }
	 }
	 public static int getMin(int x,int y,int z){
	     
	     if(x<y && x<z){
	         return x;
	     }else if(y<x && y < z){
	         return y;
	     }else{
	         return z;
	     }
	 }
	 public static int getAnswer(String s1,String s2,int n,int m){
	     //System.out.println(s1+" "+s2+" "+n+" "+m);
	     int dp[][] = new int[n+1][m+1];
	     
	     for(int i=0;i<=n;i++){
	         for(int j=0;j<=m;j++){
	             
	             if(i==0){
	                 dp[i][j] = j;
	             }
	             else if(j==0){
	                 dp[i][j] = i;
	             }
	             else if(s1.charAt(i-1)==s2.charAt(j-1)){
	                 dp[i][j] = dp[i-1][j-1];
	             }else{
	                 dp[i][j] = 1+getMin(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
	             }
	             
	         }
	     }
	     return dp[n][m];
	 }
}