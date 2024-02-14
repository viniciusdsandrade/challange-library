package com.restful.challange.library.api.dto.locatario;

import com.restful.challange.library.api.entity.Locatario;

public record DadosListagemLocatario(
        String nome,
        String cpf,
        String email,
        String telefone,
        String nascimento
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
