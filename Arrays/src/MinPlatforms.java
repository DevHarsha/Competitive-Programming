import java.util.Arrays;
import java.util.Scanner;

public class MinPlatforms {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			
			int n = sc.nextInt();
			int arr[] = new int[n];
			int dep[] = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=0;i<n;i++) {
				dep[i] = sc.nextInt();
			}
			
			minPlatforms(arr,dep,n);
		}

	}

	public static void minPlatforms(int[] arr, int[] dep, int n) {
		
		int platforms = 1;
		int min_platforms = 0;
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i=0, j=1;
		
		while(i< n && j<n) {
			
			if(arr[j]<=dep[i]) {
				platforms++;
				if(platforms>min_platforms) {
					min_platforms = platforms;
				}
				j++;
			}else {
				platforms--;
				i++;
			}
			
		}
		System.out.println(min_platforms);
	}

}
