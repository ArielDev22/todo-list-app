package com.arieldev22.todo_list_app.exceptionhandling;

import com.arieldev22.todo_list_app.exceptions.TodoArgumentException;
import com.arieldev22.todo_list_app.exceptions.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TodoExceptionHandler {
    @ExceptionHandler(TodoArgumentException.class)
    private ResponseEntity<TodoErrorMessage> argumentException(TodoArgumentException exception) {
        TodoErrorMessage errorMessage = new TodoErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(TodoNotFoundException.class)
    private ResponseEntity<TodoErrorMessage> notFoundException(TodoNotFoundException exception) {
        TodoErrorMessage errorMessage = new TodoErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
