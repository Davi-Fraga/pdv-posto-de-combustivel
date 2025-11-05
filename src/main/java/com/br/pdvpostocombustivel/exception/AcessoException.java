package com.br.pdvpostocombustivel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED) // Retorna 401 para erros de autenticação
public class AcessoException extends RuntimeException {
    public AcessoException(String message) {
        super(message);
    }
}
