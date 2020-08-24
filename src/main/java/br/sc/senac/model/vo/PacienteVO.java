package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PacienteVO extends PessoaVO {

	private boolean voluntario;
	
	public PacienteVO(String nome, LocalDate dataNascimento, String sexo, int cpf, int reacao, boolean voluntario) {
		super(nome, dataNascimento, sexo, cpf, reacao);
		this.voluntario = voluntario;
	}

	public boolean isVoluntario() {
		return voluntario;
	}

	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}
}
