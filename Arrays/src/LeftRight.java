import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.*/
public class LeftRight {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //Time limit exception when Scanner is used
	    int T = Integer.parseInt(br.readLine());
	    
	    for(int i=0;i<T;i++){
	        
	        int N = Integer.parseInt(br.readLine());
	        String line[] = br.readLine().trim().split("\\s+");
	        int array[] = new int[N];
	        
	        for(int j=0;j<N;j++){
	            array[j] = Integer.parseInt(line[j]);
	        }
	        System.out.println(getAnswer(array,N));
	    }

	}

	public static int getAnswer(int[] a, int n) {
		
		int left[] = new int[n];
		int right[] = new int[n];
		left[0] = a[0];
		right[n-1] = a[n-1];
		int max = Integer.MAX_VALUE;
		
		for(int i=1;i<n;i++) {
			
			left[i] = Math.max(a[i], left[i-1]);
			
		}
		for(int j=n-2;j>=0;j--) {
			right[j] = Math.min(a[j], right[j+1]);
		}
		
		for(int i=1;i<n-1;i++) {
			//System.out.println(left[i]+" "+right[i]);
			if(left[i]==right[i]) {
				
				return left[i];
			}
		}
		return -1;
	}

}
