package com.restful.challange.library.api.service.impl;

import com.restful.challange.library.api.dto.endereco.DadosDetalhamentoEndereco;
import com.restful.challange.library.api.dto.endereco.DadosListagemEndereco;
import com.restful.challange.library.api.service.EnderecoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final String url = "https://viacep.com.br/ws/";
    private final String json = "/json";

    @Override
    public DadosListagemEndereco consultaCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = this.url + cep + this.json;
        return restTemplate.getForObject(url, DadosListagemEndereco.class);
    }

    @Override
    public DadosDetalhamentoEndereco detalhamentoCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = this.url + cep + this.json;
        return restTemplate.getForObject(url, DadosDetalhamentoEndereco.class);
    }
}
