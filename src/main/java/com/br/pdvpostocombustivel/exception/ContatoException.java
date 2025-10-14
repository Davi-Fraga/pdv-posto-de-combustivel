package com.br.pdvpostocombustivel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // Retorna 400 para erros de dados de contato
public class ContatoException extends RuntimeException {
    public ContatoException(String message) {
        super(message);
    }
}
