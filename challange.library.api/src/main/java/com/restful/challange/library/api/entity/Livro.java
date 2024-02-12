package com.restful.challange.library.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "Livro")
@Table(
        name = "tb_livro",
        schema = "db_library_api"
)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String dataPublicacao;
    private Boolean isAvailable;

    //Cada livro pode ter um ou mais autores
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id",
            referencedColumnName = "id")
    private Autor autor;
}
