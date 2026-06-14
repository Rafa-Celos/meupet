package br.com.meupet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "adocoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAdocao;

    @Column(length = 1000)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "adotante_id")
    private Adotante adotante;
}