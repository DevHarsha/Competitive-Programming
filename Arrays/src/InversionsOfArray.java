import java.util.Scanner;

public class InversionsOfArray {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	   	 int T = sc.nextInt();
	   	 for(int i=0;i<T;i++){
	   	     int size = sc.nextInt();
	   	     int arr[] = new int[size];
	   	     for(int j=0;j<size;j++){
	   	         arr[j] = sc.nextInt();
	   	     }
	   	     System.out.println(getInversionsCount(arr,0,size-1));
	   	 }
		
	}

	private static int getInversionsCount(int[] arr, int l, int r) {
		
		int count = 0;
		
		if(l<r) {
			int mid = (l+r)/2;
			count += getInversionsCount(arr,l,mid);
			count += getInversionsCount(arr, mid+1, r);
			
			count += getMergeCount(arr,l,mid,r);
		}
		
		return count;
	}

	private static int getMergeCount(int[] arr, int l, int mid, int r) {
		
		int n1 = (mid-l)+1;
		int n2 = r-mid;
		
		int result = 0;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int p=0;p<n1;p++) {
			L[p] = arr[p+l];
		}
		for(int p=0;p<n2;p++) {
			R[p] = arr[mid+p+1];
		}
		
		int i=0,j=0,k=l;
		
		while(i<n1 && j<n2) {
			
			if(L[i]<=R[j]) {
				arr[k++] = L[i++];
			}else {
				arr[k++] = R[j++];
				result += (mid+1)-(l+i);
			}			
		}
		while (i < n1) 
            arr[k++] = L[i++]; 
  
        while (j < n2) 
            arr[k++] = R[j++];
		
		return result;
	}

}
