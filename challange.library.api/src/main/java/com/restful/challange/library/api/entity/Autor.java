package com.restful.challange.library.api.entity;

import com.restful.challange.library.api.dto.autor.DadosCadastroAutor;
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
@Entity(name = "Autor")
@Table(
        name = "tb_autor",
        schema = "db_library_api",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_autor_cpf", columnNames = "CPF")
        }
)
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String CPF;
    private String nascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    //Um autor pode ter zero ou N livros
    @ManyToMany(mappedBy = "autores")
    @Column(nullable = true)
    private List<Livro> livros;

    public Autor(DadosCadastroAutor dadosCadastroAutor) {
        this.nome = dadosCadastroAutor.nome();
        this.sexo = dadosCadastroAutor.sexo();
        this.nascimento = dadosCadastroAutor.nascimento();
        this.CPF = dadosCadastroAutor.cpf();
    }
}
