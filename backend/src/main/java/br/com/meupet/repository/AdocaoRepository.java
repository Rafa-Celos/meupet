package br.com.meupet.repository;

import br.com.meupet.entity.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdocaoRepository extends JpaRepository<Adocao, Long> {
}
