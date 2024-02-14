package com.restful.challange.library.api.dto.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.challange.library.api.entity.Autor;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record DadosCadastroLivro(

        @NotNull(message = "O nome do livro não pode ser nulo")
        String nome,

        @NotNull(message = "O ISBN do livro não pode ser nulo")
        @Column(unique = true)
        String ISBN,

        @NotNull(message = "A data de publicação do livro não pode ser nula")
        @PastOrPresent(message = "A data de publicação do livro não pode ser futura")
        @JsonFormat(
                pattern = "dd/MM/yyyy",
                shape = JsonFormat.Shape.STRING,
                locale = "pt-BR",
                timezone = "Brazil/East",
                with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY
        )
        LocalDate dataPublicacao,

        @NotNull(message = "A disponibilidade do livro não pode ser nula")
        @Column(columnDefinition = "boolean default true")
        Boolean isAvailable,


        @NotNull(message = "O livro deve ter pelo menos um autor")
        List<Autor> autoresIds
) {
}
