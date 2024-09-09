package com.arieldev22.todo_list_app.model.enums;

import com.arieldev22.todo_list_app.exceptions.TodoArgumentException;

public enum TodoPriority {
    PRIORITY_1(1),
    PRIORITY_2(2),
    PRIORITY_3(3),
    PRIORITY_4(4);

    private int value;

    TodoPriority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int valueOf(int value) {
        for (TodoPriority priority : TodoPriority.values()) {
            if (priority.getValue() == value) {
                return priority.getValue();
            }
        }
        throw new TodoArgumentException("undefined priority value.");
    }
}
