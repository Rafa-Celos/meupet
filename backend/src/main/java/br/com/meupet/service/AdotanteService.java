package br.com.meupet.service;

import br.com.meupet.dto.AdotanteDTO;
import br.com.meupet.entity.Adotante;
import br.com.meupet.exception.CpfJaCadastradoException;
import br.com.meupet.repository.AdotanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdotanteService {

    private final AdotanteRepository repository;

    public List<Adotante> listarTodos() {
        return repository.findAll();
    }

    public Adotante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Adotante salvar(AdotanteDTO dto) {

        if (repository.existsByCpf(dto.getCpf())) {
            throw new CpfJaCadastradoException(
                    "Já existe um adotante cadastrado com este CPF."
            );
        }

        Adotante adotante = Adotante.builder()
                .nome(dto.getNome())
                .telefone(dto.getTelefone())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .endereco(dto.getEndereco())
                .observacoes(dto.getObservacoes())
                .dataCadastro(LocalDate.now())
                .build();

        return repository.save(adotante);
    }
}