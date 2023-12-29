package com.raveenaingale.oops.concreteClasses;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{

    /*
    This implementation of Queue defines two reference pointer
    1. first - points to the first Item in Queue
    2. last - points to the last Item in Queue
     */

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private static class Node<Item>{
        private Node<Item> next;
        private Item value;
    }

    /*
    Create the constructor and initialze pointer values to null
     */
    public Queue(){
        first = null;
        last = null;
        size = 0;
    }

    /*
    Below function adds an Item to the Queue.
     */
    public void enqueue(Item item){
    /*
    In this implementation :
    1. We first create the reference copy of the oldLast
    2. We re-initialize last
    3. We assign item to the last.value
    4. Then we assign last.next as null
    5. if Queue is empty; first = last
    6. Else, oldLast.next  = last;
     */

        Node<Item> oldLast = last;
        last = new Node();
        last.value = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    /*
    Below function removes an Item from the Queue
     */
    public Item dequeue(){
    /*
    1. We first store the first Item's value in a variable;
    2. Make the second Item as first
    3. Decrement size counter
    4. return the oldFirst item value;
     */
        if(isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.value;
        first = first.next;
        size--;
        if(isEmpty()) last = first;
        return item;
    }

    //Below function checks if Queue is empty or not
    public boolean isEmpty(){
        return first == null;
    }

    //Below functions gives the size of the Queue
    public int size(){
        return size;
    }
    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator{
        private Node<Item> current;

        public LinkedIterator(Node<Item> first){
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Object next() {
            Item item = current.value;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
