package com.raveenaingale.questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {
    @Test
    public void testAddition() {
        assertEquals(5, SimpleCalculator.calculate("2+3"));
        assertEquals(10, SimpleCalculator.calculate("5+5"));
        assertEquals(15, SimpleCalculator.calculate("10+5"));
    }

    @Test
    public void testSubtraction() {
        assertEquals(3, SimpleCalculator.calculate("5-2"));
        assertEquals(5, SimpleCalculator.calculate("10-5"));
        assertEquals(0, SimpleCalculator.calculate("5-5"));
    }

    @Test
    public void testMixedOperations() {
        assertEquals(4, SimpleCalculator.calculate("7+1-4"));
        assertEquals(13, SimpleCalculator.calculate("10-2+5"));
        assertEquals(5, SimpleCalculator.calculate("5-2+1-3+4"));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(7, SimpleCalculator.calculate("7"));
    }
}
