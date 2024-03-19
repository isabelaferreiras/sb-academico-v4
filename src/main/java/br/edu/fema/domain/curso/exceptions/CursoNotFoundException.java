package br.edu.fema.domain.curso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CursoNotFoundException extends RuntimeException{

    private final String id;

    public CursoNotFoundException(String id){
        super();
        this.id = id;
    }

    @Override
    public String getMessage() {
        final String message = String.format("Curso não localizado para ID = %s", id);
        return message;
    }
}
