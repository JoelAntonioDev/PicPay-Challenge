package com.project.picpayexec.infra.exceptions;

import com.project.picpayexec.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário já cadastrado","400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threatEntityNotFound(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatException(Exception e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(),"500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity threatEntidadeNaoEncontradaException(EntidadeNaoEncontradaException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(InsuficienteAmountException.class)
    public ResponseEntity threatInsuficienteAmountException(InsuficienteAmountException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(TransacaoNaoAutorizadaException.class)
    public ResponseEntity threatTransacaoNaoAutorizadaException(TransacaoNaoAutorizadaException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(UsuarioLojistaException.class)
    public ResponseEntity threatUsuarioLojistaException(UsuarioLojistaException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
