package NAryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*Given two n-ary tree's the task is to check if they are mirror of each other or not.*/
public class Check_If_Mirror {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int nodes = sc.nextInt();
			int edges = sc.nextInt();
			sc.nextLine();
			String first[] = sc.nextLine().toString().trim().split("\\s+");
			String second[] = sc.nextLine().toString().trim().split("\\s+");
			
			if(checkIfMirrors(first,second)) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}

	}

	public static boolean checkIfMirrors(String[] first, String[] second) {
		
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<first.length;i++) { stack.push(Integer.parseInt(first[i])); }
		for(int i=0;i<second.length;i++) { queue.add(Integer.parseInt(second[i])); }
		
		System.out.println(queue);
		System.out.println(stack);
		/*
		 * for(int i=0;i<first.length;i++) { stack.push(Integer.parseInt(first[i])); }
		 * for(int i=0;i<second.length;i++) { queue.add(Integer.parseInt(second[i])); }
		 * 
		 * while(!stack.isEmpty() && !queue.isEmpty()) {
		 * 
		 * System.out.println(stack.peek()+" "+queue.peek());
		 * if(stack.peek()!=queue.peek()) { return false; } queue.poll(); stack.pop(); }
		 */
		return true;
	}

}
