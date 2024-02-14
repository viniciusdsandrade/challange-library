package com.restful.challange.library.api.dto.livro;

import com.restful.challange.library.api.entity.Livro;

import java.time.LocalDate;

public record DadosDetalhamentoLivro(
        Long id,
        String nome,
        String ISBN,
        LocalDate dataPublicacao,
        Boolean isAvailable
) {
    public DadosDetalhamentoLivro(Livro livro) {
        this(
                livro.getId(),
                livro.getNome(),
                livro.getISBN(),
                livro.getDataPublicacao(),
                livro.getIsAvailable()
        );
    }
}

