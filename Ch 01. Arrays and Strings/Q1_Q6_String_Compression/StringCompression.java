package Q1_Q6_String_Compression;

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
        int strLength = str.length();

        for (int i = 0; i < strLength; i++) {
            countConsecutive++;
            char current = str.charAt(i);
            boolean isLastIndex = (i + 1 >= strLength);
            boolean nextCharIsDifferent = !isLastIndex && (current != str.charAt(i + 1));

            if (isLastIndex || nextCharIsDifferent) {
                compressed.append(current);
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }

            if (strLength <= compressed.length()) {
                return str;
            }
        }

        return compressed.toString();
    }

    private static boolean hasOnlyEnglishCharacters(String str) {
        for (char c : str.toCharArray()) {
            boolean isSmall = 'a' <= c && c <= 'z';
            boolean isCapital = 'A' <= c && c <= 'Z';
            boolean isNotEnglishLetter = !(isSmall || isCapital);

            if (isNotEnglishLetter) {
                return false;
            }
        }
        return true;
    }
}
