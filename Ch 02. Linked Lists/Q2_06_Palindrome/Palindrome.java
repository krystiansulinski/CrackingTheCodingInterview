/*
 * 2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
 */

package Q2_06_Palindrome;

import Introduction.LinkedListNode;


public class Palindrome {
    // Time: O(n)
    // Space: O(n)
    // n - elements in the list
    static boolean isPalindrome(LinkedListNode list) {
        StringBuilder string = new StringBuilder();

        while (list != null) {
            string.append(list.value);
            list = list.next;
        }

        return string.toString().equals(string.reverse().toString());
    }
}