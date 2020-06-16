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
			trappingRainWater(arr,size); //Practice V 2.0
			trappingRainWater_optimized(arr,size); // Practice v 2.0
		}
	}

	public static void trappingRainWater_optimized(int[] arr, int size) {
		
		int start = 0, end = size-1;
		int left_max = Integer.MIN_VALUE;
		int right_max = Integer.MIN_VALUE;
		int result = 0;
		
		while(start<end) {
			
			if(arr[start] <= arr[end]) {
				
				if(left_max <= arr[start]) {
					left_max = arr[start];
				}
				else {
					result += (left_max-arr[start]);
				}
				start++;
			}
			else {
				
				if(right_max<=arr[end]) {
					right_max = arr[end];
				}
				else {
					result += (right_max-arr[end]);
				}
				end--;
			}
			
		}
		System.out.println(result);
		
	}

	public static void trappingRainWater(int[] arr, int size) { // Un-optimized method
		
		int left_sofar[] = new int[size];
		int right_sofar[] = new int[size];
		
		left_sofar[0] = arr[0];
		right_sofar[size-1] = arr[size-1];
		
		for(int i=1;i<size;i++) {
			left_sofar[i] = Math.max(left_sofar[i-1], arr[i]);
		}
		for(int j=size-2;j>=0;j--) {
			right_sofar[j] = Math.max(right_sofar[j+1], arr[j]);
		}
		
		int result = 0;
		int count = 0;
		
		for(int i=0;i<size;i++) {
			
			count = Math.min(left_sofar[i], right_sofar[i]);
			result += Math.abs((count-arr[i])); 
			
		}
		System.out.println(result);
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
