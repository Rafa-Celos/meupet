package br.com.meupet.repository;

import br.com.meupet.entity.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdotanteRepository extends JpaRepository<Adotante, Long> {
    boolean existsByCpf(String cpf);
}
