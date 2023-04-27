create table competencias (
                              id SERIAL PRIMARY KEY,
                              nome VARCHAR(50) NOT NULL,
                              nivel VARCHAR(50) NOT NULL,
                              id_usuario INTEGER NOT NULL,
                              is_vaga BOOLEAN NOT NULL
);
