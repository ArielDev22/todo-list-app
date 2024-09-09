package com.arieldev22.todo_list_app.controller;

import com.arieldev22.todo_list_app.model.Todo;
import com.arieldev22.todo_list_app.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<List<Todo>> create(@RequestBody @Valid Todo todo) {
        return ResponseEntity.ok(todoService.create(todo));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listAll() {
        return ResponseEntity.ok(todoService.listAll());
    }

    @GetMapping("/name")
    public ResponseEntity<List<Todo>> getByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(todoService.getByName(name));
    }

    @GetMapping("/priority")
    public ResponseEntity<List<Todo>> getByPriority(@RequestParam("priority") int priority) {
        return ResponseEntity.ok(todoService.getByPriority(priority));
    }

    @GetMapping("/date")
    public ResponseEntity<List<Todo>> getByPriority(@RequestParam("date") String date) {
        return ResponseEntity.ok(todoService.getByDueDate(date));
    }

    @PutMapping
    public ResponseEntity<List<Todo>> update(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.update(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Todo>> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.deleteById(id));
    }
}
