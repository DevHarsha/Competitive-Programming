import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
 * Find all possible words that can be formed by a sequence of adjacent characters*/


//-------------------------------------------------------------------/*Approach*/-----------------------------------------------------------------\\

/*The idea is to consider every character as a starting character and find all words starting with it. All words starting from a character can be found using Depth First Traversal.
  We do depth first traversal starting from every cell.
  We keep track of visited cells to make sure that a cell is considered only once in a word.
*/

public class WordBoggle {

	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    
	    for(int t=0;t<T;t++){
	    	
    	    int size = Integer.parseInt(br.readLine());
    	    
    	    String words[] = br.readLine().toString().split("\\s+");
    	    String indexes[] = br.readLine().toString().split("\\s+");
    	    
    	    int n = Integer.parseInt(indexes[0]);
    	    int m = Integer.parseInt(indexes[1]);
    	    
    	    char arr[][] = new char[n][m];
    	    String chars[] = br.readLine().toString().split("\\s+");
    	    int k=0;
    	    
    	    for(int i=0;i<n;i++){
    	    	
    	        for(int j=0;j<m;j++){
    	        	
    	            arr[i][j] = chars[k].charAt(0);
    	            k++;
    	            
    	        }
    	    }
    	    for(int i=0;i<words.length;i++){    	        
    	        set.add(words[i]);
    	    }
    	    getWords(arr,n,m);
    	    System.out.println();
	    }
			
	}
	public static void getWords(char[][] a, int n, int m) {
		
		boolean visited[][] = new boolean[n][m];
		String str = "";
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				
				getWordsUtil(a,i,j,n,m,visited,str);
				
			}
			
		}
		
	}
	public static void getWordsUtil(char[][] a, int i, int j, int n, int m,boolean visited[][],String str) {
		
		visited[i][j] = true;
		str = str+a[i][j];
		
		if(set.contains(str)) {
			System.out.println(str);
		}
		
		for(int row=i-1;row<= i+1 && row<n ; row++) {
			
			for(int col = j-1; col<= j+1 && col< m;col++) {
				
				if((row >= 0 && col >= 0) && !visited[row][col] ) {
					getWordsUtil(a,row,col,n,m,visited,str);
				}
				
			}
			
		}
		
		//str = str.substring(str.length()-1);  this line is not necessary however in solution it is there
		visited[i][j] = false;
		
	}

}
