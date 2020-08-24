package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	
	private String instituicao;
	
	
	
	public PesquisadorVO(String nome, LocalDate dataNascimento, String sexo, int cpf, int reacao, String instituicao) {
		super(nome, dataNascimento, sexo, cpf, reacao);
		this.instituicao = instituicao;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
}
