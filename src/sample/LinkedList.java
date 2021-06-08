package sample;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

public class LinkedList<T> implements List<T> {

    private Node head;
    private Node tail;
    private int counter = 0;

    public class Node {
        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

    }
    public class MyIterator implements Iterator<T>{

        private int currentPosition = 0;
        LinkedList<T> listObject;
        Node currentNode;

        public MyIterator(LinkedList<T> linkedList) {
            this.listObject = linkedList;
            this.currentNode = listObject.head;
        }

        public boolean hasNext() {
            if(currentNode.next == null) {
                return false;
            }
            return true;
        }

        public T next() {
            currentNode = currentNode.next;
            return currentNode.data;
        }

        @Override
        public void remove() {
            listObject.remove(currentPosition);
        }


    }
    public class MyListIterator implements ListIterator<T>{
        public MyListIterator(LinkedList<T> linkedList, int index) throws IndexOutOfBoundsException {
            if(index < 0 && linkedList.counter < index){
                throw new IndexOutOfBoundsException();
            }
            this.listObject = linkedList;
            this.currentNode = listObject.head;
            this.currentPosition = index;
            Node link = linkedList.head;

            if (linkedList.counter < index) {
                return;
            }
            for(int i = 1; i < index; i++) {
                link = link.next;
            }
            currentNode = link;
        }

        public MyListIterator(LinkedList<T> linkedList) {
            this.listObject = linkedList;
            this.currentNode = linkedList.head;
        }


        private int currentPosition = 1;
        LinkedList<T> listObject;
        Node currentNode;

        @Override
        public boolean hasNext() {
            if(currentNode.next == null) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            currentNode = currentNode.next;
            currentPosition++;
            return currentNode.data;
        }

        @Override
        public boolean hasPrevious() {
            if(currentNode.previous == null){
                return false;
            }
            return true;
        }

        @Override
        public T previous() {
            currentNode = currentNode.previous;
            currentPosition--;
            return currentNode.data;
        }

        @Override
        public int nextIndex() {
            int returnIndex = currentPosition + 1;
            return returnIndex;
        }

        @Override
        public int previousIndex() {
            int returnIndex = currentPosition - 1;
            return returnIndex;
        }

        @Override
        public void remove() {
            listObject.remove(currentPosition);
        }

        @Override
        public void set(T objectToSet) {
            listObject.set(currentPosition, objectToSet);
        }

        @Override
        public void add(T objectToAdd) {
            listObject.add(currentPosition, objectToAdd);
        }
    }


    @Override
    public boolean add(T data){
        if(head == null && tail == null) {
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
            counter++;
        }else{
            addLast(data);
        }
        return true;
    }

    private Node getNodeByIndex(int index) {
        boolean isFirstHalf = index <= (counter/2);
        Node indexNode = isFirstHalf ? head : tail;
        Function<Node, Node> getNext = isFirstHalf ? (node) -> node.next : (node) -> node.previous;
        int stepCount = isFirstHalf ? index : counter - index+1;
        for (int i = 1; i < stepCount; i++) {
            indexNode = getNext.apply(indexNode);
        }
        return indexNode;
    }

    private void relinkBefore(Node targetNode, Node newNode) {
        newNode.next = targetNode;
        newNode.previous = targetNode.previous;
        targetNode.previous = newNode;
        if (newNode.previous != null) {
            newNode.previous.next = newNode;
        }
    }

