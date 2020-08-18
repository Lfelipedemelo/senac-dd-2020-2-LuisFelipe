package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PacienteVO {

	private int idPaciente;
	private String nome;
	private LocalDate dataNascimento;
	private String sexo; //TODO verificar se há algo parecido com o enum do mysql com o professor.
	private int cpf;
	private int reacao;
	private boolean voluntario;
	
	public PacienteVO(int idPesquisador, String nome, LocalDate dataNascimento, String sexo, int cpf, int reacao,
			boolean voluntario) {
		super();
		this.idPaciente = idPesquisador;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.reacao = reacao;
		this.voluntario = voluntario;
	}

	public int getIdPesquisador() {
		return idPaciente;
	}

	public void setIdPesquisador(int idPesquisador) {
		this.idPaciente = idPesquisador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getReacao() {
		return reacao;
	}

	public void setReacao(int reacao) {
		this.reacao = reacao;
	}

	public boolean isVoluntario() {
		return voluntario;
	}

	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}	
}
