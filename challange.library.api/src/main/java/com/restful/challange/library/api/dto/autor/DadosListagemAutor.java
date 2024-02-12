package com.restful.challange.library.api.dto.autor;

import com.restful.challange.library.api.entity.Autor;
import com.restful.challange.library.api.entity.Sexo;

import java.util.Date;

public record DadosListagemAutor(
        String nome,
        Sexo sexo,
        String nascimento,
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
