import java.util.Scanner;

/*  Consider a 2d plane and  a Robot which is located at (0,0) who can move only one unit step at a time in any direction  
 *  ie if its initial position is (x,y)  he can go to positions (x + 1, y), (x - 1, y), (x, y + 1) or (x, y - 1).
 *  Now Given three integers a,b (denoting the final position where the robot has
 	to reach)  and x (denoting the steps in which he has to reach).*/

public class FinalDestination {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
   	 	int T = sc.nextInt();
	   	for(int i=0;i<T;i++){
	   	   int x = sc.nextInt();
	   	    int y = sc.nextInt();
	   	    int D = sc.nextInt();
	   	    getAnswer(x,y,D);
	   	}
		
	}

	private static void getAnswer(int x, int y, int d) {
		
		int result = Math.abs(x)+Math.abs(y);
	     
	    if(result > d){
	    	System.out.println(0);
	    }
	    else{
	    	if((d-result)%2==0)
	    		System.out.println(1);
   	     	else
   	     		System.out.println(0);   
	    }
		
	}

}
