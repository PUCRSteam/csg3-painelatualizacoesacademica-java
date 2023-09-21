CREATE TABLE news
(
    id                SERIAL PRIMARY KEY,
    titulo            VARCHAR(255)             NOT NULL,
    conteudo          VARCHAR(1000)            NOT NULL,
    data_publicacao   TIMESTAMP WITH TIME ZONE NOT NULL,
    autor             VARCHAR(100)             NOT NULL
);