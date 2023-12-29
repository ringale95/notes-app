package com.raveenaingale.oops.concreteClasses;



import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{

    /*
    Stack is LIFO :
    Declare a reference to the first Node in the bag
    Initially when the stack is empty the reference will be null
     */
    private Node<Item> first;

    /*
        A counter for holding number of Nodes in stack.
        Initially as there are no Nodes, so the size is
        set to 0 by the constructor.
     */
    private int size;


    public void clear() {
        first = null;  // Set the reference to the first node to null
        size = 0;
    }

    public Item peek() {
        if( isEmpty() ) throw new IllegalStateException("Stack underflow");
        return first.value;
    }

    /*
    Create static nested Node class which helps us
    create a bag and put items into bag.

    Node has 2 attributes:
    1. value -> Item
    2. next -> Node<Item>

    value is the value held by the Node
    next is the pointer/reference to next Node

    All the above two attributes are private
     */

    private static class Node<Item>{
        private Item value;
        private Node<Item> next;
    }

    /*
    Now create an empty bag using constructor,
    As referenced above, constructor will initially
    set first as null and size as 0;
     */
    public Stack(){
        first = null;
        size = 0;
    }

    /*
        This function accepts the generic type of bag
        as parameter.

        It internally creates a copy of first
        in oldFirst then reinitializes the first.

        After which it assigns item as its value
        And first.next becomes oldFirst.

        Lastly it increments the counter by 1
     */
    public void push(Item item){
    /*
    To push an item in the beggining of the list:
    1. Take the reference of the first pointer into oldFirst.
    2. Create a new node and re-initialize the first pointer
    3. Insert the item into the created node
    4. Let the next to point to the oldFirst
     */
        if(item==null) throw new IllegalArgumentException("Null Added!");
        Node<Item> oldFirst = first;
        first = new Node();
        first.value = item;
        first.next = oldFirst;
        size++;
    }

    // Check if it is empty or not
    public boolean isEmpty(){
        return first == null;
    }


    public Item pop() {
        /*
        Before removing an item, do the following:
        1. Store the item to be removed in a variable
        2. Let the pointer to point to the next
        3. Return the item
         */
        if(isEmpty()) throw new IllegalStateException("Stack underflow!");
        Item item = first.value;
        first = first.next;
        size--;
        return item;
    }

    //Returns the size of the Bag
    public int size(){
        return size;
    }

    /*
    This function returns a new instance of LinkedIterator class
    by calling its constructor
     */
    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    /*
    LinkedIterator class implements Iterator interface.
    And this class is used to iterate over the items in the Bag.
    By implementing hasNext() and next() it achieves the iteration

    To implement the logic it creates a reference to current Node.
    In the beginning, current points to first Node from the Bag.
     */
    public class LinkedIterator implements Iterator<Item>{
        private Node<Item> current;

        public LinkedIterator(Node<Item> first){
            current = first;
        }
        /*
        Checks if current reference is null or not
         */
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        /*
        Returns the next element in the Bag(Iterable).
        It implements by copying the current value
        in a variable and then pointing the current
        to next node.

        Finally returns the copied variable's value.
         */
        @Override
        public Item next() {
            Item item = current.value;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
