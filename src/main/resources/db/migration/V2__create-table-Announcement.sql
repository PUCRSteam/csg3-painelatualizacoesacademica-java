CREATE TABLE announcement
(
    id                SERIAL PRIMARY KEY,
    titulo            VARCHAR(255)             NOT NULL,
    data_postagem     TIMESTAMP WITH TIME ZONE NOT NULL,
    remetente         VARCHAR(255)             NOT NULL,
    assunto           VARCHAR(255)             NOT NULL,
    corpo_texto       TEXT                     NOT NULL,
    contato           VARCHAR(255)             NOT NULL,
    numero_referencia VARCHAR(255)             NOT NULL,
    data_validade     TIMESTAMP WITH TIME ZONE NOT NULL
);
