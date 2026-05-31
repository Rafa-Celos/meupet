package br.com.meupet.service;

import br.com.meupet.dto.AnimalDTO;
import br.com.meupet.entity.Animal;
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
                .orElseThrow();
    }

    public Animal salvar(AnimalDTO dto) {

        Animal animal = Animal.builder()
                .nome(dto.getNome())
                .especie(dto.getEspecie())
                .raca(dto.getRaca())
                .idade(dto.getIdade())
                .sexo(dto.getSexo())
                .porte(dto.getPorte())
                .status(dto.getStatus())
                .observacoes(dto.getObservacoes())
                .build();

        return repository.save(animal);
    }
}