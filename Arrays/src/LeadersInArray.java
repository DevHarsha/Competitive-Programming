import java.util.ArrayList;
import java.util.Scanner;

public class LeadersInArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int size = sc.nextInt();
			int arr[] = new int[size];
			
			for(int j=0;j<size;j++) {
				arr[j] = sc.nextInt();
			}
			getLeaders(arr,size);
			
		}
		
	}

	public static void getLeaders(int[] a, int n) {
		

	    int max = -1;
	    StringBuilder str = new StringBuilder();
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    for(int i=n-1;i>=0;i--){
	        
	        if(max<=a[i]){
	            list.add(a[i]);
	            max = a[i];
	        }
	        
	    }
	   
	    for(int i=list.size()-1;i>=0;i--){
	        str.append(list.get(i));
	        str.append(" ");
	    }
	    System.out.println(str);
		
	}

}
