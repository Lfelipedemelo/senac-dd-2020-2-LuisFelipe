package br.sc.senac.controller;

import javax.swing.JOptionPane;

import br.sc.senac.model.bo.PesquisadorBO;
import br.sc.senac.model.vo.PesquisadorVO;

public class PesquisadorController {
	
	private PesquisadorBO pBO = new PesquisadorBO();
	
	public String CadastrarPesquisador(PesquisadorVO pesquisador) {
		String mensagem = "";

		pBO.CadastrarPesquisador(pesquisador);

		mensagem = "Pesquisador Cadastrado com Sucesso";
		return mensagem;
		
	}

}
