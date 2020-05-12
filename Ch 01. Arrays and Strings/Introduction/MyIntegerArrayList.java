package Introduction;

public class MyIntegerArrayList {
    private final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private int[] array;

    MyIntegerArrayList() {
        this.size = 0;
        this.capacity = this.DEFAULT_CAPACITY;
        this.array = new int[this.DEFAULT_CAPACITY];
    }

    MyIntegerArrayList(int size) {
        this.size = size;
        this.capacity = size;
        this.array = new int[size];
    }

    MyIntegerArrayList(int[] values) {
        this(values.length);

        for (int i = 0; i < this.size(); i++) {
            this.array[i] = values[i];
        }
    }

    public boolean add(int element) {
        if (this.size() == internalSize()) {
            doubleSize();
        }

        array[size] = element;
        size++;

        return true;
    }

    public void add(int index, int element) {
        this.throwIfIndexOufOfBounds(index);
        array[index] = element;
    }

    public boolean addAll(int[] values) {
        int quotient = values.length / internalSize();
        int remainder = values.length % internalSize() != 0 ? 1 : 0;

        if (!increaseSize(quotient + remainder)) {
            this.size = this.size + values.length;
        }

        for (int i = 0; i < values.length; i++) {
            array[i] = values[i];
        }

        return true;
    }

    public int get(int index) {
        this.throwIfIndexOufOfBounds(index);
        return this.array[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean removeIndex(int index) {
        this.throwIfIndexOufOfBounds(index);

        int j = 0;
        for (int i = 0; i < this.size(); i++) {
            if (i >= index) {
                j = i + 1;
            }
            this.array[i] = this.array[j];
        }

        this.size = array.length - 1;
        this.capacity = array.length - 1;

        return true;
    }

    public boolean removeValue(int value) {
        for (int i = 0; i < internalSize(); i++) {
            if (array[i] == value) {
                return removeIndex(i);
            }
        }

        return false;
    }

    public void clear() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public boolean removeAll(int[] values) {
        for (int i = 0; i < values.length; i++) {
            removeValue(values[i]);
        }
        return true;
    }

    public boolean contains(int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(int[] values) {
        for (int value : values) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    private int internalSize() {
        return array.length;
    }

    private void throwIfIndexOufOfBounds(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of boundaries");
        }
    }

    private boolean increaseSize(int factor) {
        if (factor < 2) {
            return false;
        }

        int[] newArray = new int[this.array.length * factor];
        this.size = this.array.length * factor;
        this.capacity = this.array.length * factor;
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        this.array = newArray;
        return true;
    }

    private void doubleSize() {
        this.increaseSize(2);
    }
}
