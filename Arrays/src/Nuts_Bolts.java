import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/*Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.
Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.
* */

public class Nuts_Bolts {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	   	 int T = sc.nextInt();
	   	 for(int i=0;i<T;i++){
	   	     int n = sc.nextInt();
	   	     sc.nextLine();
	   	     String nuts = sc.nextLine();
	   	     String bolts = sc.nextLine();
	   	     //getAnswer(nuts,bolts,n);
	   	     betterSolution(nuts,bolts,n);
	   	     System.out.println();
	   	 }

	}

	
	public static void betterSolution(String nuts, String bolts, int n) {
		
		 String nts[] = nuts.split("\\s+");
	     String blts[] = bolts.split("\\s+");
	     
	     ArrayList<String> nutsList = new ArrayList<>();
	     ArrayList<String> boltsList = new ArrayList<>();
	     
	     for(int i=0;i<n;i++){
	         nutsList.add(nts[i]);
	         boltsList.add(blts[i]);
	     }
	     
	     Collections.sort(nutsList);
		
		for(int i=0;i<n;i++) {
			if(!boltsList.contains(nutsList.get(i))) {
				nutsList.remove(i);				
			}
		}
		Iterator<String> it = nutsList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
	     it = nutsList.iterator();
	     while(it.hasNext()){
	         System.out.print(it.next()+" ");
	     }
	}

	/* Sort the characters, that is as per Ascii table and then check whether there exist entries in both nuts and bolts. print only those in order which exist*/
	public static void getAnswer(String nuts, String bolts, int n) {
		
		 String nts[] = nuts.split("\\s+");
	     String blts[] = bolts.split("\\s+");
	     
	     ArrayList<String> nutsList = new ArrayList<>();
	     ArrayList<String> boltsList = new ArrayList<>();
	     
	     for(int i=0;i<n;i++){
	         nutsList.add(nts[i]);
	         boltsList.add(blts[i]);
	     }
	     
	     Collections.sort(nutsList);
	     
	     Iterator<String> it = nutsList.iterator();
	     while(it.hasNext()){
	         
	         if(!boltsList.contains(it.next())){
	             it.remove();
	         }
	         
	     }
	     
	     it = nutsList.iterator();
	     while(it.hasNext()){
	         System.out.print(it.next()+" ");
	     }
	     System.out.println();
	     it = nutsList.iterator();
	     while(it.hasNext()){
	         System.out.print(it.next()+" ");
	     }
		
	}

}
