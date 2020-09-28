package br.sc.senac.controller;

import javax.swing.JOptionPane;

import br.sc.senac.model.bo.PesquisadorBO;
import br.sc.senac.model.vo.PesquisadorVO;

public class PesquisadorController {
	
	private PesquisadorBO pBO = new PesquisadorBO();
	
	public String CadastrarPesquisador(PesquisadorVO pesquisador) {		
		try {
			
			if(pesquisador.getCpf().length() != 11 || pesquisador.getCpf() == null || pesquisador.getCpf().isEmpty()) {
				JOptionPane.showMessageDialog(null, "CPF INVALIDO");
			}
			if(pesquisador.getNome().isEmpty() || pesquisador.getNome().length() < 2) {
				JOptionPane.showMessageDialog(null, "NOME INVALIDO");
			}
			pBO.CadastrarPesquisador(pesquisador);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO:\n" + e.getMessage());
		}
		
		return "Pesquisador Cadastrado com Sucesso";
		
	}

}
