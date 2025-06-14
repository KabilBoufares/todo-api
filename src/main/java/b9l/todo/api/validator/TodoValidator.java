package b9l.todo.api.validator;

import java.util.Objects;

import org.springframework.stereotype.Service;

import b9l.todo.api.model.Todo;
import b9l.todo.api.utils.StringUtils;

@Service
public class TodoValidator implements ItodoValidator {

    @Override
    public void validate(Todo todo) {
        if (todo == null) {
            throw new IllegalArgumentException("Todo cannot be null");
        }
        if (StringUtils.isBlank(todo.getTitle())) {
            throw new IllegalArgumentException("Todo title cannot be blank");
        }
        if (StringUtils.isBlank(todo.getDescription())) {
            throw new IllegalArgumentException("Todo description cannot be blank");
        }
        if (Objects.isNull(todo.getCompleted())) {
            throw new IllegalArgumentException("Todo completed status cannot be null");
        }
    }

}
