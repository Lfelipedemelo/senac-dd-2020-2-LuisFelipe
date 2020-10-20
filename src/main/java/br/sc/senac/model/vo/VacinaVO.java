package br.sc.senac.model.vo;

import java.time.LocalDate;

public class VacinaVO {

	private int idVacina;
	private String pais;
	private String estagio;
	private LocalDate dtInicioPesquisa;
	private String pesquisador;
	
	public VacinaVO(int idVacina, String pais, String estagio, LocalDate dtInicioPesquisa,
			String pesquisador) {
		super();
		this.idVacina = idVacina;
		this.pais = pais;
		this.estagio = estagio;
		this.dtInicioPesquisa = dtInicioPesquisa;
		this.pesquisador = pesquisador;
	}
	
	public VacinaVO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdVacina() {
		return idVacina;
	}
	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstagio() {
		return estagio;
	}
	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}
	public LocalDate getDtInicioPesquisa() {
		return dtInicioPesquisa;
	}
	public void setDtInicioPesquisa(LocalDate localDate) {
		this.dtInicioPesquisa = localDate;
	}
	public String getPesquisador() {
		return pesquisador;
	}
	public void setPesquisador(String pesquisador) {
		this.pesquisador = pesquisador;
	}
	
}
