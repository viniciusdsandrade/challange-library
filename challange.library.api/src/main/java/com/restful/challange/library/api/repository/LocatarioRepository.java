package com.restful.challange.library.api.repository;

import com.restful.challange.library.api.entity.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
    boolean existsByCPF(String cpf);

    boolean existsByEmail(String email);
}
