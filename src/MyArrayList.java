import java.util.*;
import java.util.Random;
/** Реализация ArrayList*/
public class MyArrayList<T> implements MyArray<T> {
    private int capacity = 10;
    private Object[] array;
    private int currentIndex = 0;
    private int size = 0; //количество элементов в массиве
    public static final Random RND = new Random();

    public MyArrayList() {
        array = new Object[capacity];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    /** добавление элемента в массив */
    public boolean add(Object t) {
        if (currentIndex >= array.length) {
            makeArrayGreatAgain();
        }
        array[currentIndex++] = t;
        size++;
        return true;
    }

    @Override
    /** увеличение массива */
    public void makeArrayGreatAgain() {
        int newCapacity = capacity * 3 / 2 + 1;
        Object[] temp = new Object[newCapacity];
        System.arraycopy(array, 0, temp, 0, capacity);
        array = temp;
        capacity = newCapacity;
    }

    @Override
    /** добавление элемента в середину массива */
    public boolean addElementInArrayMiddle(int index, T t) {
        try{
            if(currentIndex + 1 >= array.length){
                makeArrayGreatAgain();
            }
            Object [] tmp = array;
            array = new Object[array.length];
            System.arraycopy(tmp, 0, array, 0, index );
            array[index] = t;
            currentIndex++;
            size++;
            System.arraycopy(tmp, index, array, index + 1, tmp.length - index - 1);
            return true;
        } catch (ClassCastException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    /**удаление элемента по индексу */
    public void deleteOneElement(int index) {
        if (index <= array.length) {
            try {
                Object[] temp = array;
                array = new Object[temp.length - 1];
                System.arraycopy(temp, 0, array, 0, index);
                System.arraycopy(temp, index + 1, array, index, temp.length - index - 1);
            } catch (ClassCastException exception) {
                exception.printStackTrace();
            }
        } else
            System.out.println("Элемента под таким индексом нет.");
    }

    @Override
    /**удаление всех элементов в массиве */
    public void deleteAllElement() {
        for(int i = 0; i < array.length; i++){
            array[i] = null;
        }
    }

    @Override
    /**получить элемент по индексу */
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    /**количество ячеек в массиве */
    public int size() {
        return array.length;
    }

    /**вывод массива на экран */
    public void display() {
        for (Object elem : array) {
            System.out.print(elem + " ");
        }
    }

    @Override
    /**обновление значение элемента в массиве по индексу */
    public void update(int index, Object t) {
        array[index] = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayIterator<T>((T[]) array);
    }


    public static void main(String[] args) {
        MyArrayList<String> animals = new MyArrayList();
        animals.add("giraffe");
        animals.add("cat");
        animals.add("dog");
        animals.add("monkey");
        animals.add("chicken");
        animals.add("elephant");
        animals.add("horse");
        animals.add("mouse");
        animals.add("rabbit");
        animals.add("snake");
        animals.add("frog");
        animals.add("rhinoceros");
        System.out.println(animals);
        animals.addElementInArrayMiddle(3, "fly");
        System.out.println(animals);
        animals.addElementInArrayMiddle(3, "rabbit");
        System.out.println(animals);
        animals.addElementInArrayMiddle(3, "lynx");
        System.out.println(animals);
        animals.addElementInArrayMiddle(3, "camel");
        System.out.println(animals);
        animals.deleteOneElement(99);
        animals.deleteAllElement();
        System.out.println(animals);
    }
}
