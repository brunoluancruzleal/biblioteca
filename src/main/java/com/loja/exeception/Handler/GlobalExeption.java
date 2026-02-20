package com.loja.exeception.Handler;

import com.loja.exeception.ExeceptionResponde;
import com.loja.exeception.SearchExceptionNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@RestController
public class GlobalExeption extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SearchExceptionNotFound.class)
    public final ResponseEntity<ExeceptionResponde> handleResponde(SearchExceptionNotFound ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExeceptionResponde execeptionResponde =
                new ExeceptionResponde(
                        "A busca não foi bem sucedida",
                        status.value(),
                        new Date(),
                        ex.getMessage()
                );
        return ResponseEntity.status(status).body(execeptionResponde);

    }
}
