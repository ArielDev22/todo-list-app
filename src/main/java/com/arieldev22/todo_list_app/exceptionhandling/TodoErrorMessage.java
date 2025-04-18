package com.arieldev22.todo_list_app.exceptionhandling;

import org.springframework.http.HttpStatus;

public class TodoErrorMessage {
    private HttpStatus status;
    private String message;

    public TodoErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
