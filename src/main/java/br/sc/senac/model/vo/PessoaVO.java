package br.sc.senac.model.vo;

import java.time.LocalDate;

public abstract class PessoaVO {

	private int id;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private long cpf;
	private int reacao;
	
	public PessoaVO(int id, String nome, String dataNascimento, String sexo, int cpf, int reacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.reacao = reacao;
	}
	
	public PessoaVO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long l) {
		this.cpf = l;
	}

	public int getReacao() {
		return reacao;
	}

	public void setReacao(int reacao) {
		this.reacao = reacao;
	}
}
