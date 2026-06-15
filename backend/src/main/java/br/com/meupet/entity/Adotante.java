package br.com.meupet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "adotantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adotante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private String telefone;

    private String email;

    @Column(unique = true)
    private String cpf;

    private String endereco;

    @Column(length = 1000)
    private String observacoes;

    private LocalDate dataCadastro;

    private boolean ativo;
}
