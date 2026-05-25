package br.com.meupet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimalDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "A espécie é obrigatória.")
    private String especie;

    private String raca;

    @NotNull(message = "A idade é obrigatória.")
    private Integer idade;

    private String sexo;

    private String porte;

    private String status;

    private String observacoes;
}