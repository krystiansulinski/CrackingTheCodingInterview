package Q1_Q6_String_Compression;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionTest {
    @Test
    public void whenValidStringThenCompress() {
        String[] given = {"aabcccccaaa", "", "abcd", "zhKKKKKkk"};
        String[] then = {"a2b1c5a3", "", "abcd", "z1h1K5k2"};

        for (int i = 0; i < 4; i++) {
            assertEquals(then[i], StringCompression.stringCompression(given[i]));
        }
    }

    @Test
    public void whenInvalidStringThenReturn() {
        String[] given = {"a1b1c5", "abc d", "$", "a", "zj", "ńsssss"};

        for (String str : given) {
            assertEquals(str, StringCompression.stringCompression(str));
        }
    }
}
