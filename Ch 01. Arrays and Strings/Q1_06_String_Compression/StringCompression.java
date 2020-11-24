package Q1_06_String_Compression;

/* 1.6 String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would became a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a-z);
 */
public class StringCompression {
    public static String stringCompression(String str) {
        if (!hasOnlyEnglishCharacters(str)) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }

            if (str.length() <= compressed.length()) {
                return str;
            }
        }

        return compressed.toString();
    }

    private static boolean hasOnlyEnglishCharacters(String str) {
        for (char c : str.toCharArray()) {
            boolean isSmall = 'a' <= c && c <= 'z';
            boolean isCapital = 'A' <= c && c <= 'Z';
            boolean isEnglishLetter = isSmall || isCapital;

            if (!isEnglishLetter) {
                return false;
            }
        }
        return true;
    }
}
