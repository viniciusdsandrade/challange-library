package com.restful.challange.library.api.dto.autor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.challange.library.api.entity.Autor;
import com.restful.challange.library.api.entity.Sexo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record DadosListagemAutor(
        String nome,
        Sexo sexo,

        @JsonFormat(pattern = "dd/MM/yyyy",
                shape = JsonFormat.Shape.STRING,
                locale = "pt-BR",
                timezone = "Brazil/East",
                with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        LocalDate nascimento,
        String cpf
) {

    public DadosListagemAutor(Autor autor) {
        this(
                autor.getNome(),
                autor.getSexo(),
                autor.getNascimento(),
                autor.getCPF()
        );
    }
}
