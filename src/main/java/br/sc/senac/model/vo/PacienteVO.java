package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PacienteVO extends PessoaVO {

	private boolean voluntario;
	
	
	public PacienteVO() {
		super();
	}

	public PacienteVO(int id, String nome, LocalDate dataNascimento, String sexo, String cpf, int reacao, boolean voluntario) {
		super(id, nome, dataNascimento, sexo, cpf, reacao);
		this.voluntario = voluntario;
	}
	
	public boolean isVoluntario() {
		return voluntario;
	}

	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}
}
