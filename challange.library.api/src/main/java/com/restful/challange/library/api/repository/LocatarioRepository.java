package com.restful.challange.library.api.repository;

import com.restful.challange.library.api.entity.Locatario;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
    boolean existsByCPF(String cpf);

    boolean existsByEmail(String email);

    @Query("SELECT l FROM Locatario l WHERE l.nome LIKE %:nome%")
    Page<Locatario> findByNomeContaining(String nome, Pageable paginacao);
}
