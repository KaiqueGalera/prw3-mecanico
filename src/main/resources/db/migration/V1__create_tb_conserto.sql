CREATE TABLE tb_conserto (
    id BIGINT NOT NULL,
    data_entrada DATE,
    data_saida DATE,
    nome VARCHAR(255),
    anos_de_experiencia INTEGER,
    placa VARCHAR(20),
    marca VARCHAR(100),
    modelo VARCHAR(100),
    ano VARCHAR(4),
    PRIMARY KEY (id)
);