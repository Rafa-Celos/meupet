package br.com.meupet.service;

import br.com.meupet.dto.AnimalDTO;
import br.com.meupet.entity.Animal;
import br.com.meupet.entity.StatusAnimal;
import br.com.meupet.exception.ResourceNotFoundException;
import br.com.meupet.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository repository;

    public List<Animal> listarTodos() {
        return repository.findAll();
    }

    public Animal buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Animal não encontrado."
                        )
                );
    }

    public Animal salvar(AnimalDTO dto) {

        Animal animal = Animal.builder()
                .nome(dto.getNome())
                .especie(dto.getEspecie())
                .raca(dto.getRaca())
                .idade(dto.getIdade())
                .sexo(dto.getSexo())
                .porte(dto.getPorte())
                .status(
                        dto.getStatus() != null
                                ? dto.getStatus()
                                : StatusAnimal.DISPONIVEL
                )
                .observacoes(dto.getObservacoes())
                .build();

        return repository.save(animal);
    }

    public Animal atualizar(Long id, AnimalDTO dto) {

        Animal animal = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Animal não encontrado."
                        )
                );

        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setRaca(dto.getRaca());
        animal.setIdade(dto.getIdade());
        animal.setSexo(dto.getSexo());
        animal.setPorte(dto.getPorte());
        animal.setObservacoes(dto.getObservacoes());

        if (dto.getStatus() != null) {
            animal.setStatus(dto.getStatus());
        }

        return repository.save(animal);
    }
}