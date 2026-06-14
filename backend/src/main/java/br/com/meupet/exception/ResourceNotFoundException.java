package br.com.meupet.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}