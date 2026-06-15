package br.com.meupet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> tratarValidacao(
            MethodArgumentNotValidException ex
    ) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        erros.put(
                                error.getField(),
                                error.getDefaultMessage()
                        ));

        return erros;
    }

    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity<Map<String, String>> tratarCpfDuplicado(
            CpfJaCadastradoException ex
    ) {

        Map<String, String> erro = new HashMap<>();

        erro.put("cpf", ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(erro);
    }

    @ExceptionHandler(AnimalIndisponivelException.class)
    public ResponseEntity<Map<String, String>> tratarAnimalIndisponivel(
            AnimalIndisponivelException ex
    ) {

        Map<String, String> erro = new HashMap<>();

        erro.put("adocao", ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(erro);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>>
    tratarRecursoNaoEncontrado(
            ResourceNotFoundException ex
    ) {

        Map<String, String> erro = new HashMap<>();

        erro.put("erro", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erro);
    }

    @ExceptionHandler(
            EntidadePossuiVinculosException.class
    )
    public ResponseEntity<Map<String, String>>
    tratarEntidadePossuiVinculos(
            EntidadePossuiVinculosException ex
    ) {

        Map<String, String> erro =
                new HashMap<>();

        erro.put("erro", ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(erro);
    }

    @ExceptionHandler(
            EntidadeInativaException.class
    )
    public ResponseEntity<Map<String, String>>
    tratarEntidadeInativa(
            EntidadeInativaException ex
    ) {

        Map<String, String> erro =
                new HashMap<>();

        erro.put("erro", ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(erro);
    }
}