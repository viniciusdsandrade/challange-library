package com.restful.challange.library.api.dto.autor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.challange.library.api.entity.Livro;
import com.restful.challange.library.api.entity.Sexo;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroAutor(

        @NotNull(message = "O nome não pode ser nulo")
        @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "O nome deve conter apenas letras e espaços")
        String nome,

        @Valid
        Sexo sexo,

        @NotNull(message = "A data de nascimento não pode ser nula")
        @PastOrPresent(message = "A data de nascimento não pode ser futura")
        @JsonFormat(
                pattern = "dd/MM/yyyy",
                shape = JsonFormat.Shape.STRING,
                locale = "pt-BR",
                timezone = "Brazil/East",
                with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY
        )
        LocalDate nascimento,

        @CPF(message = "O CPF é inválido")
        @NotBlank(message = "O CPF não pode ser nulo")
        @Column(unique = true)
        String cpf,

        /*
        1 - Cada autor poderá ter 0 ou mais livros(Opcional --> 0..*)
        2 - Cada livro poderá ter 1 ou mais autores
         */
        List<Livro> livros
) {
}

