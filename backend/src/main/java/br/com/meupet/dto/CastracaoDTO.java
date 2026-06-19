package br.com.meupet.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CastracaoDTO {

    @NotNull(
            message =
                    "A data da castração é obrigatória."
    )
    private LocalDate dataCastracao;

    private String observacoes;

    @NotNull(
            message =
                    "O animal é obrigatório."
    )
    private Long animalId;
}