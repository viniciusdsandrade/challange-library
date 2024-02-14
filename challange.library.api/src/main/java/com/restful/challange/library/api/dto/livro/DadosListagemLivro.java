package com.restful.challange.library.api.dto.livro;

import com.restful.challange.library.api.dto.autor.DadosDetalhamentoAutor;
import com.restful.challange.library.api.entity.Livro;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record DadosListagemLivro(
        Long id,
        String nome,
        String ISBN,
        LocalDate dataPublicacao,
        Boolean isAvailable,
        List<DadosDetalhamentoAutor> autores
) {
    public DadosListagemLivro(Livro livro) {
        this(
                livro.getId(),
                livro.getNome(),
                livro.getISBN(),
                livro.getDataPublicacao(),
                livro.getIsAvailable(),
                livro.getAutores().stream()
                        .map(DadosDetalhamentoAutor::new)
                        .collect(Collectors.toList())
        );
    }
}
