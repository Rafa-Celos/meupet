package br.com.meupet.exception;

public class RegraDeNegocioException
        extends RuntimeException {

    public RegraDeNegocioException(
            String mensagem
    ) {
        super(mensagem);
    }
}