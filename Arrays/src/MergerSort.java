import java.util.Scanner;

public class MergerSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			
			int n = sc.nextInt();
			int arr[] = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			mergeSort(arr,0,n-1);
			
			for(int i=0;i<n;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}

	}

	public static void mergeSort(int[] arr, int l, int r) {
		
		
		
		
		if(l<r) {
			int mid = (l+r)/2;
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,r);
			
			mergeAlgorithm(arr,l,mid,r);
		}
		
	}

	public static void mergeAlgorithm(int[] arr, int l, int mid, int r) {
		
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
		
		while(i<n1 && j<n2) {
			
			if(L[i]<=R[j]) {
				arr[k++] = L[i++];
			}
			else {
				arr[k++] = R[j++];
			}
			
		}
		
		while(i<n1) {
			arr[k++] = L[i++];
		}
		while(j<n2) {
			arr[k++] = R[j++];
		}		
		
		
	}

}
