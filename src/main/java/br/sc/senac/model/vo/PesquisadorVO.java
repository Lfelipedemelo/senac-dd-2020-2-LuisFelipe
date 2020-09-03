package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	
	private String instituicao;

	public PesquisadorVO(int id, String nome, String dataNascimento, String sexo, int cpf, int reacao, String instituicao) {
		super(id, nome, dataNascimento, sexo, cpf, reacao);
		this.instituicao = instituicao;
	}
	public PesquisadorVO() {
		// TODO Auto-generated constructor stub
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
}
