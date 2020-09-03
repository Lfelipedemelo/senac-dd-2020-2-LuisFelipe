DROP DATABASE IF EXISTS DB_VACINACAO;
CREATE DATABASE DB_VACINACAO;
USE DB_VACINACAO;

CREATE TABLE PESQUISADOR (
	IDPESQUISADOR INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100),
    DATA_NASCIMENTO DATE,
    SEXO ENUM('MASCULINO', 'FEMININO'),
    CPF VARCHAR(11),
    REACAO INT(5),
    INSTITUICAO VARCHAR(100),
    PRIMARY KEY (IDPESQUISADOR)
);

CREATE TABLE PACIENTE (
	IDPACIENTE INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100),
    DATA_NASCIMENTO DATE,
    SEXO ENUM('MASCULINO', 'FEMININO'),
    CPF VARCHAR(11),
    REACAO INT(5),
    VOLUNTARIO BOOLEAN,
    PRIMARY KEY (IDPACIENTE)
);

select * from pesquisador;
select * from vacina;
INSERT INTO PESQUISADOR(NOME, DATA_NASCIMENTO, SEXO, CPF, REACAO,INSTITUICAO)
VALUES ('LUIS', '1996-08-05', 'MASCULINO', '09610985971', '5', 'HOSPITAL');

CREATE TABLE VACINA (
	IDVACINA INT NOT NULL AUTO_INCREMENT,
    IDPESQUISADOR INT NOT NULL,
    PAIS VARCHAR(45),
    ESTAGIO ENUM('INICIAL', 'TESTES', 'APLICA��O EM MASSA'),
    DT_INICIO_PESQUISA DATE,
	PRIMARY KEY (IDVACINA),
    FOREIGN KEY (IDPESQUISADOR) REFERENCES PESQUISADOR (IDPESQUISADOR)
);
select * from paciente;