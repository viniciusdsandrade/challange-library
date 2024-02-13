package com.restful.challange.library.api.service.impl;

import com.restful.challange.library.api.dto.livro.DadosCadastroLivro;
import com.restful.challange.library.api.dto.livro.DadosListagemLivro;
import com.restful.challange.library.api.entity.Livro;
import com.restful.challange.library.api.exception.ValidacaoException;
import com.restful.challange.library.api.repository.LivroRepository;
import com.restful.challange.library.api.service.LivroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;

    public LivroServiceImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }


    @Override
    @Transactional
    public Livro save(DadosCadastroLivro dadosCadastroLivro) {
        Livro livro = new Livro(dadosCadastroLivro);
        return livroRepository.save(livro);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new ValidacaoException("Livro não encontrado"));
        livroRepository.delete(livro);
    }

    @Override
    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new ValidacaoException("Livro não encontrado"));
    }

    @Override
    public Page<DadosListagemLivro> listar(Pageable pageable) {
        return livroRepository.findAll(pageable).map(DadosListagemLivro::new);
    }
}
