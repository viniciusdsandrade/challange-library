package com.restful.challange.library.api.controller;

import com.restful.challange.library.api.dto.livro.DadosCadastroLivro;
import com.restful.challange.library.api.dto.livro.DadosListagemLivro;
import com.restful.challange.library.api.entity.Livro;
import com.restful.challange.library.api.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/livro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<DadosListagemLivro> create(
            @RequestBody @Valid DadosCadastroLivro dadosCadastroLivro,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Livro livro = livroService.save(dadosCadastroLivro);
        URI uri = uriComponentsBuilder.path("/api/v1/livro/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemLivro(livro));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLivro>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemLivro> livros = livroService.listar(paginacao);
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemLivro> buscarPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarPorId(id);
        return ResponseEntity.ok(new DadosListagemLivro(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
