package br.com.meupet.exception;

public class AnimalIndisponivelException extends RuntimeException {

    public AnimalIndisponivelException(String mensagem) {
        super(mensagem);
    }
}