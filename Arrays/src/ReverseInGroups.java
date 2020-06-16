import java.util.Scanner;

public class ReverseInGroups {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			reverseInGroups(a,k,n);
			//System.out.println();
		}

	}

	public static void reverseInGroups(int[] a, int k, int n) {
		
		int i = 0, j = 0;
		//int reverse[] = new int[n];
		int size = 0;
		StringBuilder str = new StringBuilder("");
		
		while(i<n) {
			
			j = i+k;
			if(j>=n) {
				j = n-1;
			}else {
				j = j-1;
			}
			while(j>=i) {
				//reverse[size++] = a[j--];
				str.append(a[j--]);
			}
			i = i+k;
		}
		System.out.println(str.toString());
		/*
		 * for(int ele:reverse) { System.out.print(ele+" "); }
		 */
		
	}

}
