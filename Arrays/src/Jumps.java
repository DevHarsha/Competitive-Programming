import java.util.Scanner;

public class Jumps {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int a[] = new int[N];
		for(int i=0;i<N;i++) {
			a[i] = sc.nextInt();
			
		}
		
		System.out.println(getJumps(a,K,N));
	}

	public static int getJumps(int[] a, int k, int n) {
		
		
		boolean isZero = true;
		boolean isNeg = true;
		
		for(int i=0;i<n;i++) {
			
			if(a[i]>0) {
				isNeg = false;
			}
			if(a[i]!=0) {
				isZero = false;
			}
			
		}
		if(isNeg) {
			return -1;
		}
		if(isZero) {
			if(n%k==0) {
				return n/k;
			}
			else {
				return n/k+1;
			}			
		}
		
		int i=0;
		int jumps = 0;
		int max_val = 0;
		int index = 0;
		
		while(i<n) {
			
			System.out.println("hey");
			boolean isFlag = false;
			max_val = 0;
			
			if(i+k>=n-1) {
				System.out.println("NO of j"+jumps);
				return jumps+1;
			}
			
			for(int j=i;j<i+k;j++) {
				
				if(a[j]>=0) {
					
					if(j+a[a[j]]>=max_val) {
						max_val = j+a[a[j]];
						index = j+a[a[j]];
						isFlag = true;
					}
					
				}
				
				if(isFlag) {
					jumps++;
				}
				
			}
			if(max_val>=n-1) {
				
				return jumps;
			}
			i = index;
		}
		
		
		return jumps;
		
		
	}

}
