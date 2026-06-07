package br.com.meupet.controller;

import br.com.meupet.dto.AdocaoDTO;
import br.com.meupet.entity.Adocao;
import br.com.meupet.service.AdocaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adocoes")
@RequiredArgsConstructor
@Tag(name = "Adoções")
public class AdocaoController {

    private final AdocaoService service;

    @PostMapping
    public Adocao realizarAdocao(
            @RequestBody @Valid AdocaoDTO dto
    ) {
        return service.realizarAdocao(dto);
    }

}