package br.com.meupet.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdotanteDTO {

    @Schema(description = "Nome do adotante.",
    example = "Bruce Dickinson."
    )
    @NotBlank(message = "O nome do adotante é obrigatório."
    )
    private String nome;

    @Schema(description = "Número de telefone do adotante.",
    example = "(21) 2121-0000 / (21) 99999-0000.")
    @NotBlank(message = "O número de telefone do adotante é obrigatório."
    )
    private String telefone;

    @Schema(description = "CPF do adotante.",
    example = "123.456.789-00")
    @NotBlank(message = "O CPF do adotante é obrigatório."
    )
    private String cpf;

    @Schema(description = "Endereço do adotante",
    example = "R. São José, 90 - Centro, Rio de Janeiro - RJ, 20010-020."
    )
    private String endereco;

    @Email(message = "Informe um E-mail válido.")
    private String email;

    private String observacoes;

}
