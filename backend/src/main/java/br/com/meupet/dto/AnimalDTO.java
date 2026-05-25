package br.com.meupet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimalDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Espécie é obrigatória")
    private String especie;

    private String raca;

    @NotNull(message = "Idade é obrigatória")
    private Integer idade;

    private String sexo;

    private String porte;

    private String status;

    private String observacoes;
}