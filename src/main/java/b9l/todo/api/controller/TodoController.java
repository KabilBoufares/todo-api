package b9l.todo.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import b9l.todo.api.exception.TodoNotFoundException;
import b9l.todo.api.model.Todo;
import b9l.todo.api.repository.ITodoRepository;

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

    @GetMapping
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }
    
    @GetMapping("{id}")
    public Todo getById(@PathVariable Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }
    
    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return todoRepository.save(todo);
        
    }

    @PutMapping("{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        var entity = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        entity.setTitle(todo.getTitle());
        entity.setDescription(todo.getDescription());
        entity.setCompleted(todo.isCompleted());
        todoRepository.save(entity);
        return entity;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        var entity = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        todoRepository.delete(entity);
    }
}
