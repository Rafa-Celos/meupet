package br.com.meupet.controller;

import br.com.meupet.dto.CastracaoDTO;
import br.com.meupet.entity.Animal;
import br.com.meupet.entity.Castracao;
import br.com.meupet.service.CastracaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/castracoes")
@RequiredArgsConstructor
@Tag(name = "Castrações")
public class CastracaoController {

    private final CastracaoService service;

    @PostMapping
    public Castracao salvar(
            @RequestBody @Valid CastracaoDTO dto
    ) {
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public Castracao buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @GetMapping("/animal/{animalId}")
    public Castracao buscarPorAnimal(
            @PathVariable Long animalId
    ) {
        return service.buscarPorAnimal(animalId);
    }

    @OneToOne
    @JoinColumn(
            name = "animal_id",
            unique = true
    )
    private Animal animal;
}