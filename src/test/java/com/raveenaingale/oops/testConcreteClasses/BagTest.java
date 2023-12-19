package com.raveenaingale.oops.testConcreteClasses;

import com.raveenaingale.oops.concreteClasses.Bag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

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
    public void testBagIterator(){
        Bag<Integer> bag = new Bag<>();

        bag.add(0);
        bag.add(1);
        bag.add(2);

        Iterator itr = bag.iterator();

        assertNotEquals(null, itr);
        assertTrue(itr.hasNext());
        assertEquals(2, itr.next());

    }

}

