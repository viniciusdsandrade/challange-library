package com.restful.challange.library.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "Livro")
@Table(
        name = "tb_livro",
        schema = "db_library_api",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_livro_isbn", columnNames = "ISBN")
        }
)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String dataPublicacao;
    private String ISBN;
    private Boolean isAvailable;

    //Cada livro deve ter no mínimo 1 autor e no máximo N autores
    @NotEmpty(message = "O livro deve ter no mínimo 1 autor")
    @ManyToMany
    @JoinTable(name = "tb_livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;
}