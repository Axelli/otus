package axelli.otus.userservice.config;

import axelli.otus.userservice.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({
        ResourceNotFoundException.class,
        EmptyResultDataAccessException.class
    })
    public void notFound(Exception e) {
        log.error(e.getMessage(), e);
    }

}
