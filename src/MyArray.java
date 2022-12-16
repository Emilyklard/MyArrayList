import java.util.List;

public interface MyArray<T> extends Iterable<T> {
    boolean add(T t);

    boolean addElementInArrayMiddle(int index, T t);

    void deleteOneElement(int index);

    void deleteAllElement();

    T get(int index);

    int size();

    void update(int index, T t);

    void makeArrayGreatAgain();


}

