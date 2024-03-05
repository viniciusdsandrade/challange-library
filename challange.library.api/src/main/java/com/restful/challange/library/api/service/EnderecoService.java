package com.restful.challange.library.api.service;

import com.restful.challange.library.api.dto.endereco.DadosDetalhamentoEndereco;
import com.restful.challange.library.api.dto.endereco.DadosListagemEndereco;

public interface EnderecoService {

    DadosListagemEndereco consultaCep(String cep);

    DadosDetalhamentoEndereco detalhamentoCep(String cep);
}
