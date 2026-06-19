package br.com.meupet.service;

import br.com.meupet.dto.VacinacaoDTO;
import br.com.meupet.entity.Animal;
import br.com.meupet.entity.Vacinacao;
import br.com.meupet.exception.RegraDeNegocioException;
import br.com.meupet.exception.ResourceNotFoundException;
import br.com.meupet.repository.AnimalRepository;
import br.com.meupet.repository.VacinacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacinacaoService {

    private final VacinacaoRepository repository;
    private final AnimalRepository animalRepository;

    public Vacinacao salvar(VacinacaoDTO dto) {

        Animal animal = animalRepository.findById(
                dto.getAnimalId()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Animal não encontrado."
                )
        );

        if (!animal.isAtivo()) {
            throw new RegraDeNegocioException(
                    "Não é possível registrar vacinação para um animal inativo."
            );
        }

        if (dto.getDataAplicacao().isAfter(
                LocalDate.now()
        )) {
            throw new RegraDeNegocioException(
                    "A data de aplicação não pode ser futura."
            );
        }

        if (dto.getProximaDose() != null
                && dto.getProximaDose().isBefore(
                dto.getDataAplicacao()
        )) {
            throw new RegraDeNegocioException(
                    "A próxima dose deve ser posterior à data de aplicação."
            );
        }

        Vacinacao vacinacao = Vacinacao.builder()
                .vacina(dto.getVacina())
                .dataAplicacao(
                        dto.getDataAplicacao()
                )
                .proximaDose(
                        dto.getProximaDose()
                )
                .observacoes(
                        dto.getObservacoes()
                )
                .animal(animal)
                .build();

        return repository.save(vacinacao);
    }

    public Vacinacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vacinação não encontrada."
                        )
                );
    }

    public List<Vacinacao> listarPorAnimal(
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
}