    @Override
    public void add(int index, T data) throws IndexOutOfBoundsException {
        if (index <= 0 || index > counter) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null && tail == null) {
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
        }else if(index == 1){
            addFirst(data);
        } else if (index < counter) {
            Node newNode = new Node(data);
            Node targetNode = getNodeByIndex(index);
            relinkBefore(targetNode, newNode);
        }else {
            addLast(data);
            return;
        }
        counter++;
    }

    public void addAll(T ... data){
        for (T index:data) {
            add(index);
        }

    }

    public boolean addAll(Collection collection) throws NullPointerException{
        if(collection == null){
            throw new NullPointerException();
        }
        T collectionToArray[] = (T[]) collection.toArray();
        for (int i = 0; i < collection.size(); i++) {
            add(collectionToArray[i]);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection collection) throws IndexOutOfBoundsException, NullPointerException {
        if (index <= 0 || index > counter) {
            throw new IndexOutOfBoundsException();
        }
        if(collection == null){
            throw new NullPointerException();
        }
        T collectionToArray[] = (T[]) collection.toArray();
        for (int indexOfIteration = 0, indexToAdd = index; indexOfIteration < collection.size(); indexOfIteration++, indexToAdd++) {
            add(indexToAdd,collectionToArray[indexOfIteration]);
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        counter = 0;

    }

    @Override
    public boolean retainAll(Collection collectionToRetain) {
        int counterOfChanges = 0;
        int indexInLinkedList = 1;
        while(indexInLinkedList <= counter){
            T currentElement = get(indexInLinkedList);
            if(!collectionToRetain.contains(currentElement)){
                remove(indexInLinkedList);
                counterOfChanges++;
                continue;
            }
            indexInLinkedList++;
        }

        if(0 < counterOfChanges){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        int removeCounter = 0;
        for(Object nodeCollectionData: collection){
            if(remove(nodeCollectionData)){
                removeCounter++;
            }
        }

        return 0 < removeCounter;
    }

    public void addFirst(T data){
        Node newNode = new Node(data);
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
        counter++;

    }

    public void addLast(T data){
        Node newNode = new Node(data);
        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
        counter++;
    }


    public T get(int index) throws IndexOutOfBoundsException{
        if(0 < index && index <= counter){
            Node newNode = getNodeByIndex(index);
            return newNode.data;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T set(int index, T newData) throws IndexOutOfBoundsException {
        T returnOldData = null;
        if(index == 1){
            returnOldData = head.data;
            head.data = newData;
        }else if(index <= counter) {
            Node targetNode = getNodeByIndex(index);
            returnOldData = targetNode.data;
            targetNode.data = newData;
        }else if (index <= 0 || index > counter){
            throw new IndexOutOfBoundsException();
        }
        return returnOldData;
    }

    public T setFirst(T newData){
        T returnOldData = head.data;
        head.data = newData;
        return returnOldData;
    }
    public T setLast(T newData){
        T returnOldData = tail.data;
        tail.data = newData;
        return returnOldData;
    }



    @Override
    public T remove(int indexOfElement) throws IndexOutOfBoundsException {
        T returnData = null;
        if (indexOfElement < 0 || indexOfElement > counter) {
            throw new IndexOutOfBoundsException();
        }
        if(indexOfElement == 1){
            returnData = head.data;
            head = head.next;
        }else if(indexOfElement < counter) {
            Node targetNode = getNodeByIndex(indexOfElement);
            returnData = targetNode.data;
            targetNode.previous.next = targetNode.next;
            targetNode.next.previous = targetNode.previous;
        }else if(indexOfElement == counter){
            returnData = tail.data;
            tail = tail.previous;
        }
        counter--;
        return returnData;
    }

    @Override
    public int lastIndexOf(Object comparisonObject) {
        Node previousLink = tail;
        for(int index = counter; index > 0; index--){
            if(previousLink.data==comparisonObject){
                return index;
            }
            previousLink = previousLink.previous;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        MyListIterator listIterator = new MyListIterator(this);
        return listIterator;
    }

    @Override
    public ListIterator listIterator(int index) {
        MyListIterator listIterator = new MyListIterator(this, index);
        return listIterator;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        LinkedList<T> subLinkedList = new LinkedList<T>();
        Node nextLink = head;
        for(int index = 1; index <= toIndex; index++){
            if(fromIndex <= index){
                subLinkedList.add(nextLink.data);
            }
            nextLink = nextLink.next;
        }
        return subLinkedList;
    }

    public T getFirst(){
        return head.data;
    }

    public  T getLast(){
        return tail.data;
    }

    public int indexOf(Object comparisonObject){
        Node nextLink = head;
        for(int i = 1; i <= counter; i++){
            if(nextLink.data == comparisonObject){
                return i;
            }
            nextLink = nextLink.next;
        }
        return -1;
    }

    @Override
    public String toString(){
        Node nextLink = head;
        String returnString = "[";

        for(int index = 1; index <= counter; index++){
            returnString += nextLink.data.toString();
            if(index < counter) {
                returnString += ", ";
            }
            nextLink = nextLink.next;
        }
        returnString += "]";
        return returnString;
    }

    public LinkedList clone(){
        LinkedList linkedListCopy = new LinkedList();
        T copyData;
        for(int index = 1; index <= counter; index++){
            linkedListCopy.add(get(index));
        }
        return linkedListCopy;
    }

    public int size(){
        return counter;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object comparisonObject) {
        Node nextLink = head;
        for(int i = 1; i <= counter; i++){
            if(nextLink.data == comparisonObject){
                return true;
            }
            nextLink = nextLink.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        MyIterator listIterator = new MyIterator(this);
        return listIterator;
    }
    @Override
    public Object[] toArray() {
        Object[] arrayToReturn = new Object[counter];
        for(int index = 1; index <= counter; index++){
            arrayToReturn[index-1] = get(index);
        }
        return arrayToReturn;
    }


    @Override
    public boolean remove(Object removeObject) {
        Node nextLink = head;
        Node previousLink = head;
        if(removeObject == head.data){
            head = head.next;
            head.previous = null;
            counter--;
            return true;
        }
        if(removeObject == tail.data){
            tail = tail.previous;
            tail.next = null;
            counter--;
            return true;
        }
        for(int index = 1; index <= counter; index++){
            if(removeObject == get(index)){
                nextLink = nextLink.next;
                nextLink.previous = previousLink;
                previousLink.next = nextLink;
                counter--;
                return true;
            }
            previousLink = nextLink;
            nextLink = nextLink.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection collection){
        int counterOfContainsElement = 0;
        Object collectionToArray[] = collection.toArray();
        for(int index = 0; index < collectionToArray.length; index++){
            if(contains(collectionToArray[index])){
                counterOfContainsElement++;
            }
        }
        return counterOfContainsElement == collection.size();
    }

    @Override
    public <T> T[] toArray(T[] obtainedArray) throws NullPointerException {
        T[] arrayToReturn;
        if(obtainedArray==null){
            throw new NullPointerException();
        }else if(obtainedArray.length < counter){
            arrayToReturn = (T[]) new Object[counter];
        }else{
            arrayToReturn = obtainedArray;
        }
        for(int index = 1; index <= counter; index++){
            arrayToReturn[index-1] = (T) get(index);
        }
        return arrayToReturn;
    }

}
