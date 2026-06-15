package br.com.meupet.repository;

import br.com.meupet.entity.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdotanteRepository
        extends JpaRepository<Adotante, Long> {

    Boolean existsByCpf(String cpf);

    List<Adotante> findByAtivoTrue();
    
    Boolean existsByCpfAndIdNot(
            String cpf,
            Long id
    );
}