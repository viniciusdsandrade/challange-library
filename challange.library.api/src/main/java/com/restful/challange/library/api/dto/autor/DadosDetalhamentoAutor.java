package com.restful.challange.library.api.dto.autor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.challange.library.api.entity.Autor;
import com.restful.challange.library.api.entity.Sexo;

import java.time.LocalDate;

public record DadosDetalhamentoAutor(
        Long id,
        String nome,
        Sexo sexo,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate nascimento,
        String cpf
) {
    public DadosDetalhamentoAutor(Autor autor) {
        this(
                autor.getId(),
                autor.getNome(),
                autor.getSexo(),
                autor.getNascimento(),
                autor.getCPF()
        );
    }
}
