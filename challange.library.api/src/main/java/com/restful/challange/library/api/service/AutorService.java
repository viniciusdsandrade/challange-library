package com.restful.challange.library.api.service;

import com.restful.challange.library.api.dto.autor.DadosCadastroAutor;
import com.restful.challange.library.api.dto.autor.DadosListagemAutor;
import com.restful.challange.library.api.entity.Autor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface AutorService {

    @Transactional
    Autor save(@Valid DadosCadastroAutor dadosCadastroAutor);

    @Transactional
    void delete(Long id);

    Autor buscarPorId(Long id);

    Page<DadosListagemAutor> listar(Pageable pageable);
}
