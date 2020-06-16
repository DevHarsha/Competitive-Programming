import java.util.*;
import java.util.Arrays;

public class AmazonVideo {

	public static void main(String[] args) {
		
		List<Character> scenes = new ArrayList<>(Arrays.asList('a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j'));
		System.out.println(lengthEachScene(scenes));

	}
	
	static List<Integer> lengthEachScene(List<Character> inputList){
		
		HashMap<Character,Integer> map = new LinkedHashMap<>();
		
		for(int i=0;i<inputList.size();i++) {
			map.put(inputList.get(i),i);
		}
		
		List<Integer> result = new Vector<Integer>();
		
		int left = 0;
		int right = 0;
		
		for(int i=0;i<inputList.size();i++) {
			System.out.println(right+" "+map.get(inputList.get(i)));
			right = Math.max(right, map.get(inputList.get(i)));
			if(right == i) {
				result.add(1+right-left);
				left = right+1;
			}
		}
		return result;
		
	}
}
