package com.restful.challange.library.api.dto.locatario;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.challange.library.api.entity.Locatario;

import java.time.LocalDate;

public record DadosListagemLocatario(
        String nome,
        String cpf,
        String email,
        String telefone,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate nascimento
) {

    public DadosListagemLocatario(Locatario locatario) {
        this(
                locatario.getNome(),
                locatario.getCPF(),
                locatario.getEmail(),
                locatario.getTelefone(),
                locatario.getNascimento()
        );
    }
}
