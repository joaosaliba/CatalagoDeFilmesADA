CREATE SCHEMA IF NOT EXISTS catalago;

CREATE TABLE IF NOT EXISTS catalago.pessoa
(
    id               BIGSERIAL PRIMARY KEY,
    nome             VARCHAR(255) NOT NULL,
    data_nascimento  DATE,
    nacionalidade    VARCHAR(255),
    tipo_pessoa_enum VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS catalago.ator
(
    id INTEGER PRIMARY KEY REFERENCES catalago.pessoa (id),
    tipo_pessoa_enum VARCHAR(50) CHECK (tipo_pessoa_enum = 'ATOR')
);

CREATE TABLE IF NOT EXISTS catalago.diretor
(
    id INTEGER PRIMARY KEY REFERENCES catalago.pessoa (id),
    tipo_pessoa_enum VARCHAR(50) CHECK (tipo_pessoa_enum = 'DIRETOR')
);

CREATE TABLE IF NOT EXISTS catalago.filme
(
    id              BIGSERIAL PRIMARY KEY,
    nome            VARCHAR(255) NOT NULL,
    data_lancamento DATE,
    orcamento       NUMERIC(15, 2),
    descricao       TEXT
);

CREATE OR REPLACE FUNCTION is_ator(pessoa_id INTEGER) RETURNS BOOLEAN AS $$
BEGIN
    RETURN (SELECT tipo_pessoa_enum FROM catalago.pessoa WHERE id = pessoa_id) = 'ATOR';
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION is_diretor(pessoa_id INTEGER) RETURNS BOOLEAN AS $$
BEGIN
    RETURN (SELECT tipo_pessoa_enum FROM catalago.pessoa WHERE id = pessoa_id) = 'DIRETOR';
END;
$$ LANGUAGE plpgsql;

CREATE TABLE IF NOT EXISTS catalago.filme_diretor
(
    filme_id INTEGER REFERENCES catalago.filme (id),
    diretor_id INTEGER REFERENCES catalago.diretor (id),
    CHECK (is_diretor(diretor_id)),
    PRIMARY KEY (filme_id, diretor_id)
);

CREATE TABLE IF NOT EXISTS catalago.filme_ator
(
    filme_id INTEGER REFERENCES catalago.filme (id),
    ator_id INTEGER REFERENCES catalago.ator (id),
    CHECK (is_ator(ator_id)),
    PRIMARY KEY (filme_id, ator_id)
);
