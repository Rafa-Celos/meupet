package br.com.meupet.controller;

import br.com.meupet.dto.AnimalDTO;
import br.com.meupet.entity.Animal;
import br.com.meupet.service.AnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/animais")
@RequiredArgsConstructor

@Tag(
        name = "Animais",
        description = "Operações relacionadas aos animais."
)

public class AnimalController {

    private final AnimalService service;


    @Operation(
            summary = "Listar animais.",
            description = "Retorna todos os animais cadastrados."
    )
    @GetMapping
    public List<Animal> listar() {
        return service.listarTodos();
    }

    @Operation(
            summary = "Buscar animal por ID.",
            description = "Retorna um animal pelo específico pelo ID."
    )
    @GetMapping("/{id}")
    public Animal buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(
            summary = "Cadastrar animal.",
            description = "Cadastra um novo animal para adoção."
    )
    @PostMapping
    public Animal salvar(@RequestBody @Valid AnimalDTO dto) {
        return service.salvar(dto);
    }

    @Operation(
            summary = "Atualizar os dados do animal."
    )
    @PutMapping("/{id}")
    public Animal atualizar(
            @PathVariable Long id,
            @RequestBody @Valid AnimalDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id
    ) {
        service.excluir(id);
    }
}