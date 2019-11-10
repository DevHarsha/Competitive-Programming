import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistribution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			
			int size = sc.nextInt();
			int array[] = new int[size];
			
			for(int j=0;j<size;j++) {				
				array[j] = sc.nextInt();
			}
			int students = sc.nextInt();
			System.out.println(getMinDiff(array,size,students));
		}

	}

	public static int getMinDiff(int[] array, int size, int students) {
		
		if(size==0 || students==0) {
			return 0;
		}
		if(size<students) {
			return -1;
		}
		Arrays.sort(array);
		
		int min_val = Integer.MAX_VALUE;
		int start = 0,end = 0;
		
		for(int i=0;i+students-1<size;i++) {
			
			int diff = array[i+students-1]-array[i];
			if(diff < min_val) {
				
				min_val = diff;
				start = i;
				end = i+students-1;
					
			}
			
		}	
		
		return min_val;
		
	}

}
