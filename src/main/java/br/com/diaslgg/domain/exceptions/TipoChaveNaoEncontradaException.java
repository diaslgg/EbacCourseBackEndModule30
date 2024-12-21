package br.com.diaslgg.domain.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

    private static final long serialVersionUID = -2268140970978666251L;

    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
