package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	
	private String instituicao;

	public PesquisadorVO(int id, String nome, LocalDate dataNascimento, String sexo, int cpf, int reacao, String instituicao) {
		super(id, nome, dataNascimento, sexo, cpf, reacao);
		this.instituicao = instituicao;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
}
