import java.util.Iterator;

public class MyArrayIterator<T> implements Iterator<T> {
    private int index = 0;
    private T[] array;
    MyArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        return array[index++];
    }
}