package com.assembleia.controledevotos.exception;

public class PautaNotFoundException extends Throwable {
    public PautaNotFoundException() {
        super("Pauta não encontrada.");
    }
}
