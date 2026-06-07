package br.com.meupet.controller;

import br.com.meupet.dto.AdotanteDTO;
import br.com.meupet.entity.Adotante;
import br.com.meupet.service.AdotanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adotantes")
@RequiredArgsConstructor
@Tag(
        name = "Adotantes",
        description = "Operações relacionadas aos adotantes."
)
public class AdotanteController {

    private final AdotanteService service;

    @Operation(
            summary = "Listar adotantes",
            description = "Retorna todos os adotantes cadastrados."
    )
    @GetMapping
    public List<Adotante> listar() {
        return service.listarTodos();
    }

    @Operation(
            summary = "Buscar adotante por ID.",
            description = "Retorna um adotante específico."
    )
    @GetMapping("/{id}")
    public Adotante buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(
            summary = "Cadastrar adotante.",
            description = "Cadastra um novo adotante."
    )
    @PostMapping
    public Adotante salvar(@RequestBody @Valid AdotanteDTO dto) {
        return service.salvar(dto);
    }
}