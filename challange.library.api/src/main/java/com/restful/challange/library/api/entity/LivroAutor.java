package com.restful.challange.library.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "LivroAutor")
@Table(name = "tb_livro_autor",
        schema = "db_library_api")
public class LivroAutor {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private LivroAutorPK id;

    @ManyToOne
    @MapsId("autorId")
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @MapsId("livroId")
    @JoinColumn(name = "livro_id")
    private Livro livro;
}