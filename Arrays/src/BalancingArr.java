import java.util.Scanner;

public class BalancingArr {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[N];
		
		for(int i=0;i<N;i++) {
			a[i] = sc.nextInt();
		}
		
		getNumber(a,N);
		
	}

	public static void getNumber(int[] nums, int n) {
		
		int[] leftOdd = new int[n], leftEven = new int[n];
        int[] rightOdd = new int[n], rightEven = new int[n];
        int odd = 0, even = 0;
        for(int i=0;i<n;i++){
            leftOdd[i] = odd;
            leftEven[i] = even;
            if(i%2==0) even += nums[i];
            else odd += nums[i];
        }
        odd = 0;
        even = 0;
        for(int i=n-1;i>=0;i--){
            rightOdd[i] = odd;
            rightEven[i] = even;
            if(i%2==0) even += nums[i];
            else odd += nums[i];
        }
		
        for(int i:leftOdd) {
        	System.out.println(i);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(leftOdd[i] + rightEven[i] == leftEven[i] + rightOdd[i]){
                System.out.println("id:" + i);
                count++;
            }
        }
    	System.out.println(count);
	}

}
