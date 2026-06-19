package br.com.meupet.repository;

import br.com.meupet.entity.Vacinacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacinacaoRepository
        extends JpaRepository<Vacinacao, Long> {

    List<Vacinacao> findByAnimalId(Long animalId);
}