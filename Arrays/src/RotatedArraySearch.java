import java.util.Scanner;

public class RotatedArraySearch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int size = sc.nextInt();
			int arr[] = new int[size];
			for(int j=0;j<size;j++) {
				arr[j] = sc.nextInt();
			}
			int key = sc.nextInt();
			getIndex(arr,size,key);
			
		}

	}

	



	public static void getIndex(int[] arr, int size, int key) {
		
		int pivot = getPivot(arr,0,size-1); // Using quicksort concept
		//System.out.println(pivot);
		
		int index = getIndexUtil(arr,0,size-1,key); //First time
		System.out.println(index);
		
		int answer = getIndexPracticeUtil(arr,0,size-1,key); // Practice method
		System.out.println(answer);
		
		
		
	}
	
	
	public static int getIndexPracticeUtil(int[] arr, int start, int end, int key) {
		
		int mid = (start+end)/2;
		
		if(end<start) {
			return -1;
		}
		if(arr[mid]==key) {
			return mid;
		}
		
		if(arr[start]<=arr[mid] ) {
			
			if(key<arr[mid] && key>=arr[start])
				return getIndexPracticeUtil(arr, start,mid, key);
			else
				return getIndexPracticeUtil(arr, mid+1, end, key);
		}
		
		if(key>arr[mid] && key<=arr[end]) {
			return getIndexPracticeUtil(arr, mid+1, end, key);
		}
		else {
			return getIndexPracticeUtil(arr, start, mid-1, key);
		}
		
	}
	

	public static int getIndexUtil(int[] arr, int st, int end, int key) {
		
		int mid = (st+end)/2;
		
		if(end<st) {
			return -1;
		}
		if(arr[mid]==key) {
			return mid;
		}		
		
		if(arr[st]<=arr[mid]) {
			
			if(key>=arr[st] && key<arr[mid]) {
				return getIndexUtil(arr,st,mid-1,key);
			}
			else {
				return getIndexUtil(arr,mid+1,end,key);
			}
			
			
		}
		
		if(key >= arr[mid] && key <= arr[end]) {
			return getIndexUtil(arr,mid+1,end,key);
		}else {
			return getIndexUtil(arr,st,mid-1,key);
		}
		
		/*
		 * if(arr[mid]<key) { return getIndexUtil(arr,mid+1,end,key); } else
		 * if(arr[mid]==key) { return mid; } else { return getIndexUtil(arr,st,mid,key);
		 * }
		 */			
		
	}

	public static int getPivot(int[] arr,int st, int end) {
		
		if(st==end) {
			return arr[st];
		}
		
		int mid = (st+end)/2;
		
		if(arr[mid]<arr[st]) {
			if(arr[mid+1]<arr[mid]) {
				return arr[mid];
			}else {
				return getPivot(arr,st,mid);
			}
			
		}else {
			if(arr[mid+1]>arr[mid]) {
				return getPivot(arr,mid+1,end);
			}
			else {
				return arr[mid];
			}
		}
		
		
	}

}
