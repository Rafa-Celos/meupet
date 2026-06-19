package br.com.meupet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "castracoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Castracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataCastracao;

    @Column(length = 1000)
    private String observacoes;

    @OneToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}