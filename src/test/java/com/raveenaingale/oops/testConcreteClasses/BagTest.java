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

}

