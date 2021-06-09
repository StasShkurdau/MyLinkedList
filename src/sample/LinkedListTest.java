package sample;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        int newData1 = 10;
        int newData2 = 20;
        linkedListToTest.add(newData1);
        assertEquals(linkedListToTest.get(1), newData1);
        linkedListToTest.add(newData2);
        assertEquals(linkedListToTest.get(2), newData2);

    }

    @Test
    void testAdd() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for(int i = 1; i<= 10; i++) {
            linkedListToTest.add(i);
        }
        int newData1 = 99, newData2 = 88;
        int index1 = 1, index2 = 10;
        linkedListToTest.add(index1, newData1);
        assertEquals(linkedListToTest.get(index1), newData1);
        linkedListToTest.add(index2, newData2);
        assertEquals(linkedListToTest.get(index2), newData2);
    }

    @Test
    void addAllTest() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        int data1 = 1, data2 = 2, data3 = 3;
        linkedListToTest.addAll(data1, data2, data3);
        assertEquals(linkedListToTest.get(1), data1);
        assertEquals(linkedListToTest.get(2), data2);
        assertEquals(linkedListToTest.get(3), data3);

    }

    @Test
    void testAddAll() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        ArrayList<Integer> arrayListToRetain = new ArrayList<>();
        for(int i = 1; i<= 10; i++) {
            arrayListToRetain.add(i);
        }
        arrayListToRetain.addAll(arrayListToRetain);
        int counterEqualObjects = 0;
        for(int i = 1; i <= linkedListToTest.size(); i++) {
            if (linkedListToTest.get(i) == arrayListToRetain.get(i-1)){
                counterEqualObjects++;
            }
        }
        assertEquals(linkedListToTest.size(), counterEqualObjects);
    }

    @Test
    void testAddAll1() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1; i<= 10; i++) {
            arrayList.add(i);
        }
        linkedListToTest.addAll(66, 77, 88, 99);
        linkedListToTest.addAll(2, arrayList);
        assertEquals(linkedListToTest.get(2), arrayList.get(0));
        assertEquals(linkedListToTest.get(4), arrayList.get(2));
        assertEquals(linkedListToTest.get(1), 66);
    }

    @Test
    void clear() {
        LinkedList<String> linkedListToTest = new <String>LinkedList<String>();
        linkedListToTest.addAll("rfsrfsf", "srfewes", "fesfsefs", "hyuugmnb");
        linkedListToTest.clear();
        assertTrue(linkedListToTest.isEmpty());
    }

    @Test
    void retainAll() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        ArrayList<Integer> arrayListToRetain = new ArrayList<>();
        for(int i = 1; i<= 10; i++) {
            arrayListToRetain.add(i);
            linkedListToTest.add(i);
        }
        linkedListToTest.add(99);
        linkedListToTest.add(55);
        linkedListToTest.retainAll(arrayListToRetain);
        int counterEqualObjects = 0;
        for(int i = 1; i <= linkedListToTest.size(); i++) {
            if (linkedListToTest.get(i) == arrayListToRetain.get(i-1)){
                counterEqualObjects++;
            }
        }
        assertEquals(linkedListToTest.size(), counterEqualObjects);
    }

    @Test
    void removeAll() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        ArrayList<Integer> arrayListToRetain = new ArrayList<Integer>();
        for(int i = 1; i<= 10; i++) {
            arrayListToRetain.add(i);
            linkedListToTest.add(i);
        }
        int testData = 99;
        linkedListToTest.add(testData);
        linkedListToTest.removeAll(arrayListToRetain);
        assertEquals(linkedListToTest.get(1), testData);

    }

    @Test
    void addFirst() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        linkedListToTest.addAll(2, 3, 4, 5, 6);
        int newFirstElement = 1;
        linkedListToTest.addFirst(newFirstElement);
        assertEquals(linkedListToTest.get(1), newFirstElement);
    }

    @Test
    void addLast() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        int newData = 99;
        linkedListToTest.addLast(99);
        assertEquals(linkedListToTest.get(linkedListToTest.size()), newData);
    }

    @Test
    void get() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        int index1 = 1, index2 = 5, index3 = 10;
        assertEquals(linkedListToTest.get(index1), index1);
        assertEquals(linkedListToTest.get(index2), index2);
        assertEquals(linkedListToTest.get(index3), index3);
    }

    @Test
    void set() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        int index1 = 1, index2 = 5, index3 = 10;
        int data1 = 77, data2 = 88, data3 = 99;
        linkedListToTest.set(index1, data1);
        linkedListToTest.set(index2, data2);
        linkedListToTest.set(index3, data3);
        assertEquals(linkedListToTest.get(index1), data1);
        assertEquals(linkedListToTest.get(index2), data2);
        assertEquals(linkedListToTest.get(index3), data3);
    }

    @Test
    void setFirst() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        int newData = 99;
        linkedListToTest.setFirst(newData);
        assertEquals(linkedListToTest.getFirst(), newData);
    }

    @Test
    void setLast() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        int newData = 99;
        linkedListToTest.setLast(newData);
        assertEquals(linkedListToTest.getLast(), newData);
    }

    @Test
    void remove() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        int removeData = 8;
        linkedListToTest.remove((Integer) removeData);
        assertFalse(linkedListToTest.contains(removeData));
    }

    @Test
    void lastIndexOf() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        int index = 8;
        assertEquals(linkedListToTest.lastIndexOf(index), index);
    }

    @Test
    void listIterator() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for(int i = 1; i<= 20; i++) {
            linkedListToTest.add(i);
        }
        ListIterator llIterator = linkedListToTest.listIterator();
        assertTrue(llIterator.hasNext());
        assertEquals(llIterator.next(), 2);
        assertEquals(llIterator.nextIndex(),3);
        llIterator.add(88);
        assertEquals(llIterator.previous(), 88);
        assertEquals(llIterator.previous(), 1);
        assertEquals(llIterator.next(), 88);
        assertEquals(llIterator.next(), 2);
        llIterator.remove();
        llIterator.set(66);
        llIterator.next();
        assertEquals(llIterator.previous(), 66);
    }

    @Test
    void testListIterator() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for(int i = 1; i<= 20; i++) {
            linkedListToTest.add(i);
        }
        ListIterator llIterator = linkedListToTest.listIterator(10);
        assertTrue(llIterator.hasNext());
        assertEquals(llIterator.next(), 11);
        assertEquals(llIterator.nextIndex(),12);
        llIterator.add(88);
        assertEquals(llIterator.previous(), 88);
        assertEquals(llIterator.previous(), 10);
        assertEquals(llIterator.next(), 88);
        llIterator.remove();
        assertEquals(llIterator.previous(), 9);
        llIterator.set(66);
        assertEquals(llIterator.previous(), 8);
        assertEquals(llIterator.next(), 66);
    }

    @Test
    void subList() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        List arrayList;
        for(int i = 1; i<= 20; i++) {
            linkedListToTest.add(i);
        }
        arrayList = linkedListToTest.subList(1, 10);
        for(int index = 1; index < 10; index++){
            assertEquals(arrayList.get(index), linkedListToTest.get(index));
        }
    }

    @Test
    void getFirst() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        int firstElement = 10;
        for(int i = firstElement; i <= 20; i++) {
            linkedListToTest.add(i);
        }
        assertEquals(linkedListToTest.getFirst(), firstElement);
    }

    @Test
    void getLast() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        int lastElement = 10;
        for(int i = 1; i <= lastElement; i++) {
            linkedListToTest.add(i);
        }
        assertEquals(linkedListToTest.getLast(),lastElement);
    }

    @Test
    void indexOf() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        int index = 8;
        assertEquals(linkedListToTest.lastIndexOf(index), index);
    }

    @Test
    void testToString() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        List<Integer> arrayList = new java.util.LinkedList<Integer>();
        for(int i = 1; i<= 10; i++) {
            arrayList.add(i);
            linkedListToTest.add(i);
        }
        assertEquals(linkedListToTest.toString(),arrayList.toString());
    }

    @Test
    void testClone() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        LinkedList<Integer> linkedListToTest2 = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        linkedListToTest2 = linkedListToTest.clone();
        for(int index = 1; index < linkedListToTest.size(); index++){
            assertEquals(linkedListToTest.get(index), linkedListToTest2.get(index));
        }

    }

    @Test
    void size() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        assertEquals(linkedListToTest.size(), 0);
        linkedListToTest.add(99);
        assertEquals(linkedListToTest.size(), 1);
    }

    @Test
    void isEmpty() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        assertTrue(linkedListToTest.isEmpty());
    }

    @Test
    void contains() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        assertTrue(linkedListToTest.contains(5));
        assertFalse(linkedListToTest.contains(88));
    }

    @Test
    void iterator() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        Iterator llIterator = linkedListToTest.iterator();
        assertTrue(llIterator.hasNext());
        assertEquals(llIterator.next(), 2);
    }

    @Test
    void toArray() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        int arrayLenght = 10;
        Object[] arrayToCompare;
        for (int i = 1; i <=arrayLenght; i++) {
            linkedListToTest.add(i);
        }
        arrayToCompare = linkedListToTest.toArray();
        for(int index = 1; index < linkedListToTest.size(); index++){
            assertEquals(linkedListToTest.get(index), arrayToCompare[index-1]);
        }
    }

    @Test
    void testRemove() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            linkedListToTest.add(i);
        }
        int removeData = 8;
        linkedListToTest.remove(removeData);
        assertFalse(linkedListToTest.contains(removeData));
    }

    @Test
    void containsAll() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        List<Integer> arrayList = new java.util.LinkedList<>();
        for(int i = 1; i<= 10; i++) {
            arrayList.add(i);
        }
        linkedListToTest.addAll(arrayList);
        System.out.println(linkedListToTest.toString());
        System.out.println(arrayList.toString());
        assertTrue(linkedListToTest.containsAll(arrayList));
        arrayList.add(88);
        assertFalse(linkedListToTest.containsAll(arrayList));
    }

    @Test
    void testToArray() {
        LinkedList<Integer> linkedListToTest = new LinkedList<Integer>();
        int arrayLenght = 10;
        Object[] arrayToCompare;
        for (int i = 1; i <=arrayLenght; i++) {
            linkedListToTest.add(i);
        }
        arrayToCompare = linkedListToTest.toArray();
        for(int index = 1; index < linkedListToTest.size(); index++){
            assertEquals(linkedListToTest.get(index), arrayToCompare[index-1]);
        }

    }
}