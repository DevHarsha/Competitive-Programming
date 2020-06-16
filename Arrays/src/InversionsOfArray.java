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

	public static int getInversionsCount(int[] arr, int i, int j) {
		
		int count = 0;
		
		if(i<j) {
			
			int mid = (i+j)/2;
			count = count+getInversionsCount(arr,i,mid);
			count = count+getInversionsCount(arr,mid+1,j);
					
			count = count + getMergeInvCount(arr,i,mid,j);
		}
		return count;
	}

	public static int getMergeInvCount(int[] arr, int l, int mid, int r) {
		
		int n1 = mid+1-l;
		int n2 = r-mid;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int i=0;i<n1;i++) {
			L[i] = arr[l+i];
		}
		for(int j=0;j<n2;j++) {
			R[j] = arr[mid+j+1];
		}
		
		int i=0,j=0,k=l;
		int inversions = 0;
		
		while(i<n1 && j<n2) {
			
			if(L[i]<=R[j]) {
				arr[k++] = L[i++];
			}
			
			else{
				arr[k++] = R[j++];
				inversions += ((mid+1)-(l+i));  // No of elements including L[i] element which is bigger than R[j]
			}
		}
		
		while(i<n1) {
			arr[k++] = L[i++];
		}
		while(j<n2) {
			arr[k++] = R[j++];
		}
		return inversions;
	}

	
}
