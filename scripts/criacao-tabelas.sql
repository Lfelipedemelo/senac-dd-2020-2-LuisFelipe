CREATE DATABASE DB_VACINACAO;
USE DB_VACINACAO;

CREATE TABLE PESQUISADOR (
	IDPESQUISADOR INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100),
    DATA_NASCIMENTO DATE,
    SEXO ENUM('MASCULINO', 'FEMININO'),
    CPF INT(11),
    REACAO INT(5),
    INSTITUICAO VARCHAR(100),
    PRIMARY KEY (IDPESQUISADOR)
);

CREATE TABLE PACIENTE (
	IDPACIENTE INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100),
    DATA_NASCIMENTO DATE,
    SEXO ENUM('MASCULINO', 'FEMININO'),
    CPF INT(11),
    REACAO INT(5),
    VOLUNTARIO BOOLEAN,
    PRIMARY KEY (IDPACIENTE)
);

CREATE TABLE VACINA (
	IDVACINA INT NOT NULL AUTO_INCREMENT,
    IDPESQUISADOR INT NOT NULL,
    PAIS VARCHAR(45),
    ESTAGIO ENUM('INICIAL', 'TESTES', 'APLICA��O EM MASSA'),
    DT_INICIO_PESQUISA DATE,
    PESQUISADOR VARCHAR(100),
	PRIMARY KEY (IDVACINA),
    FOREIGN KEY (IDPESQUISADOR) REFERENCES PESQUISADOR (IDPESQUISADOR)
);