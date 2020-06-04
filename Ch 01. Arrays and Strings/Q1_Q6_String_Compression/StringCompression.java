package Q1_Q6_String_Compression;

/* 1.6 String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would became a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a-z);
 */
public class StringCompression {
    public static String stringCompression(String s) {
        if (s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;
            char current = s.charAt(i);

            if (!('a' <= current && current <= 'z' || 'A' <= current && current <= 'Z')) {
                throw new IllegalArgumentException(
                        "This method accepts only uppercase and lowercase letters (a-z), but found: " + current
                );
            }

            if (i == s.length() - 1 || current != s.charAt(i + 1)) {
                sb.append(current);
                sb.append(count);
                count = 0;
            }
        }

        if (s.length() < sb.length()) {
            return s;
        }
        return sb.toString();
    }
}
