package com.project.picpayexec.infra.exceptions;

public class InsuficienteAmountException extends Exception {
    public InsuficienteAmountException(String message) {
        super(message);
    }
}
