package b9l.todo.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import b9l.todo.api.exception.TodoNotFoundException;
import b9l.todo.api.model.Todo;
import b9l.todo.api.repository.ITodoRepository;
import b9l.todo.api.validator.ItodoValidator;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/todos")
public class TodoController {
    
    @Autowired
    private ITodoRepository todoRepository;

    @Autowired
    private ItodoValidator todoValidator;

    @Operation(summary = "Get all todos")
    @GetMapping
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Operation(summary = "Get todo by id")
    @GetMapping("{id}")
    public Todo getById(@PathVariable Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Operation(summary = "Create a new todo")
    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        todoValidator.validate(todo);
        return todoRepository.save(todo);
        
    }

    @Operation(summary = "Update an existing todo")
    @PutMapping("{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        todoValidator.validate(todo);
        var entity = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        entity.setTitle(todo.getTitle());
        entity.setDescription(todo.getDescription());
        entity.setCompleted(todo.getCompleted());
        todoRepository.save(entity);
        return entity;
    }

    @Operation(summary = "Delete a todo")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        var entity = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        todoRepository.delete(entity);
    }
}
