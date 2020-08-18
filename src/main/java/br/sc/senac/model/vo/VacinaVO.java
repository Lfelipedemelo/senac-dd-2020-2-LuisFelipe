package br.sc.senac.model.vo;

import java.time.LocalDate;

public class VacinaVO {

	private int idVacina;
	private String pais;
	private String estagio; //TODO verificar se há algo parecido com o enum do mysql com o professor.
	private LocalDate dtInicioPesquisa;
	private PesquisadorVO pesquisadorVO;
	
	public VacinaVO(int idVacina, String pais, String estagio, LocalDate dtInicioPesquisa,
			PesquisadorVO pesquisadorVO) {
		super();
		this.idVacina = idVacina;
		this.pais = pais;
		this.estagio = estagio;
		this.dtInicioPesquisa = dtInicioPesquisa;
		this.pesquisadorVO = pesquisadorVO;
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
	public void setDtInicioPesquisa(LocalDate dtInicioPesquisa) {
		this.dtInicioPesquisa = dtInicioPesquisa;
	}
	public PesquisadorVO getPesquisadorVO() {
		return pesquisadorVO;
	}
	public void setPesquisadorVO(PesquisadorVO pesquisadorVO) {
		this.pesquisadorVO = pesquisadorVO;
	}
	
	
	
}
