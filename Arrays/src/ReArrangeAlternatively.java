import java.util.Scanner;
/*Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, 
 * second should be min value, third should be second max, fourth should be second min and so on...*/
public class ReArrangeAlternatively {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
   	 	int T = sc.nextInt();
   	 
   	 	for(int t=0;t<T;t++){
	   	    int n = sc.nextInt();    
	   	    int a[] = new int[n];
	   	    for(int i=0;i<n;i++){
	   	        a[i] = sc.nextInt();
	   	    }
	   	    System.out.println(getArray(a,n));
   	 	}

	}

	public static String getArray(int[] a, int n) {
		
		StringBuilder str = new StringBuilder("");
		
		int i=0,j=n-1;
		
		while(i<=j) {		
			
			if(i<j) {
				str.append(a[j]+" ");
				j--;
				str.append(a[i]+" ");
				i++;
			}else if(i==j){
				str.append(a[i]+" ");
				i++;
				j--;
			}
			else {
				return str.toString();				
			}
			
		}
		return str.toString();
	}

}
