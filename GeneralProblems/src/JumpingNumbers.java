/*Given a positive number X. Find all Jumping Numbers smaller than or equal to X. 
  Jumping Number: A number is called Jumping Number if all adjacent digits in it differ by only 1. 
  All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JumpingNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	   	int T = sc.nextInt();
	   	for(int i=0;i<T;i++){
	   	    int num = sc.nextInt();
	   	    getJumpingNumber(num);
	   	    System.out.println();
	   	}

	}
	
	public static void getJumpingNumber(int num) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		for(int i=1;i<=9 && i<=num;i++) {
			getJumpingNumbersUtil(num,i,list);
		}
		Collections.sort(list);
		for(int val:list) {
			System.out.print(val+" ");
		}
		
	}

	public static void getJumpingNumbersUtil(int num, int i,ArrayList<Integer> list) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		while(!queue.isEmpty()) {
			
			int k = queue.peek();
			queue.poll();
			
			if(k<=num) {
				
				int modulo = k%10;
				
				if(modulo==0) {
					queue.add(k*10+(modulo+1));
				}
				else if(modulo==9) {
					queue.add(k*10+(modulo-1));
				}
				else {
					queue.add(k*10+(modulo+1));
					queue.add(k*10+(modulo-1));
				}
				list.add(k);
			}
			
		}
		
	}

}
