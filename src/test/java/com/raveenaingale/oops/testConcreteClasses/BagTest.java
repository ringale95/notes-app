package com.raveenaingale.oops.testConcreteClasses;

import com.raveenaingale.oops.concreteClasses.Bag;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {

    @Test
    public void testBagAdd() {
        Bag<String> bag = new Bag<>();
        assertTrue(bag.isEmpty());
        assertEquals(0, bag.size());

        // Adding items to the bag
        bag.add("Item1");
        bag.add("Item2");

        assertFalse(bag.isEmpty());
        assertEquals(2, bag.size());
    }

    @Test
    public void testBagAddDuplicate() {
        Bag<Integer> bag = new Bag<>();

        bag.add(5);
        bag.add(10);
        bag.add(5);  // Adding a duplicate element

        assertEquals(3, bag.size());
    }


    @Test
    public void testBagIteratorEmptyBag() {
        Bag<String> bag = new Bag<>();

        Iterator<String> iterator = bag.iterator();

        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testBagIterator() {
        Bag<Integer> bag = new Bag<>();

        bag.add(5);
        bag.add(10);
        bag.add(15);

        Iterator<Integer> iterator = bag.iterator();

        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testBagAddNull() {
        Bag<String> bag = new Bag<>();

        assertThrows(IllegalArgumentException.class, () -> bag.add(null));
    }

}
