package Introduction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyIntegerArrayListTest {
    @Test
    public void testConstructor1() {
        MyIntegerArrayList list1 = new MyIntegerArrayList();

        assertTrue(list1.isEmpty());
        assertEquals(0, list1.size());
    }

    @Test
    public void testConstructor2() {
        MyIntegerArrayList list1 = new MyIntegerArrayList(3);

        assertFalse(list1.isEmpty());
        assertEquals(3, list1.size());
    }

    @Test
    public void testConstructor3() {
        int[] arr1 = {1, 2, 3, 4};
        MyIntegerArrayList list = new MyIntegerArrayList(arr1);

        assertFalse(list.isEmpty());
        assertEquals(arr1.length, list.size());
    }

    @Test
    public void testAdd1() {
        MyIntegerArrayList list = new MyIntegerArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        assertFalse(list.isEmpty());
        assertEquals(11, list.size());
    }

    @Test
    public void testAdd2() {
        MyIntegerArrayList list = new MyIntegerArrayList();

        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            list.add(0, 1);
        });

        String expectedMessage = "Index out of boundaries";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void testAdd3() {
        MyIntegerArrayList list = new MyIntegerArrayList(2);

        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            list.add(3, 4);
        });

        String expectedMessage = "Index out of boundaries";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void testAdd4() {
        MyIntegerArrayList list = new MyIntegerArrayList(2);

        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            list.add(-1, 4);
        });

        String expectedMessage = "Index out of boundaries";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void testAddAll1() {
        MyIntegerArrayList list = new MyIntegerArrayList();
        int[] arr1 = {1, 2, 3, 4};
        list.addAll(arr1);
        list.addAll(arr1);

        assertEquals(false, list.isEmpty());
        assertEquals(arr1.length * 2, list.size());
    }

    @Test
    public void testGet() {
        int[] arr1 = {1, 2, 3, 4};
        MyIntegerArrayList list = new MyIntegerArrayList(arr1);
        list.add(2, 5);

        assertEquals(5, list.get(2));
    }

    @Test
    public void testRemoveIndex1() {
        MyIntegerArrayList list = new MyIntegerArrayList();
        int[] arr1 = {1, 2, 3, 4};
        list.addAll(arr1);
        list.removeIndex(2);

        assertEquals(false, list.isEmpty());
        assertEquals(arr1.length - 1, list.size());
        assertEquals(false, list.contains(3));

    }
}
