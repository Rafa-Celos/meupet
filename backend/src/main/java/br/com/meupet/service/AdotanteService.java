package br.com.meupet.service;

import br.com.meupet.dto.AdotanteDTO;
import br.com.meupet.entity.Adotante;
import br.com.meupet.exception.CpfJaCadastradoException;
import br.com.meupet.exception.EntidadeInativaException;
import br.com.meupet.exception.EntidadePossuiVinculosException;
import br.com.meupet.exception.ResourceNotFoundException;
import br.com.meupet.repository.AdocaoRepository;
import br.com.meupet.repository.AdotanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Service
@RequiredArgsConstructor
public class AdotanteService {

    private final AdotanteRepository repository;
    private final AdocaoRepository adocaoRepository;

    public List<Adotante> listarTodos() {
        return repository.findByAtivoTrue();
    }

    public Adotante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Adotante não encontrado."
                        )
                );
    }

    public Adotante salvar(AdotanteDTO dto) {

        if (repository.existsByCpf(dto.getCpf())) {
            throw new CpfJaCadastradoException(
                    "O CPF já está cadastrado."
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
                .ativo(true)
                .build();

        return repository.save(adotante);
    }

    public Adotante atualizar(
            Long id,
            AdotanteDTO dto
    ) {

        Adotante adotante = buscarPorId(id);

        if (repository.existsByCpfAndIdNot(
                dto.getCpf(),
                id
        )) {
            throw new CpfJaCadastradoException(
                    "O CPF já está cadastrado."
            );
        }

        adotante.setNome(dto.getNome());
        adotante.setTelefone(dto.getTelefone());
        adotante.setEmail(dto.getEmail());
        adotante.setCpf(dto.getCpf());
        adotante.setEndereco(dto.getEndereco());
        adotante.setObservacoes(dto.getObservacoes());

        return repository.save(adotante);
    }

    public void excluir(Long id) {

        Adotante adotante = buscarPorId(id);

        if (!adotante.isAtivo()) {
            throw new EntidadeInativaException(
                    "O adotante já está inativo."
            );
        }

        if (adocaoRepository
                .existsByAdotanteId(id)) {

            throw new
                    EntidadePossuiVinculosException(
                    "O adotante possui adoções vinculadas."
            );
        }

        adotante.setAtivo(false);

        repository.save(adotante);
    }
}