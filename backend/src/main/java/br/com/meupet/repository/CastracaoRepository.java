package br.com.meupet.repository;

import br.com.meupet.entity.Castracao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CastracaoRepository
        extends JpaRepository<Castracao, Long> {

    Optional<Castracao>
    findByAnimalId(Long animalId);

    boolean existsByAnimalId(Long animalId);
}