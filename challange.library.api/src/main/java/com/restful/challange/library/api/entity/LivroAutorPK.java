package com.restful.challange.library.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Table(
        name = "tb_livro_autor",
        schema = "db_library_api"
)
public class LivroAutorPK implements Serializable {

    @Column(name = "livro_id")
    private Long livroId;

    @Column(name = "autor_id")
    private Long autorId;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        LivroAutorPK that = (LivroAutorPK) o;

        return Objects.equals(this.livroId, that.livroId) &&
                Objects.equals(this.autorId, that.autorId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;

        hash *= prime + ((this.livroId == null) ? 0 : this.livroId.hashCode());
        hash *= prime + ((this.autorId == null) ? 0 : this.autorId.hashCode());

        if (hash < 0) hash *= -1;

        return hash;
    }
}
