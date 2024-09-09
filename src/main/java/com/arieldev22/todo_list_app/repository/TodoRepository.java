package com.arieldev22.todo_list_app.repository;

import com.arieldev22.todo_list_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query("SELECT t FROM Todo t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Todo> findByName(String name);

    List<Todo> findByPriority(int priority);

    List<Todo> findByDueDate(LocalDate dueDate);
}
