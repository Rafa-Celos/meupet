package br.com.meupet.dto;

import br.com.meupet.entity.CategoriaDespesa;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DespesaDTO {

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    @NotNull(message = "A categoria é obrigatória.")
    private CategoriaDespesa categoria;

    @NotNull(message = "O valor é obrigatório.")
    @DecimalMin(
            value = "0.01",
            message = "O valor deve ser maior que zero."
    )
    private BigDecimal valor;

    @NotNull(message = "A data da despesa é obrigatória.")
    private LocalDate dataDespesa;

    private String observacoes;

    @NotNull(message = "O animal é obrigatório.")
    private Long animalId;
}