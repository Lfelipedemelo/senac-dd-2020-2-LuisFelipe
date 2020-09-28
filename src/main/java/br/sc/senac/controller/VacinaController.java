package br.sc.senac.controller;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.VacinaDAO;
import br.sc.senac.model.vo.VacinaVO;

public class VacinaController {

	public String CadastrarVacina(VacinaVO vacina) {
		try {
			if(vacina.getPesquisador().length() < 2 || vacina.getPesquisador().isEmpty() || vacina.getPesquisador() == null) {
				JOptionPane.showMessageDialog(null, "Pesquisador Invalido");
			}
			if(vacina.getPais().length() < 2 || vacina.getPais().isEmpty() || vacina.getPais() == null) {
				JOptionPane.showMessageDialog(null, "Pais Invalido");
			}
			if(vacina.getDtInicioPesquisa() == null || vacina.getEstagio() == 0) {
				JOptionPane.showMessageDialog(null, "Data Invalida");
			}
			VacinaDAO vacinaDAO = new VacinaDAO();
			vacinaDAO.inserir(vacina);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO:\n" + e.getMessage());
		}
		return "Vacina cadastrada com sucesso";
		
	}

}
