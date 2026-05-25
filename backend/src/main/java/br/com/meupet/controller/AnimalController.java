package br.com.meupet.controller;

import br.com.meupet.dto.AnimalDTO;
import br.com.meupet.entity.Animal;
import br.com.meupet.service.AnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService service;

    @GetMapping
    public List<Animal> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Animal buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Animal salvar(@RequestBody @Valid AnimalDTO dto) {
        return service.salvar(dto);
    }
}