package br.com.meupet.service;

import br.com.meupet.dto.DespesaDTO;
import br.com.meupet.entity.Animal;
import br.com.meupet.entity.Despesa;
import br.com.meupet.exception.RegraDeNegocioException;
import br.com.meupet.exception.ResourceNotFoundException;
import br.com.meupet.repository.AnimalRepository;
import br.com.meupet.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaService {

    private final DespesaRepository repository;
    private final AnimalRepository animalRepository;

    public List<Despesa> listarTodas() {
        return repository.findAll();
    }

    public Despesa buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Despesa não encontrada."
                        )
                );
    }

    public List<Despesa> listarPorAnimal(
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
        );
    }

    public Despesa salvar(
            DespesaDTO dto
    ) {

        Animal animal = animalRepository.findById(
                dto.getAnimalId()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Animal não encontrado."
                )
        );

        if (!animal.isAtivo()) {
            throw new RegraDeNegocioException(
                    "Não é possível registrar despesas para um animal inativo."
            );
        }

        if (dto.getDataDespesa().isAfter(
                LocalDate.now()
        )) {
            throw new RegraDeNegocioException(
                    "A data da despesa não pode ser futura."
            );
        }

        Despesa despesa = Despesa.builder()
                .descricao(dto.getDescricao())
                .categoria(dto.getCategoria())
                .valor(dto.getValor())
                .dataDespesa(dto.getDataDespesa())
                .observacoes(dto.getObservacoes())
                .animal(animal)
                .build();

        return repository.save(
                despesa
        );
    }
}