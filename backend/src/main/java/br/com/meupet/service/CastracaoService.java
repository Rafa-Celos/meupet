package br.com.meupet.service;

import br.com.meupet.dto.CastracaoDTO;
import br.com.meupet.entity.Animal;
import br.com.meupet.entity.Castracao;
import br.com.meupet.exception.RegraDeNegocioException;
import br.com.meupet.exception.ResourceNotFoundException;
import br.com.meupet.repository.AnimalRepository;
import br.com.meupet.repository.CastracaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CastracaoService {

    private final CastracaoRepository repository;
    private final AnimalRepository animalRepository;

    public Castracao salvar(CastracaoDTO dto) {

        Animal animal = animalRepository.findById(
                dto.getAnimalId()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Animal não encontrado."
                )
        );

        if (!animal.isAtivo()) {
            throw new RegraDeNegocioException(
                    "Não é possível registrar castração para um animal inativo."
            );
        }

        if (dto.getDataCastracao().isAfter(
                LocalDate.now()
        )) {
            throw new RegraDeNegocioException(
                    "A data da castração não pode ser futura."
            );
        }

        if (repository.existsByAnimalId(
                dto.getAnimalId()
        )) {
            throw new RegraDeNegocioException(
                    "O animal já possui registro de castração."
            );
        }

        Castracao castracao = Castracao.builder()
                .dataCastracao(
                        dto.getDataCastracao()
                )
                .observacoes(
                        dto.getObservacoes()
                )
                .animal(animal)
                .build();

        return repository.save(castracao);
    }

    public Castracao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Castração não encontrada."
                        )
                );
    }

    public Castracao buscarPorAnimal(
            Long animalId
    ) {

        animalRepository.findById(animalId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Animal não encontrado."
                        )
                );

        return repository.findByAnimalId(
                animalId
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Castração não encontrada."
                )
        );
    }
}