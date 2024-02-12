package com.restful.challange.library.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "Locatario")
@Table(
        name = "tb_locatario",
        schema = "db_library_api",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_locatario_cpf", columnNames = "CPF"),
                @UniqueConstraint(name = "uk_locatario_email", columnNames = "email")
        }
)
public class Locatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String CPF;
    private String email;
    private String telefone;
    private String nascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}