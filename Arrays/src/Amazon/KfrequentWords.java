package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KfrequentWords {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t=0;t<T;t++) {
			
			String st[] = sc.nextLine().split("\\s+");
			int k = sc.nextInt();
			getKfrequentWords(st,k);
			System.out.println();
		}

	}

	public static void getKfrequentWords(String[] st, int k) {
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		int n = st.length;
		
		for(String word : st) {
			
			map.put(word,map.getOrDefault(word, 0)+1);
			
		}
		
		PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String word1, String word2) {
				
				int freq1 = map.get(word1);
				int freq2 = map.get(word2);
				
				if(freq1==freq2) {
					return word2.compareTo(word1);
				}
				
				return freq1-freq2;
				
			}
			
		});
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			
			String word = entry.getKey();
			queue.add(word);
			
			if(queue.size()>k) {
				queue.poll();
			}
			
		}
		
		List<String> result = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			result.add(queue.poll());
		}
		Collections.reverse(result);
		
		for(String res : result) {
			System.out.print(res+" ");
		}
	}

}
