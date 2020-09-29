package br.sc.senac.controller;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.VacinaDAO;
import br.sc.senac.model.vo.VacinaVO;

public class VacinaController {

	private String mensagem = "";

	public String cadastrarVacina(VacinaVO vacina) {
		try {
			
			if(validarPesquisador(vacina) && validarPais(vacina) && validarDtInicio(vacina) && validarEstagio(vacina)) {
				VacinaDAO vacinaDAO = new VacinaDAO();
				vacinaDAO.inserir(vacina);
				mensagem = "Vacina cadastrada com sucesso!";
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO:\n" + e.getMessage());
		}
		return mensagem;
		
	}

	private boolean validarEstagio(VacinaVO vacina) {
		if(vacina.getEstagio() == 0) {
			mensagem = "Estagio da vacina não selecionado!\n";
			return false;
		}
		return true;
	}

	private boolean validarDtInicio(VacinaVO vacina) {
		if(vacina.getDtInicioPesquisa() == null) {
			mensagem = "Data Invalida\n";
			return false;
		}
		return true;
	}

	private boolean validarPais(VacinaVO vacina) {
		if(vacina.getPais().length() < 2 || vacina.getPais().isEmpty() || vacina.getPais() == null) {
			mensagem = "Pais Invalido\n";
			return false;
		}
		return true;
	}

	private boolean validarPesquisador(VacinaVO vacina) {
		if(vacina.getPesquisador().length() < 3 || vacina.getPesquisador().isEmpty() || vacina.getPesquisador() == null) {
			mensagem = "Pesquisador Invalido\n";
			return false;
		}
		return true;
	}

}
