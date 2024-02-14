package com.restful.challange.library.api.controller;

import com.restful.challange.library.api.dto.autor.DadosCadastroAutor;
import com.restful.challange.library.api.dto.autor.DadosDetalhamentoAutor;
import com.restful.challange.library.api.dto.autor.DadosListagemAutor;
import com.restful.challange.library.api.entity.Autor;
import com.restful.challange.library.api.service.AutorService;
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
@RequestMapping("/api/v1/autor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAutor> cadastrar(
            @RequestBody @Valid DadosCadastroAutor dadosCadastroAutor,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Autor autor = autorService.save(dadosCadastroAutor);
        URI uri = uriComponentsBuilder.path("/api/v1/autor/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAutor(autor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAutor>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemAutor> autores = autorService.listar(paginacao);
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemAutor> buscarPorId(@PathVariable Long id) {
        Autor autor = autorService.buscarPorId(id);
        return ResponseEntity.ok(new DadosListagemAutor(autor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}