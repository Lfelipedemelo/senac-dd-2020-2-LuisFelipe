package br.sc.senac.model.bo;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.PesquisadorDAO;
import br.sc.senac.model.vo.PesquisadorVO;

public class PesquisadorBO {

	PesquisadorDAO pDao = new PesquisadorDAO();
	
	public String CadastrarPesquisador(PesquisadorVO pesquisador) {
		
		try {
			pDao.inserir(pesquisador);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO:\n" + e.getMessage());
		}
		
		return "Pesquisador cadastrado com sucesso!";	
	}

}
