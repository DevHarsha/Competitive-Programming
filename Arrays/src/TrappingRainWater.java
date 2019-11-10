import java.util.*;

/* Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|__|
*/
public class TrappingRainWater {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int size = sc.nextInt();
			int arr[] = new int[size];
			
			for(int j=0;j<size;j++) {
				arr[j] = sc.nextInt();
			}
			getWaterQuantity(arr,size);
			
		}
	}

	private static void getWaterQuantity(int[] arr, int size) {
		
		int start = 0;
		int end = size-1;
		
		int max_left = 0,max_right = 0;
		int result = 0;
		
		while(start<end) {
			
			if(arr[start]<arr[end]) {
				
				if(arr[start]>max_left) {
					max_left = arr[start];
				}else {
					result = result + (max_left-arr[start]);
				}
				start++;
			}else {
				
				if(arr[end]>max_right) {
					max_right = arr[end--];
				}else {
					result = result+(max_right-arr[end]);
				}
				end--;
			}
			
		}		
		System.out.println(result);
	}

}
