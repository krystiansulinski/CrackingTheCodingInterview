package Q1_Q6_String_Compression;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionTest {
    @Test
    public void stringCompressionTest() {
        String[] given = {"aabcccccaaa", "", "abcd", "zhKKKKKkk"};
        String[] expected = {"a2b1c5a3", "", "abcd", "z1h1K5k2"};

        for (int i = 0; i < given.length; i++) {
            assertEquals(expected[i], StringCompression.stringCompression(given[i]));
        }
    }

    @Test
    public void stringCompressionTestInvalid() {
        assertInvalid("a1b1c5");
        assertInvalid("abc d");
        assertInvalid("$");
    }

    private void assertInvalid(String invalid) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringCompression.stringCompression(invalid);
        }, "This method accepts only uppercase and lowercase letters (a-z), but found: " + invalid);
    }
}
