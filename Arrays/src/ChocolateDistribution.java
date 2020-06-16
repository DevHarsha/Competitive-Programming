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
			System.out.println(getMinDiff_practice(array,size,students));
			
		}

	}

	private static int getMinDiff_practice(int[] array, int size, int students) {
		
		Arrays.sort(array);
		int j = 0;
		int min_val = Integer.MAX_VALUE;
		
		if(students==0 || size==0) {
			return 0;
		}
		if(students>size) {
			return -1;
		}
		for(int i=0;i<=size-students;i++) {
			
			j = i+students-1;
			if( (array[j]-array[i]) < min_val) {
				min_val = array[j]-array[i];
			}
			
		}
		
		return min_val;
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
