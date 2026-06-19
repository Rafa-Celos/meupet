package br.com.meupet.repository;

import br.com.meupet.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesaRepository
        extends JpaRepository<Despesa, Long> {

    List<Despesa> findByAnimalId(
            Long animalId
    );
}