package br.sc.senac.controller;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.PacienteDAO;
import br.sc.senac.model.vo.PacienteVO;

public class PacienteController {

	public String CadastrarPaciente(PacienteVO paciente) {
		if(paciente.getNome().length() < 2 || paciente.getNome().isEmpty() || paciente.getNome() == null) {
			JOptionPane.showMessageDialog(null, "NOME INVALIDO");
		}
		if(paciente.getCpf().length() != 11 || paciente.getCpf() == null || paciente.getCpf().isEmpty()) {
			JOptionPane.showMessageDialog(null, "CPF INVALIDO");
		}
		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.inserir(paciente);
		
		return "Paciente Cadastrado com sucesso";
	}

}
