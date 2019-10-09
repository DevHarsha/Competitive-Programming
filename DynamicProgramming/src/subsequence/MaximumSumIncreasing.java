package subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSumIncreasing {

	public static void main(String args[]) throws IOException {
		
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

	private static int getAnswer(int[] arr, int size) {
		
		int max[] = new int[size];
		max[0] = arr[0];
		
		for(int i=1;i<size;i++) {
			max[i] = arr[i];
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j] && max[i]<max[j]+arr[i]) {
					max[i] = max[j]+arr[i];
				}
			}
		}
		
		int max_i = 0;
		for(int i=0;i<size;i++){            
			if(max[i]>max_i){
                max_i = max[i];
            }
        }
		return max_i;
	}
}
