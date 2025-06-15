package b9l.todo.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import b9l.todo.api.model.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiError> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError(exception.getMessage()));
    }

    @ExceptionHandler(value = TodoBadRequestException.class)
    public ResponseEntity<ApiError> handleException(TodoBadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(exception.getMessage()));
    }

    @ExceptionHandler(value = TodoNotFoundException.class)
    public ResponseEntity<ApiError> handleException(TodoNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(exception.getMessage()));
    }

}
