package com.arieldev22.todo_list_app.service;

import com.arieldev22.todo_list_app.exceptions.TodoArgumentException;
import com.arieldev22.todo_list_app.exceptions.TodoNotFoundException;
import com.arieldev22.todo_list_app.model.Todo;
import com.arieldev22.todo_list_app.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);

        return listAll();
    }

    public List<Todo> listAll() {
        Sort sort = Sort.by("dueDate").ascending()
                .and(Sort.by("priority").ascending())
                .and(Sort.by("name").ascending());

        return todoRepository.findAll(sort);
    }

    public List<Todo> getByName(String name) {
        if (name.isBlank()) {
            throw new TodoArgumentException("name is in blank.");
        } else {
            return todoRepository.findByName(name);
        }
    }

    public List<Todo> getByPriority(int priority) {
        return todoRepository.findByPriority(priority);
    }

    public List<Todo> getByDueDate(String date) {
        LocalDate dueDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (dueDate.isBefore(LocalDate.now())) {
            throw new TodoArgumentException("invalid date.");
        } else {
            return todoRepository.findByDueDate(dueDate);
        }
    }

    public List<Todo> update(Todo todo) {
        if (todoRepository.findById(todo.getId()).isPresent()) {
            if (todo.isCompleted()) {
                return deleteById(todo.getId());
            } else {
                todoRepository.save(todo);
                return listAll();
            }
        } else {
            throw new TodoNotFoundException();
        }
    }

    public List<Todo> deleteById(Long id) {
        if (todoRepository.findById(id).isPresent()) {
            todoRepository.deleteById(id);

            return listAll();
        } else {
            throw new TodoNotFoundException();
        }
    }
}
