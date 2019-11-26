package general;
import java.util.Arrays;
import java.util.HashSet;
// Given an input string and a dictionary of words,
// find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
import java.util.Scanner;
import java.util.Set;
 
public class WordBreak {
	
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.hasNextLine();
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			sc.nextLine();
			String words = sc.nextLine();			
			String dict[] = words.split("\\s+");
			String input = sc.nextLine();
			
			for(int j=0;j<dict.length;j++) {
				set.add(dict[j]);
			}
			/* System.out.println(set); */
			boolean result = getAnswer(input);
			boolean dpResult = wordBreak(input);
			if(dpResult) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
			set.clear();
		}
	}
	public static boolean wordBreak(String input) {
		
		int len = input.length();
		boolean dp[] = new boolean[len+1];
		Arrays.fill(dp, false);
		if(len==0) {
			return true;
		}
		
		for(int i=1;i<=len;i++) {
			
			if(set.contains(input.substring(0,i)) && !dp[i]) {
				dp[i] = true;
			}
			if(dp[i]) {
				
				if(i==len) {
					return true;
				}
				
				for(int j=i+1;j<=len;j++) {
					
					if(!dp[j] && set.contains(input.substring(i,j))) {
						dp[j] = true;
					}
					
					if(j==len && dp[j]) {
						return true;
					}
					
				}
				
			}			
			
		}
		
		return false;
	}
	//Easy solution
	public static boolean getAnswer(String input) {
		
		int len = input.length();
				
		if(len==0) {
			return true;
		}
		
		for(int i=1;i<=len;i++) {
			
			if(set.contains(input.substring(0,i)) && getAnswer(input.substring(i,len))) {
				return true;
			}
			
		}
		return false;
		
	}

	
	
}
