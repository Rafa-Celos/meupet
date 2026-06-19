package br.com.meupet.controller;

import br.com.meupet.dto.VacinacaoDTO;
import br.com.meupet.entity.Vacinacao;
import br.com.meupet.service.VacinacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacinacoes")
@RequiredArgsConstructor
@Tag(name = "Vacinações")
public class VacinacaoController {

    private final VacinacaoService service;

    @PostMapping
    public Vacinacao salvar(
            @RequestBody @Valid VacinacaoDTO dto
    ) {
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public Vacinacao buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @GetMapping("/animal/{animalId}")
    public List<Vacinacao> listarPorAnimal(
            @PathVariable Long animalId
    ) {
        return service.listarPorAnimal(animalId);
    }
}