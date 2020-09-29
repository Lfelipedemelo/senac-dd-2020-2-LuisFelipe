package br.sc.senac.controller;

import javax.swing.JOptionPane;

import br.sc.senac.model.bo.PesquisadorBO;
import br.sc.senac.model.vo.PesquisadorVO;

public class PesquisadorController {
	
	private String mensagem = "";
	private PesquisadorBO pBO = new PesquisadorBO();
	
	public String cadastrarPesquisador(PesquisadorVO pesquisador) {		
		try {
			if(validarCpf(pesquisador) && validarNome(pesquisador) && validarData(pesquisador)) {
				pBO.CadastrarPesquisador(pesquisador);
				mensagem = "Pesquisador cadastrado com sucesso!";
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO:\n" + e.getMessage());
		}
		
		return mensagem;
		
	}

	private boolean validarData(PesquisadorVO pesquisador) {
		if(pesquisador.getDataNascimento() == null) {
			mensagem = "Data Invalida\n";
			return false;
		}
		return true;
	}

	private boolean validarNome(PesquisadorVO pesquisador) {
		if(pesquisador.getNome().isEmpty() || pesquisador.getNome().length() < 3) {
			mensagem = "NOME INVALIDO";
			return false;
		}
		return true;
	}

	private boolean validarCpf(PesquisadorVO pesquisador) {
		if(pesquisador.getCpf().length() != 11 || pesquisador.getCpf() == null || pesquisador.getCpf().isEmpty()) {
			mensagem = "CPF INVALIDO";
			return false;
		}
		return true;
	}

}
