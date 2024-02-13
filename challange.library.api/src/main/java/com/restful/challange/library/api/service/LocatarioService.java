package com.restful.challange.library.api.service;

import com.restful.challange.library.api.dto.locatario.DadosCadastroLocatario;
import com.restful.challange.library.api.dto.locatario.DadosListagemLocatario;
import com.restful.challange.library.api.entity.Locatario;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface LocatarioService {

    @Transactional
    Locatario save(@Valid DadosCadastroLocatario dadosCadastroLocatario);

    @Transactional
    void delete(Long id);

    Locatario buscarPorId(Long id);

    Page<DadosListagemLocatario> listar(Pageable pageable);
}
