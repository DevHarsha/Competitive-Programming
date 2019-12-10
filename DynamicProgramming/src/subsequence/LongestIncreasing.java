package subsequence;
/*Given a sequence A of size N, find the length of the longest increasing subsequence from a given sequence .
The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, 
lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.*/
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasing {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   	 int T = Integer.parseInt(br.readLine());
	   	 for(int i=0;i<T;i++){
	   	    int size = Integer.parseInt(br.readLine());
	   	    int arr[] = new int[size];
	   	    String input = br.readLine();
	   	    String elements[] = input.trim().split("\\s+");
	   	    for(int j=0;j<size;j++){
	   	        arr[j] = Integer.parseInt(elements[j]);
	   	    }
	   	    System.out.println(getAnswer(arr,size));	   	    
	   	 }
	}

	static int getAnswer(int[] arr, int size) {
		
		int temp[] = new int[size];
		int max = Integer.MIN_VALUE;
		Arrays.fill(temp, 1);
		
		for(int i=1;i<size;i++) {
			for(int j=0;j<i;j++) {
				if((arr[i] > arr[j]) && temp[i]< temp[j]+1) {
					temp[i] = temp[j]+1;
				}
			}
		}		
		for(int i=0;i<size;i++) {
			if(max<temp[i]) {
				max = temp[i];
			}
		}		
		return max;
	}

}
