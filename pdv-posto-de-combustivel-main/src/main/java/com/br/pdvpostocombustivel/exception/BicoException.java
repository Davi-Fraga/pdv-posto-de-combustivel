package com.br.pdvpostocombustivel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BicoException extends RuntimeException {
    public BicoException(String message) { super(message); }
}