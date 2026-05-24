package br.com.meupet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especie;

    private String raca;

    private Integer idade;

    private String sexo;

    private String porte;

    private String status;

    private LocalDate dataResgate;

    @Column(length = 1000)
    private String observacoes;
}
