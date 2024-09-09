package com.arieldev22.todo_list_app.exceptions;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException() {
        super("todo not found.");
    }
}
