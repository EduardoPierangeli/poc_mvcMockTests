package com.example.testingweb.config;

import com.example.testingweb.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GreetingAdvice {
    /**
     * Captura a exceção padrão do Java, registrando o erro e relançando o mesmo.
     *
     * @param exception a exceção qualquer lançada em outra parte da aplicação e captura pelo ControllerAdvice.
     * @return {@link ResponseEntity} Um ResponseEntity construído a partir da exceção capturada.
     */
    @ExceptionHandler(value = { CustomException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomException> exception(CustomException exception) {
        return ResponseEntity.internalServerError().body(exception);
    }
}
