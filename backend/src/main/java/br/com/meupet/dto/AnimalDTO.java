package br.com.meupet.dto;

import br.com.meupet.entity.StatusAnimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class AnimalDTO {

    @Schema(description = "Nome do animal",
    example = "Jullyetta"
    )
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @Schema(description = "Espécie do animal",
    example = "Gato"
    )
    @NotBlank(message = "A espécie é obrigatória.")
    private String especie;

    private String raca;

    @Schema(description = "Idade do animal",
    example = "8"
    )
    @NotNull(message = "A idade é obrigatória.")
    private Integer idade;

    private String sexo;

    private String porte;

    private StatusAnimal status;

    private String observacoes;
}