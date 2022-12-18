import java.util.*;
import java.util.Random;

import static java.lang.System.*;

/** Реализация ArrayList*/
public class MyArrayList<T extends Comparable<T>> implements MyArray<T> {
    private int capacity = 10;
    private Object[] array;
    private int currentIndex = 0;
    private int size = 0; //количество элементов в массиве
    public static final Random RND = new Random();

    public MyArrayList() {
        array = new Object[capacity];
    }

    /** Быстрая сортировка с использованием интерфейса Comparable*/
    public static <T extends Comparable<T>>
    void quickSort(MyArrayList<T> list) {
        quickSort(list, 0, list.size - 1);
    }

    public static <T extends Comparable<T>>
    void quickSort(MyArrayList<T> list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /** Разделение массива для быстрой сортировки */
    public static <T extends Comparable<T>>
    int partition(MyArrayList<T> list, int first, int last) {
        T pivot = list.get(first); // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            while (low <= high && list.get(low).compareTo(pivot) <= 0)
                low++;

            while (low <= high && list.get(high).compareTo(pivot) > 0)
                high--;

            // Поменять два элемента местами
            if (high > low) {
                T temp = list.get(high);
                list.set(high, low);
                list.update(low, temp);
            }
        }

        while (high > first && list.get(high).compareTo(pivot) >= 0)
            high--;

        if (pivot.compareTo(list.get(high)) > 0) {
            list.set(first, high);
            list.update(high, pivot);
            return high;
        }
        else {
            return first;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    /** добавление элемента в массив */
    public boolean add(T t) {
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
        arraycopy(array, 0, temp, 0, capacity);
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
            arraycopy(tmp, 0, array, 0, index );
            array[index] = t;
            currentIndex++;
            size++;
            arraycopy(tmp, index, array, index + 1, tmp.length - index - 1);
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
                arraycopy(temp, 0, array, 0, index);
                arraycopy(temp, index + 1, array, index, temp.length - index - 1);
            } catch (ClassCastException exception) {
                exception.printStackTrace();
            }
        } else
            out.println("Элемента под таким индексом нет.");
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

    public void set(int index,int index1) {
        array[index] = array[index1];
    }

    @Override
    /**количество ячеек в массиве */
    public int size() {
        return array.length;
    }

    /**вывод массива на экран */
    public Object[] display() {
        Object[] objects = new Object[array.length];
            for (int i = 0; i < objects.length; i++) {
                objects[i] = array[i];
                out.print(objects[i] + " ");
        }
            return objects;
    }

    @Override
    /**обновление значение элемента в массиве по индексу */
    public void update(int index, T t) {
        array[index] = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayIterator<T>((T[]) array);
    }

    public Object[] toArray() {
        MyArrayList<T> arrayList = new MyArrayList<>();
        T[] array = (T[]) new Object[arrayList.size];
        for (int i = 0; i < arrayList.size; i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
    }
}
