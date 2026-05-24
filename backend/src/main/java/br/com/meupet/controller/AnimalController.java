package br.com.meupet.controller;

import br.com.meupet.entity.Animal;
import br.com.meupet.service.AnimalService;
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

    @PostMapping
    public Animal salvar(@RequestBody Animal animal) {
        return service.salvar(animal);
    }
}