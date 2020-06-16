import java.util.Scanner;

public class StockBuySell {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			stockBuySell(arr,n);
			System.out.println();
		}

	}

	public static void stockBuySell(int[] arr, int n) {
		
		int start = 0;
		int i = 0;
		boolean isPresent = false;
		
		while(i<n) {
			
			while(i<n-1 && arr[i]>=arr[i+1]) {
				i++;
			}
			
			if(i==n-1) {
				break;
			}
			start = i;
			isPresent = true;
			
			while(i<n-1 && arr[i+1]>=arr[i]) {
				i++;
			}
			System.out.print("("+start+" "+i+")"+" ");
		}
		if(!isPresent) {
			System.out.print("No Profit");
		}
	}

	

}
