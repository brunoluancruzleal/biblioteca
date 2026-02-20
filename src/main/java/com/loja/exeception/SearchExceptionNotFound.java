package com.loja.exeception;

public class SearchExceptionNotFound extends RuntimeException {
    public SearchExceptionNotFound(String message) {
        super(message);
    }
}
