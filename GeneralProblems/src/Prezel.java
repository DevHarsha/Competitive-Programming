import java.util.Scanner;

public class Prezel {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t=0;t<T;t++) {
			String str = sc.nextLine();
			System.out.println(checkPrezel(str));
			
		}

	}

	private static String checkPrezel(String str) {
		
		int ones = (str.charAt(0)+str.charAt(4)+str.charAt(8)+str.charAt(10))%10;
		int three = ((str.charAt(1)+str.charAt(5)+str.charAt(9))*3)%10;
		int seven = ((str.charAt(2)+str.charAt(6))*7)%10;
		int nine = ((str.charAt(3)+str.charAt(7))*9)%10;
		
		if((ones+three+seven+nine)%10 == 0) {
			return "Yes";
		}
		
		return "No";
	}

}
