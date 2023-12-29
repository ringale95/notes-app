package com.raveenaingale.questions;

public class TextEditor {
    private StringBuilder text;

    public TextEditor() {
        // Initialize the text editor with an empty text
        text = new StringBuilder();

    }

    public void type(char character) {
        // Your implementation here
        // Add the given character to the current text

    }

    public void undo() {
        // Your implementation here
        // Undo the last type operation by removing the last character from the text
    }

    public String getText() {
        // Your implementation here
        // Return the current text in the editor
        return text.toString();
    }
}
