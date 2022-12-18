import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList<String> myArrayList;

    @BeforeEach
    public void createData(){
    myArrayList = new MyArrayList<>();
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        myArrayList.add("giraffe");
        myArrayList.add("cat");
        myArrayList.add("dog");
        myArrayList.toString();
        assertArrayEquals(new String[]{"giraffe", "cat", "dog", null, null, null, null, null, null, null},
                Arrays.stream(myArrayList.display()).toArray());
    }

    @org.junit.jupiter.api.Test
    void testAddMyArrayListMethod() {
        myArrayList.add("giraffe");
        myArrayList.add("cat");
        myArrayList.add("dog");
        myArrayList.add("monkey");
        assertArrayEquals(new String[]{"giraffe", "cat", "dog", "monkey", null, null, null, null, null, null},
                Arrays.stream(myArrayList.display()).toArray());
    }

    @org.junit.jupiter.api.Test
    void makeArrayGreatAgain() {
        myArrayList.makeArrayGreatAgain();
        assertArrayEquals(new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                Arrays.stream(myArrayList.display()).toArray());
    }

    @org.junit.jupiter.api.Test
    void addElementInArrayMiddle() {
        myArrayList.add("giraffe");
        myArrayList.add("cat");
        myArrayList.add("dog");
        myArrayList.add("monkey");
        myArrayList.addElementInArrayMiddle(1, "cow");
        assertArrayEquals(new String[]{"giraffe", "cow", "cat", "dog", "monkey", null, null, null, null, null},
                Arrays.stream(myArrayList.display()).toArray());
    }

    @org.junit.jupiter.api.Test
    void deleteOneElement() {
        myArrayList.add("giraffe");
        myArrayList.add("cat");
        myArrayList.add("dog");
        myArrayList.add("monkey");
        myArrayList.add("chicken");
        myArrayList.add("elephant");
        myArrayList.add("horse");
        myArrayList.add("mouse");
        myArrayList.add("rabbit");
        myArrayList.add("snake");
        myArrayList.deleteOneElement(3);
        assertArrayEquals(new String[]{"giraffe", "cat", "dog", "chicken", "elephant", "horse", "mouse", "rabbit", "snake"},
                Arrays.stream(myArrayList.display()).toArray());
    }

    @org.junit.jupiter.api.Test
    void deleteAllElement() {
        myArrayList.add("giraffe");
        myArrayList.add("cat");
        myArrayList.add("dog");
        myArrayList.add("monkey");
        myArrayList.add("chicken");
        myArrayList.add("elephant");
        myArrayList.add("horse");
        myArrayList.add("mouse");
        myArrayList.add("rabbit");
        myArrayList.add("snake");
        myArrayList.deleteAllElement();
        assertArrayEquals(new String[]{null, null, null, null, null, null, null, null, null, null},
                Arrays.stream(myArrayList.display()).toArray());
    }

    @org.junit.jupiter.api.Test
    void testGetElementByIndex() {
        myArrayList.add("Dog");
        myArrayList.add("Cat");
        assertEquals("Dog", myArrayList.get(0));
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(10,myArrayList.size());
    }

    @Test
    void testDisplayMethod() {
        myArrayList.add("1");
        myArrayList.add("2");
       assertArrayEquals(new String[]{"1", "2", null, null, null, null, null, null, null, null},
               Arrays.stream(myArrayList.display()).toArray());
    }

    @org.junit.jupiter.api.Test
    void testUpdateMethod() {
        myArrayList.add("Rabbit");
        myArrayList.add("Horse");
        myArrayList.update(1, "Giraffe");
        assertEquals("Giraffe", myArrayList.get(1));
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }
    @Test
    void setMyArrayList() {
        myArrayList.add("Rabbit");
        myArrayList.add("Dog");
        myArrayList.add("Cat");
        myArrayList.set(0, 1);
        assertArrayEquals(new String[]{"Dog", "Dog", "Cat", null, null, null, null, null, null, null},
                Arrays.stream(myArrayList.display()).toArray());
    }

    @Test
    void testQuickSortMethod() {
        myArrayList.add("Rabbit");
        myArrayList.add("Dog");
        myArrayList.add("Cat");
        MyArrayList.quickSort(myArrayList);
        assertArrayEquals(new String[]{"Cat", "Dog", "Rabbit", null, null, null, null, null, null, null},
                Arrays.stream(myArrayList.display()).toArray());
    }

    @Test
    void testQuickSortMethodWithParameters() {
        myArrayList.add("Rabbit");
        myArrayList.add("Dog");
        myArrayList.add("Cat");
        myArrayList.add("Rabbit");
        myArrayList.add("Dog");
        myArrayList.add("Cat");
        MyArrayList.quickSort(myArrayList, 0, myArrayList.size() - 5);
        assertArrayEquals(new String[]{"Cat", "Cat", "Dog", "Dog", "Rabbit", "Rabbit", null, null, null, null},
                Arrays.stream(myArrayList.display()).toArray());
    }

    @Test
    void testPartitionMethod() {
        MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.add(56);
        numbers.add(14524);
        numbers.add(32);
        numbers.add(2);
        numbers.add(-5);
        numbers.add(32);
        numbers.add(2);
        numbers.add(-5);
        MyArrayList.partition(numbers, 0, numbers.size() - 5);
        assertArrayEquals(new Integer[] {-5, 32, 32, 2, 56, 14524, 2, -5, null, null}, Arrays.stream(numbers.display()).toArray());
    }
}