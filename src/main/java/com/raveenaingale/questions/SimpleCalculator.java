package com.raveenaingale.questions;

import com.raveenaingale.oops.concreteClasses.Stack;

public class SimpleCalculator {
    public static int calculate(String expression) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        char[] arr = expression.toCharArray();
        int num = 0; // Temporary variable to store multi-digit numbers

        for (char c : arr) {
            if (isNumber(c)) {
                num = num * 10 + (c - '0'); // Build multi-digit numbers
            } else {
                numbers.push(num); // Push the complete number to the numbers stack
                num = 0; // Reset num for the next number

                // Handle operators
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    applyOperator(numbers, operators);
                }

                operators.push(c);
            }
        }

        numbers.push(num); // Push the last number

        // Process remaining operators
        while (!operators.isEmpty()) {
            applyOperator(numbers, operators);
        }

        // The final result should be at the top of the numbers stack
        return numbers.pop();
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0; // Assuming all other characters have lower precedence
    }

    private static void applyOperator(Stack<Integer> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        int operand2 = numbers.pop();
        int operand1 = numbers.pop();

        switch (operator) {
            case '+':
                numbers.push(operand1 + operand2);
                break;
            case '-':
                numbers.push(operand1 - operand2);
                break;
            case '*':
                numbers.push(operand1 * operand2);
                break;
            case '/':
                numbers.push(operand1 / operand2);
                break;
        }
    }

}

