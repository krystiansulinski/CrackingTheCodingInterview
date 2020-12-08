package Q1_09_String_Rotation;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringRotationTest {
    @Test
    public void isRotatedTest() {
        assertTrue(StringRotation.isRotated("waterbottle", "erbottlewat"));
        assertTrue(StringRotation.isRotated("waterbottle", "aterbottlew"));
        assertTrue(StringRotation.isRotated("waterbottle", "waterbottle"));

        assertFalse(StringRotation.isRotated("waterbottle", "waterbottl"));
        assertFalse(StringRotation.isRotated("", ""));
        assertFalse(StringRotation.isRotated("abcd", "bcd"));
        assertFalse(StringRotation.isRotated("abcd", "bbcd"));
    }
}
