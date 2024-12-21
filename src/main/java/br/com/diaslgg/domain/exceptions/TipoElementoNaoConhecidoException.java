package br.com.diaslgg.domain.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {

    private static final long serialVersionUID = -1389494676398525746L;

    public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }
}
