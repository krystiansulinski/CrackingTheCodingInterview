import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
	public static boolean permutation(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		
		int[] letters = new int[128]; //assumes ASCII
		for (char c: a.toCharArray()) {
			letters[c]++;
		}
		
		for (char c: b.toCharArray()) {
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
	
	//Time: O(the length of the longer of strings)
	//Space: map of the length of the longer of strings
	public static boolean checkPermutation(String a, String b) {
		return count(a).equals(count(b));
	}
	
	public static Map<Character, Integer> count(String s) {
		Map<Character, Integer> map = new HashMap<>();
		
		for (char c : s.toCharArray()) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		
		return map;
	}
}
