package br.com.meupet.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdocaoDTO {

    @NotNull
    private Long animalId;

    @NotNull
    private Long adotanteId;

    private String observacoes;
}