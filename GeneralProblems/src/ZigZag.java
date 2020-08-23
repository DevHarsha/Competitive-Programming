import java.util.Arrays;
import java.util.Scanner;

public class ZigZag {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<t;i++) {
			
			String input[] = sc.nextLine().split("\\s+");		
			printZigZag(input);
			
		}		
		
	}

	private static void printZigZag(String[] input) {
		
		char strArray[] = input[0].toCharArray();
		int n = Integer.parseInt(input[1]);
		int len = strArray.length;
		
		/*
		 * for(int i=0;i<strArray.length;i++) { System.out.print(strArray[i]); }
		 * 
		 * System.out.println();
		 */
		
		if(n<1) {
			return;
		}
		if(n==1) {
			System.out.println(String.valueOf(strArray));
			return;
		}
		
		String array[] = new String[n];
		Arrays.fill(array, "");
		
		int row = 0;
		boolean down = true;
		
		for(int i=0;i<len;i++) {
			
			array[row] += strArray[i];
			
			if(row==n-1) {
				down = false;
			}
			else if(row==0){
				down = true;
			}
			
			if(down) {
				row++;
			}
			else {
				row--;
			}
		}
		
		for(int j=0;j<n;j++) {
			
			System.out.print(array[j]);
			
		}
		
	}

}
