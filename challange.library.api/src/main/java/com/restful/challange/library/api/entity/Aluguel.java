package com.restful.challange.library.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "Aluguel")
@Table(name = "tb_aluguel",
        schema = "db_library_api")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    //Cada Aluguel deverá ter um Locatario
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locatario_id")
    private Locatario locatario;

    //Aluguel deverá ser de no mínimo 1 ou vários livros
    @ManyToMany
    @NotEmpty(message = "Deve haver pelo menos um livro no aluguel")
    private List<Livro> livros;

    @CreationTimestamp
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;
}