package com.restful.challange.library.api.repository;

import com.restful.challange.library.api.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findById(long id);

    @Query(value = "SELECT * FROM tb_livro " +
            "WHERE is_available = true",
            nativeQuery = true)
    List<Livro> findAvailableLivrosNative();

    @Query(value = "SELECT * FROM tb_livro " +
            "WHERE is_available = false",
            nativeQuery = true)
    List<Livro> findUnavailableLivrosNative();

    Optional<Livro> findByISBN(String isbn);

    /*
    4 - Listar todos os livros que foram alugados por um Locatário
    */


    /*
    5 - Deverá ser possível consultar quais Livros são de autoria de um autor pesquisado
     */

}