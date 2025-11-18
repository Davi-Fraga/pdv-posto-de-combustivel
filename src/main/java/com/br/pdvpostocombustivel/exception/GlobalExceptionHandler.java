package com.br.pdvpostocombustivel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoException.class)
    public ResponseEntity<Object> handleProdutoException(ProdutoException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        // Retorna HTTP 409 (Conflict), que é adequado para indicar
        // que a requisição não pôde ser completada devido a um conflito
        // com o estado atual do recurso (neste caso, uma referência duplicada).
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
}
