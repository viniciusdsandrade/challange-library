package com.restful.challange.library.api.service.impl;

import com.restful.challange.library.api.dto.locatario.DadosCadastroLocatario;
import com.restful.challange.library.api.dto.locatario.DadosListagemLocatario;
import com.restful.challange.library.api.entity.Locatario;
import com.restful.challange.library.api.exception.DuplicateEntryException;
import com.restful.challange.library.api.exception.ValidacaoException;
import com.restful.challange.library.api.repository.LocatarioRepository;
import com.restful.challange.library.api.service.LocatarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class LocatarioServiceImpl implements LocatarioService {

    private final LocatarioRepository locatarioRepository;

    public LocatarioServiceImpl(LocatarioRepository locatarioRepository) {
        this.locatarioRepository = locatarioRepository;
    }

    @Override
    @Transactional
    public Locatario save(DadosCadastroLocatario dadosCadastroLocatario) {
        validarDadosCadastroLocatario(dadosCadastroLocatario);
        Locatario locatario = new Locatario(dadosCadastroLocatario);
        return locatarioRepository.save(locatario);
    }

    @Override
    public Page<DadosListagemLocatario> listar(Pageable pageable) {
        return locatarioRepository.findAll(pageable).map(DadosListagemLocatario::new);
    }

    @Override
    public Locatario buscarPorId(Long id) {
        return locatarioRepository.findById(id).orElseThrow(() -> new ValidacaoException("Locatario não encontrado"));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Locatario locatario = locatarioRepository.findById(id).orElseThrow(() -> new ValidacaoException("Locatario não encontrado"));
        locatarioRepository.delete(locatario);
    }

    private void validarDadosCadastroLocatario(DadosCadastroLocatario dadosCadastroLocatario) {

        String cpf = dadosCadastroLocatario.cpf().replaceAll("[.\\-]", "");
        LocalDate dataNascimento = LocalDate.parse(dadosCadastroLocatario.nascimento());

        validarEmailUnico(dadosCadastroLocatario.email());
        validarCpfUnico(cpf);
        validarDataNascimento(dataNascimento);
        validarIdadeMinima(dataNascimento);
    }

    private void validarEmailUnico(String email) {
        if (locatarioRepository.existsByEmail(email)) {
            throw new DuplicateEntryException("Já existe um autor com o email " + email);
        }
    }

    private void validarCpfUnico(String cpf) {
        if (locatarioRepository.existsByCPF(cpf)) {
            throw new DuplicateEntryException("Já existe um autor com o cpf " + cpf);
        }
    }

    private void validarDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new ValidacaoException("A data de nascimento não pode ser posterior à data atual");
        }
    }

    private void validarIdadeMinima(LocalDate dataNascimento) {
        if (dataNascimento.plusYears(14).isAfter(LocalDate.now())) {
            throw new ValidacaoException("O autor deve ter no mínimo 14 anos de idade");
        }
    }
}