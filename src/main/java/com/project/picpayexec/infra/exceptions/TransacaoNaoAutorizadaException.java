package com.project.picpayexec.infra.exceptions;

public class TransacaoNaoAutorizadaException extends Exception{

    public TransacaoNaoAutorizadaException(String message) {
        super(message);
    }
}
