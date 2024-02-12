package com.restful.challange.library.api.dto;

import com.restful.challange.library.api.entity.Sexo;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

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

        @NotNull(message = "A data de nascimento não pode ser nula")
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "A data de nascimento deve estar no formato dd/MM/yyyy")
        String nascimento,

        @CPF(message = "O CPF é inválido")
        @NotBlank(message = "O CPF não pode ser nulo")
        @Column(unique = true)
        String cpf
) {
}
