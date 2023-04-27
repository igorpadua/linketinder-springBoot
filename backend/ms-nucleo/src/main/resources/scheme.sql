-- Tabelas

CREATE TABLE pessoas (
                    id SERIAL PRIMARY KEY,
                    nome varchar(50) NOT NULL,
                    sobrenome varchar(50),
                    data_nascimento date,
                    email varchar(50) NOT NULL,
                    pais varchar(50) NOT NULL,
                    descricao varchar(100) NOT NULL,
                    senha varchar(50) NOT NULL,
                    cpf varchar(50),
                    cnpj varchar(50),
                    tipo varchar(50) NOT NULL CHECK (tipo IN ('candidato', 'empresa')),
                    UNIQUE (email), UNIQUE (cpf), UNIQUE (cnpj),
                    CHECK (tipo = 'candidato' AND cpf IS NOT NULL OR tipo = 'empresa' AND cnpj IS NOT NULL),
                    CHECK (tipo = 'candidato' AND cnpj IS NULL OR tipo = 'empresa' AND cpf IS NULL),
                    CHECK (tipo = 'candidato' AND sobrenome IS NOT NULL OR tipo = 'empresa' AND sobrenome IS NULL),
                    CHECK (tipo = 'candidato' AND data_nascimento IS NOT NULL OR tipo = 'empresa' AND data_nascimento IS NULL)
);

CREATE TABLE vagas (
                       id SERIAL PRIMARY KEY,
                       nome varchar(50) NOT NULL,
                       descricao varchar(100) NOT NULL,
                       local_vaga varchar(50) NOT NULL,
                       empresa_id integer NOT NULL,
                       FOREIGN KEY (empresa_id) REFERENCES pessoas (id)
);

-- Insert


-- Candidatos
INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, descricao, senha)
VALUES ('Joao', 'Vitor', '1998-03-23', 'joao@gmail.com' ,'100.000.000-00', 'Brasil', 'Desenvolvedor back-end', '12345');

INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, descricao, senha)
VALUES ('Natalia', 'Alves', '2000-01-30', 'natalia@gmail.com' ,'200.000.000-00', 'Brasil', 'Desenvolvedora back-end', '12345');

INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, descricao, senha)
VALUES ('Maria', 'Silva', '1995-05-11', 'maria@gmail.com' ,'300.000.000-00', 'Brasil', 'Desenvolvedora front-end', '12345');

INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, descricao, senha)
VALUES ('Vitor', 'Pereira', '2001-11-23', 'vitor@gmail.com' ,'400.000.000-00', 'Brasil', 'Desenvolvedor back-end', '12345');

INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, descricao, senha)
VALUES ('Paulo', 'Ribeiro', '1993-12-23', 'paulo@gmail.com' ,'500.000.000-00', 'Brasil', 'Desenvolvedor front-end', '12345');

-- Empresas
INSERT INTO empresas (nome, cnpj, email, descricao, pais, senha)
VALUES('Empresa 1', '00.000.000/0000-00', 'empresa1@gmail.com', 'Empresa de jogos', 'Brasil', '12345');

INSERT INTO empresas (nome, cnpj, email, descricao, pais, senha)
VALUES('Empresa 2', '10.000.000/0000-00', 'empresa2@gmail.com', 'Farmacia', 'Brasil', '12345');

INSERT INTO empresas (nome, cnpj, email, descricao, pais, senha)
VALUES('Empresa 3', '20.000.000/0000-00', 'empresa3@gmail.com', 'Empresa de vendas', 'Brasil', '12345');

INSERT INTO empresas (nome, cnpj, email, descricao, pais, senha)
VALUES('Empresa 4', '30.000.000/0000-00', 'empresa4@gmail.com', 'Empresa de jogos', 'Brasil', '12345');

INSERT INTO empresas (nome, cnpj, email, descricao, pais, senha)
VALUES('Empresa 5', '40.000.000/0000-00', 'empresa5@gmail.com', 'Empresa de software', 'Brasil', '12345');

-- Vagas
INSERT INTO vagas (nome, descricao, local_vaga, empresa_id)
VALUES('Vaga junior', 'Para desenvolvedores back-end', 'São Paulo', 1);

INSERT INTO vagas (nome, descricao, local_vaga, empresa_id)
VALUES('Vaga senior', 'Para desenvolvedores front-end', 'Rio de Janeiro', 2);

INSERT INTO vagas (nome, descricao, local_vaga, empresa_id)
VALUES('Vaga Plenio', 'Para desenvolvedores front-end', 'Salvador', 3);

INSERT INTO vagas (nome, descricao, local_vaga, empresa_id)
VALUES('Vaga junior', 'Para desenvolvedores back-end', 'Goiânia', 4);

-- Curtidas candidatos
INSERT INTO curtida_candidato (candidato_id, vaga_id)
VALUES (1, 3);

INSERT INTO curtida_candidato (candidato_id, vaga_id)
VALUES (2, 1);

INSERT INTO curtida_candidato (candidato_id, vaga_id)
VALUES (2, 4);

INSERT INTO curtida_candidato (candidato_id, vaga_id)
VALUES (4, 2);

-- Curtidas empresas

INSERT INTO curtida_vaga (vaga_id, candidato_id)
VALUES (1, 2);

INSERT INTO curtida_vaga (vaga_id, candidato_id)
VALUES (3, 4);

INSERT INTO curtida_vaga (vaga_id, candidato_id)
VALUES (4, 2);

INSERT INTO curtida_vaga (vaga_id, candidato_id)
VALUES (4, 1);

-- Selecionar os match
SELECT c.nome, v.nome
FROM candidatos c
         INNER JOIN curtida_candidato cc ON cc.candidato_id = c.id
         INNER JOIN vagas v ON v.id = cc.vaga_id
         INNER JOIN curtida_vaga cv ON cv.vaga_id = v.id
WHERE c.id = cv.candidato_id;


