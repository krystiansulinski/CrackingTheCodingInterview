package Q2_06_Palindrome;

import Introduction.LinkedListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
    @Test
    void isPalindromeTest() {
        int[][] palindromes = {{1, 2, 3, 2, 1}, {1, 2, 2, 1}};

        for (int[] palindrome : palindromes) {
            assertTrue(Palindrome.isPalindrome(new LinkedListNode(palindrome)));
        }
    }
}
