package com.raveenaingale.leetcode;

import com.raveenaingale.oops.concreteClasses.Bag;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesisTest {

    @Test
    public void testCase1(){
        ValidParenthesis valid = new ValidParenthesis();
        assertTrue(valid.isValid("()"));
    }

    @Test
    public void testCase2(){
        ValidParenthesis valid = new ValidParenthesis();
        assertTrue(valid.isValid("()[]{}"));
    }

    @Test
    public void testCase3(){
//        ValidParenthesis valid = new ValidParenthesis();
//        assertFalse(valid.isValid("(]"));
    }
}
