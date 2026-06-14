package br.com.meupet.service;

import br.com.meupet.dto.AdocaoDTO;
import br.com.meupet.entity.*;
import br.com.meupet.exception.AnimalIndisponivelException;
import br.com.meupet.exception.ResourceNotFoundException;
import br.com.meupet.repository.AdocaoRepository;
import br.com.meupet.repository.AdotanteRepository;
import br.com.meupet.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AdocaoService {

    private final AdocaoRepository adocaoRepository;
    private final AnimalRepository animalRepository;
    private final AdotanteRepository adotanteRepository;

    public Adocao realizarAdocao(AdocaoDTO dto) {

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Animal não encontrado."
                        )
                );

        Adotante adotante = adotanteRepository.findById(dto.getAdotanteId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Adotante não encontrado."
                        )
                );

        if (animal.getStatus() != StatusAnimal.DISPONIVEL) {
            throw new AnimalIndisponivelException(
                    "O animal não está disponível para adoção."
            );
        }

        Adocao adocao = Adocao.builder()
                .animal(animal)
                .adotante(adotante)
                .observacoes(dto.getObservacoes())
                .dataAdocao(LocalDate.now())
                .build();

        animal.setStatus(StatusAnimal.ADOTADO);

        animalRepository.save(animal);

        return adocaoRepository.save(adocao);
    }
}