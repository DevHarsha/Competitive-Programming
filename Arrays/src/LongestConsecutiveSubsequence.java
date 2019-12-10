import java.util.Arrays;
import java.util.Scanner;

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int j=0;j<n;j++) {
				a[j] = sc.nextInt();
			}
			System.out.println(getLongestSeq(a,n));
		}
		
	}

	public static int getLongestSeq(int[] a, int n) {
		
		int result = 1;
		
		Arrays.sort(a);
		
		int count = 1;
		
		for(int i=1;i<n;i++) {
			
			
			while(i<n && (a[i-1]==(a[i]-1))) {
				i++;
				// when we have duplicates, we should just skip them instead of counting
				while(i<n && (a[i-1]==a[i])){
				    i++;
				}
				count++;
			}
			if(result<count) {
				result = count;				
			}
			count = 1;
		}
		
		
		return result;
	}

}
