package com.restful.challange.library.api.dto.livro;

import com.restful.challange.library.api.entity.Livro;

import java.time.LocalDate;

public record DadosListagemLivro(
        String nome,
        String ISBN,
        LocalDate dataPublicacao,
        Boolean isAvailable

) {
    public DadosListagemLivro(Livro livro) {
        this(
                livro.getNome(),
                livro.getISBN(),
                livro.getDataPublicacao(),
                livro.getIsAvailable()
        );
    }
}
