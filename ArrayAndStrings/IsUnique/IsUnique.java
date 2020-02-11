package IsUnique;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {
	// Time: O(1)
	// Space: O(1)
	public static boolean isUnique(String str) {
		if (str.length() > 26) { // assumes only letters a through z so we can use just a single int
			return false;
		}

		int checker = 0;
		for (char c: str.toCharArray()) {
			int value = c - 'a';
			if ((checker & (1 << value)) > 0) {
				return false;
			}
			checker |= (1 << value);
		
		}
		return true;
	}
	
	// Time: O(n)
	// Space: O(n)
	// n: the size of the string
	public static boolean isUniqueRecursive(String str) {
		return unique(str, ' ');
	}
	
	public static boolean unique(String str, char c) {
		if (str.length() == 0) {
			return true;
		}
		if (str.indexOf(c) != -1) {
			return false;
		}
		int lastIndex = str.length() - 1;
		return unique(str.substring(0, lastIndex), str.charAt(lastIndex));
	}
	
	// Time: O(n)
	// Space: O(n)
	// n: the size of the string
	public static boolean isUniqueSet(String str) {
		Set<Character> map = new HashSet<>();
		
		for (char c : str.toCharArray()) {
			if (map.contains(c)) {
				return false;
			}
			map.add(c);
		}
		return true;
	}
	
	// Time: O(n ^ 2)
	// Space: O(n)
	// n: the size of the string
	public static boolean isUniqueBruteForce(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
