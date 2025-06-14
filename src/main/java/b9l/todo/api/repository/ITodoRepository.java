package b9l.todo.api.repository;
import b9l.todo.api.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends JpaRepository<Todo, Long> {

    

}
