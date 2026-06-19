package br.com.meupet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VacinacaoDTO {

    @NotBlank(message = "O nome da vacina é obrigatório.")
    private String vacina;

    @NotNull(message = "A data da aplicação é obrigatória.")
    private LocalDate dataAplicacao;

    private LocalDate proximaDose;

    private String observacoes;

    @NotNull(message = "O animal é obrigatório.")
    private Long animalId;
}