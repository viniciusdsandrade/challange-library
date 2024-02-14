package com.restful.challange.library.api.service.impl;

import com.restful.challange.library.api.dto.livro.DadosCadastroLivro;
import com.restful.challange.library.api.dto.livro.DadosListagemLivro;
import com.restful.challange.library.api.entity.Autor;
import com.restful.challange.library.api.entity.Livro;
import com.restful.challange.library.api.exception.ValidacaoException;
import com.restful.challange.library.api.repository.AutorRepository;
import com.restful.challange.library.api.repository.LivroRepository;
import com.restful.challange.library.api.service.LivroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroServiceImpl(LivroRepository livroRepository,
                            AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    @Override
    @Transactional
    public Livro save(DadosCadastroLivro dadosCadastroLivro) {

        Optional<Livro> livroByISBN = livroRepository.findByISBN(dadosCadastroLivro.ISBN());

        if (livroByISBN.isPresent())
            throw new ValidacaoException("Já existe um livro cadastrado com o ISBN informado");

        List<Autor> autores = dadosCadastroLivro.autoresIds();

        if (autores.isEmpty())
            throw new ValidacaoException("O livro deve ter pelo menos um autor");

        for (Autor autor : autores) {
            Optional<Autor> optionalAutor = autorRepository.findById(autor.getId());

            if (optionalAutor.isEmpty())
                throw new ValidacaoException("Autor não encontrado com o id: " + autor.getId());
        }

        Livro livro = new Livro(dadosCadastroLivro, autores);
        return livroRepository.save(livro);
    }

    @Override
    public Page<DadosListagemLivro> listar(Pageable pageable) {
        return livroRepository.findAll(pageable)
                .map(DadosListagemLivro::new);
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


}
