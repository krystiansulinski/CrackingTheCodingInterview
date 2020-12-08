/* 1.9 String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g. "waterbottle" is a rotation of "erbottlewat").
 */

package Q1_09_String_Rotation;

public class StringRotation {
    public static boolean isRotated(final String a, final String b) {
        if (a.length() != b.length() || a.length() == 0) {
            return false;
        }

        final int startIndex = b.indexOf(a.charAt(0));
        if (startIndex == -1) {
            return false;
        }

        return isSubstring(a, b.substring(startIndex) + b.substring(0, startIndex));
    }

    public static boolean isSubstring(final String a, final String b) {
        return a.equals(b);
    }
}
