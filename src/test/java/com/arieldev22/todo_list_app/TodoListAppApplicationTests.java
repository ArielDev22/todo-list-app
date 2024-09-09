package com.arieldev22.todo_list_app;

import com.arieldev22.todo_list_app.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListAppApplicationTests {
	@Autowired
	private WebTestClient testClient;

	@Test
	void todoSuccessTest() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		var todo = new Todo("teste", "teste todo", 1, LocalDate.now(), false);

		testClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(todo.getName())
				.jsonPath("$[0].description").isEqualTo(todo.getDescription())
				.jsonPath("$[0].priority").isEqualTo(todo.getPriority())
				.jsonPath("$[0].dueDate").isEqualTo(formatter.format(todo.getDueDate()))
				.jsonPath("$[0].completed").isEqualTo(todo.isCompleted());
	}

	@Test
	void todoFailureTest(){
		var todo = new Todo("", "teste todo", 1, LocalDate.now(), false);

		testClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isBadRequest();
	}
}
