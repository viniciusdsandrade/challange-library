package com.restful.challange.library.api.controller;

import com.restful.challange.library.api.dto.locatario.DadosCadastroLocatario;
import com.restful.challange.library.api.dto.locatario.DadosListagemLocatario;
import com.restful.challange.library.api.entity.Locatario;
import com.restful.challange.library.api.service.LocatarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/locatario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocatarioController {

    private final LocatarioService locatarioService;

    public LocatarioController(LocatarioService locatarioService) {
        this.locatarioService = locatarioService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemLocatario> cadastrar(
            @RequestBody @Valid DadosCadastroLocatario dadosCadastroLocatario,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Locatario locatario = locatarioService.save(dadosCadastroLocatario);
        URI uri = uriComponentsBuilder.path("/api/v1/locatario/{id}").buildAndExpand(locatario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemLocatario(locatario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLocatario>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemLocatario> locatarios = locatarioService.listar(paginacao);
        return ResponseEntity.ok(locatarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemLocatario> buscarPorId(@PathVariable Long id) {
        Locatario locatario = locatarioService.buscarPorId(id);
        return ResponseEntity.ok(new DadosListagemLocatario(locatario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locatarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}