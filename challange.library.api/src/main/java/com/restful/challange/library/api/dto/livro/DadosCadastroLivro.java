package com.restful.challange.library.api.dto.livro;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Date;

public record DadosCadastroLivro(

        @NotNull(message = "O nome do livro não pode ser nulo")
        String nome,

        @NotNull(message = "O ISBN do livro não pode ser nulo")
        @Column(unique = true)
        @Pattern(regexp = "^(97([89]))?\\d{9}(\\d|X)$", message = "O ISBN é inválido")
        String ISBN,

        @NotNull(message = "A data de publicação do livro não pode ser nula")
        @PastOrPresent(message = "A data de publicação do livro não pode ser futura")
        LocalDate dataPublicacao,

        @NotNull(message = "A disponibilidade do livro não pode ser nula")
        @Column(columnDefinition = "boolean default true")
        Boolean isAvailable
) {
}
