package com.restful.challange.library.api.entity;

import com.restful.challange.library.api.dto.livro.DadosCadastroLivro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private String nome;
    private LocalDate dataPublicacao;
    private String ISBN;
    private Boolean isAvailable;

    //Cada livro deve ter no mínimo 1 autor e no máximo N autores
    @ManyToMany
    @NotEmpty(message = "O livro deve ter no mínimo 1 autor")
    @JoinTable(name = "tb_livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;

    //Aluguel deverá ser de no mínimo 1 ou vários livros
    @ManyToMany(mappedBy = "livros")
    private List<Aluguel> alugueis;

    public Livro(DadosCadastroLivro dadosCadastroLivro, List<Autor> autores) {
        this.nome = dadosCadastroLivro.nome();
        this.dataPublicacao = dadosCadastroLivro.dataPublicacao();
        this.ISBN = dadosCadastroLivro.ISBN();
        this.isAvailable = dadosCadastroLivro.isAvailable();
        this.autores = autores;
    }

    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }
}