package com.restful.challange.library.api.dto.autor;

import com.restful.challange.library.api.entity.Sexo;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroAutor(

        @NotNull(message = "O nome não pode ser nulo")
        @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "O nome deve conter apenas letras e espaços")
        String nome,

        @Valid
        Sexo sexo,

        @NotNull(message = "A data de nascimento não pode ser nula")
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "A data de nascimento deve estar no formato dd/MM/yyyy")
        String nascimento,

        @CPF(message = "O CPF é inválido")
        @NotBlank(message = "O CPF não pode ser nulo")
        @Column(unique = true)
        String cpf
) {
}

