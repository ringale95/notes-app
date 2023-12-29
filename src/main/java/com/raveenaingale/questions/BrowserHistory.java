package com.raveenaingale.questions;

import com.raveenaingale.oops.concreteClasses.Stack;

public class BrowserHistory {
    private Stack<String> history;

    public BrowserHistory() {
        // Initialize the browser history with an empty stack
        history = new Stack<>();
    }

    public void visit(String page) {
        // Your implementation here
        // Add the visited page to the browser history
    }

    public String back() {
        // Your implementation here
        // Navigate back to the previous page and return the current page
        // If there is no previous page, return an appropriate message
        return null;
    }

    public String getCurrentPage() {
        // Your implementation here
        // Return the current page in the browser history
        // If the history is empty, return an appropriate message
        return history.isEmpty() ? "No pages visited yet" : history.peek();
    }
}