package br.sc.senac.controller;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.PacienteDAO;
import br.sc.senac.model.vo.PacienteVO;

public class PacienteController {

	private String mensagem = "";
	
	public String cadastrarPaciente(PacienteVO paciente) {
		
		if(validarCpf(paciente) && validarNome(paciente)) {
			PacienteDAO pacienteDAO = new PacienteDAO();
			pacienteDAO.inserir(paciente);
			mensagem = "Paciente Cadastrado com sucesso";
		}
		return mensagem;
	}

	private boolean validarNome(PacienteVO paciente) {
		if(paciente.getNome().length() < 3 || paciente.getNome().isEmpty() || paciente.getNome() == null) {
			mensagem = "NOME INVALIDO";
			return false;
		}
		return true;
	}

	private boolean validarCpf(PacienteVO paciente) {
		if(paciente.getCpf().length() != 11 || paciente.getCpf() == null || paciente.getCpf().isEmpty()) {
			mensagem = "CPF INVALIDO";
			return false;
		}			
		return true;
	}

}
