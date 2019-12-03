import java.util.Scanner;

/*Given 2 sorted arrays A and B of size N each. Print sum of middle elements of the array obtained after merging the given arrays.*/
public class Sum_of_middle_elemts_in_sortedArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			
			int n = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[n];
			
			for(int j=0;j<n;j++) {
				a[j] = sc.nextInt();
			}
			for(int j=0;j<n;j++) {
				b[j] = sc.nextInt();
			}
			getMiddleElementsSum(a,b,n);
		}

	}

	public static void getMiddleElementsSum(int[] a, int[] b, int n) {
		
		int i=0,j=0;
		
		int curr = 0,prev = 0;
		
		int mid = n;
		int index = 0;
		int result = 0;
		
		while(index<=n) {
			
			if(a[i]<=b[j]) {
				prev = curr;
				curr = a[i];
				i++;
			}else {
				
				prev = curr;
				curr = b[j];
				j++;
				
			}
			index++;
			if(i==n) {
				//result = (curr+b[j]);
				prev = curr;
				curr = b[j];
				break;
			}else if(j==n) {
				//result = a[i]+curr;
				prev = curr;
				curr = a[i];
				break;
			}
			
		}
		
		System.out.println(prev+curr);
	}

}
