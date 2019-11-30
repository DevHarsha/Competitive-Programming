import java.util.HashMap;
import java.util.Scanner;

/*Given an array of integers and a number k,
 * write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.*/
public class ArrayPairDivisibility {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for(int i=0;i<T;i++){
	        int n = sc.nextInt();
	        int a[] = new int[n];
	        for(int j=0;j<n;j++){
	            a[j] = sc.nextInt();
	        }
	        int k = sc.nextInt();
	        
	        if(checkDivisibility(a,n,k)){
	            System.out.println("True");
	        }
	        else{
	            System.out.println("False");
	        }
	    }

	}

	public static boolean checkDivisibility(int[] a, int n, int k) {
		
		HashMap<Integer,Integer> map = new HashMap<>();
		int zero_count = 0;
		
		if(n%2==1) {
			return false;
		}
		
		for(int i=0;i<n;i++) {
			
			int key = a[i]%k;
			
			if(key==0) {
				zero_count++;
				continue;
			}
			
			if(map.get(key)==null) {
				map.put(key,1);
			}
			else {
				map.put(key,map.get(key)+1);
			}			
			
		}
		if(zero_count%2!=0) {
			return false;
		}
		
		
		for(int i=0;i<n;i++) {
			
			int checkKey = a[i]%k;
			
			if(checkKey==0) {
				continue;
			}
			
			if(checkKey==(k-checkKey)) {
			
				if(map.get(checkKey)%2!=0) {
					return false;
				}
				
			}else {
				
				if(map.get(checkKey)!=map.get(k-checkKey)) {
					return false;
				}
				
			}
			
		}
		
		
		return true;
	}

}



