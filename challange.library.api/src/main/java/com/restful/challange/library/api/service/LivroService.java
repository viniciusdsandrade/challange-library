    package com.restful.challange.library.api.service;

    import com.restful.challange.library.api.dto.livro.DadosCadastroLivro;
    import com.restful.challange.library.api.dto.livro.DadosListagemLivro;
    import com.restful.challange.library.api.entity.Livro;
    import jakarta.validation.Valid;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.transaction.annotation.Transactional;

    public interface LivroService {

        @Transactional
        Livro save(@Valid DadosCadastroLivro dadosCadastroLivro);

        @Transactional
        void delete(Long id);

        Livro buscarPorId(Long id);

        Page<DadosListagemLivro> listar(Pageable pageable);
    }
