package com.restful.challange.library.api.controller;

import com.restful.challange.library.api.dto.endereco.DadosDetalhamentoEndereco;
import com.restful.challange.library.api.dto.endereco.DadosListagemEndereco;
import com.restful.challange.library.api.service.impl.EnderecoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/endereco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {

    private final EnderecoServiceImpl service;

    public EnderecoController(EnderecoServiceImpl enderecoService) {
        this.service = enderecoService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<DadosListagemEndereco> consultaCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok(service.consultaCep(cep));
    }

    @GetMapping("/cep/detalhamento/{cep}")
    public ResponseEntity<DadosDetalhamentoEndereco> detalhamentoCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok(service.detalhamentoCep(cep));
    }
}
