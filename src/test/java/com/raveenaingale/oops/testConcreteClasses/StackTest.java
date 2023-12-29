package com.raveenaingale.oops.testConcreteClasses;

import com.raveenaingale.oops.concreteClasses.Stack;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testStackPushPop() {
        Stack<String> stack = new Stack<>();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());

        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testStackPeek() {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testStackClear() {
        Stack<Double> stack = new Stack<>();

        stack.push(3.14);
        stack.push(2.71);

        assertFalse(stack.isEmpty());

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testStackIteratorEmptyStack() {
        Stack<Character> stack = new Stack<>();

        Iterator<Character> iterator = stack.iterator();

        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testStackIterator() {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(10);
        stack.push(15);

        Iterator<Integer> iterator = stack.iterator();

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
    public void testStackPushNull() {
        Stack<String> stack = new Stack<>();
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
    }

    @Test
    public void testStackPopEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void testStackPeekEmptyStack() {
        Stack<Double> stack = new Stack<>();
        assertThrows(IllegalStateException.class, stack::peek);
    }


}
