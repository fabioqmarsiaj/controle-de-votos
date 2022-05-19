package com.assembleia.controledevotos.exception;

public class AssociadoCadastradoException extends Throwable {

    public AssociadoCadastradoException() {
        super("Associado já cadastrado.");
    }
}
