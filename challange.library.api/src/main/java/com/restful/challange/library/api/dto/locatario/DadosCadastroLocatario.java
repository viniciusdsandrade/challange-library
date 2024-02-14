package com.restful.challange.library.api.dto.locatario;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.challange.library.api.entity.Sexo;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosCadastroLocatario(

        @NotNull(message = "O nome não pode ser nulo")
        String nome,

        @Valid
        Sexo sexo,

        @NotBlank(message = "O telefone não pode ser nulo")
        @Pattern(regexp = "(?:(?:\\+|00)\\d{1,3}[- ]?)?(?:\\(\\d{2,3}\\)|\\d{2,3})[- ]?\\d{4,5}[- ]?\\d{4}")
        String telefone,

        @Email(message = "O email é inválido")
        @NotBlank(message = "O email não pode ser nulo")
        @Column(unique = true)
        String email,

        @NotNull(message = "A data de nascimento do locatário não pode ser nula")
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
        String cpf
) {
}
