package Introduction;

public class MyIntegerArrayList {
    private final int DEFAULT_SIZE = 10;
    private int size = 0;
    private int[] array;

    MyIntegerArrayList() {
        this.array = new int[DEFAULT_SIZE];
    }

    MyIntegerArrayList(int size) {
        this.array = new int[size];
    }

    private void resize(int factor) {
        if (factor < 2) {
            return;
        }

        if (array.length == size) {
            int[] newArray = new int[array.length * factor];
            System.arraycopy(array, 0, newArray, 0, array.length);
            this.array = newArray;
        }
    }

    private void doubleSize() {
        resize(2);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(int value) {
        for (int element : this.array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

//    public Object[] toArray() {
//        return new Object[0];
//    }

    public boolean add(int element) {
        if (array.length == size) {
            this.doubleSize();
        }

        array[size] = element;
        size++;

        return true;
    }

    void add(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        array[index] = element;
    }

    public boolean removeIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        int[] newArray = new int[this.array.length - 1];
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index + 1, newArray, index, newArray.length - index);

        return true;
    }

    public boolean removeValue(int value) {
        for (int i = 0; i < this.size(); i++) {
            if (this.array[i] == value) {
                return this.removeIndex(i);
            }
        }

        return false;
    }

    public boolean addAll(int[] values) {
        int quotient = values.length / this.size();
        int remainder = values.length % this.size() != 0 ? 1 : 0;

        this.resize(quotient + remainder);

        for (int i = 0; i < this.size(); i++) {
            this.array[i] = values[i];
        }

        return false;
    }

    public void clear() {
        this.array = new int[DEFAULT_SIZE];
    }

    public boolean retainAll(int[] values) {
        return false;
    }

    public boolean removeAll(int[] values) {
        for (int i = 0; i < values.length; i++) {
            this.removeValue(values[i]);
        }
        return true;
    }

    public boolean containsAll(int[] values) {
        for (int value : values) {
            if (!this.contains(value)) {
                return false;
            }
        }
        return true;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
