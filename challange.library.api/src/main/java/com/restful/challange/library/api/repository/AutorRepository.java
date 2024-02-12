package com.restful.challange.library.api.repository;

import com.restful.challange.library.api.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    boolean existsByCPF(String cpf);

    Autor findByNome(String nome);
}
