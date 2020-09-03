package br.sc.senac.model.vo;

public class VacinaVO {

	private int idVacina;
	private String pais;
	private int estagio;
	private String dtInicioPesquisa;
	private PesquisadorVO pesquisadorVO;
	
	public VacinaVO(int idVacina, String pais, int estagio, String dtInicioPesquisa,
			PesquisadorVO pesquisadorVO) {
		super();
		this.idVacina = idVacina;
		this.pais = pais;
		this.estagio = estagio;
		this.dtInicioPesquisa = dtInicioPesquisa;
		this.pesquisadorVO = pesquisadorVO;
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
	public int getEstagio() {
		return estagio;
	}
	public void setEstagio(int estagio) {
		this.estagio = estagio;
	}
	public String getDtInicioPesquisa() {
		return dtInicioPesquisa;
	}
	public void setDtInicioPesquisa(String dtInicioPesquisa) {
		this.dtInicioPesquisa = dtInicioPesquisa;
	}
	public PesquisadorVO getPesquisadorVO() {
		return pesquisadorVO;
	}
	public void setPesquisadorVO(PesquisadorVO pesquisadorVO) {
		this.pesquisadorVO = pesquisadorVO;
	}
	
}
