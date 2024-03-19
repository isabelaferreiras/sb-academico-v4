package br.edu.fema.domain.curso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CursoDuplicatedException extends RuntimeException {

    private final String id;

    public CursoDuplicatedException(String id){
        super();
        this.id = id;
    }

    @Override
    public String getMessage() {
        final String message =
                String.format("Curso duplicado para ID = %s", id);
        return message;
    }
}
