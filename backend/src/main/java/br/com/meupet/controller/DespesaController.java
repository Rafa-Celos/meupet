package br.com.meupet.controller;

import br.com.meupet.dto.DespesaDTO;
import br.com.meupet.entity.Despesa;
import br.com.meupet.service.DespesaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
@RequiredArgsConstructor
@Tag(name = "Despesas")
public class DespesaController {

    private final DespesaService service;

    @GetMapping
    public List<Despesa> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Despesa buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @GetMapping("/animal/{animalId}")
    public List<Despesa> listarPorAnimal(
            @PathVariable Long animalId
    ) {
        return service.listarPorAnimal(
                animalId
        );
    }

    @PostMapping
    public Despesa salvar(
            @RequestBody
            @Valid
            DespesaDTO dto
    ) {
        return service.salvar(dto);
    }
}