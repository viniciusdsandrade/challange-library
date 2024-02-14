package com.restful.challange.library.api.repository;

import com.restful.challange.library.api.entity.Livro;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findById(long id);

    @Query(value = "SELECT * FROM tb_livro " +
            "WHERE is_available = true",
            nativeQuery = true)
    Page<Livro> findAvailableLivrosNative(Pageable pageable);

    @Query(value = "SELECT * FROM tb_livro " +
            "WHERE is_available = false",
            nativeQuery = true)
    Page<Livro> findUnavailableLivrosNative(Pageable pageable);

    Optional<Livro> findByISBN(String isbn);

    @Query("SELECT l FROM Livro l WHERE l.nome LIKE %:nome%")
    Page<Livro> findByNomeContaining(String nome, Pageable paginacao);

    /*
    4 - Listar todos os livros que foram alugados por um Locatário
    */
    @Query("SELECT l FROM Livro l JOIN l.autores a WHERE a.id = :id")
    Page<Livro> findByAutoresId(Long id, Pageable paginacao);


    /*
    5 - Deverá ser possível consultar quais Livros são de autoria de um autor pesquisado
     */
    @Query("SELECT l FROM Livro l JOIN l.autores a WHERE a.nome LIKE %:nome%")
    Page<Livro> FindByAutoresNomeContaining(String nome, Pageable paginacao);

}