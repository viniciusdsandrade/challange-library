DROP DATABASE IF EXISTS db_library_api;
CREATE DATABASE IF NOT EXISTS db_library_api;
USE db_library_api;

CREATE TABLE IF NOT EXISTS tb_autor
(
    id         BIGINT UNSIGNED AUTO_INCREMENT,
    cpf        VARCHAR(255) NOT NULL,
    nascimento VARCHAR(255) NOT NULL,
    nome       VARCHAR(255) NOT NULL,
    sexo       ENUM (
        'MASCULINO',
        'FEMININO',
        'TRANSGENERO',
        'GENERO_FLUIDO',
        'NAO_BINARIO',
        'AGENERO',
        'BIGENERO',
        'GENERO_QUESTIONANDO',
        'GENEROQUEER',
        'INTERSEXO',
        'OUTRO'
        )                   NULL,
    UNIQUE (cpf),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_livro
(
    id              BIGINT UNSIGNED AUTO_INCREMENT,
    ISBN            VARCHAR(255)         NOT NULL,
    data_publicacao VARCHAR(255)         NOT NULL,
    autor_id        BIGINT UNSIGNED      NOT NULL,
    is_available    BOOLEAN DEFAULT TRUE NOT NULL,

    UNIQUE (ISBN),

    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES tb_autor (id)
);

CREATE TABLE IF NOT EXISTS tb_livro_autor
(
    livro_id BIGINT UNSIGNED NOT NULL,
    autor_id BIGINT UNSIGNED NOT NULL,

    PRIMARY KEY (livro_id, autor_id),

    FOREIGN KEY (livro_id) REFERENCES tb_livro (id),
    FOREIGN KEY (autor_id) REFERENCES tb_autor (id)
);

CREATE TABLE IF NOT EXISTS tb_locatario
(
    id         BIGINT UNSIGNED AUTO_INCREMENT,
    nome       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    cpf        VARCHAR(255) NOT NULL,
    telefone   VARCHAR(255) NOT NULL,
    nascimento VARCHAR(255) NOT NULL,
    sexo       ENUM (
        'MASCULINO',
        'FEMININO',
        'TRANSGENERO',
        'GENERO_FLUIDO',
        'NAO_BINARIO',
        'AGENERO',
        'BIGENERO',
        'GENERO_QUESTIONANDO',
        'GENEROQUEER',
        'INTERSEXO',
        'OUTRO'
        )                   NULL,

    UNIQUE (cpf),
    UNIQUE (email),

    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS tb_aluguel
(
    id           BIGINT UNSIGNED AUTO_INCREMENT,
    locatario_id BIGINT UNSIGNED,
    PRIMARY KEY (id),

    FOREIGN KEY (locatario_id) REFERENCES tb_locatario (id)
);

CREATE TABLE IF NOT EXISTS tb_aluguel_livros
(
    aluguel_id     BIGINT UNSIGNED NOT NULL,
    livros_id      BIGINT UNSIGNED NOT NULL,
    data_retirada  DATE DEFAULT CURRENT_DATE,
    data_devolucao DATE DEFAULT 2,

    PRIMARY KEY (aluguel_id, livros_id),

    FOREIGN KEY (aluguel_id) REFERENCES tb_aluguel (id),
    FOREIGN KEY (livros_id) REFERENCES tb_livro (id)
);