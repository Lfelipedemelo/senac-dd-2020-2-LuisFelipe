package br.sc.senac.view;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.PacienteDAO;
import br.sc.senac.model.dao.VacinaDAO;
import br.sc.senac.model.vo.PacienteVO;
import br.sc.senac.model.vo.PesquisadorVO;
import br.sc.senac.model.vo.VacinaVO;

public class Tela {

	public static void main(String[] args) {
		
		VacinaVO vacina = new VacinaVO();
		vacina.setPais("Brasil");
		vacina.setEstagio("");
		vacina.setPesquisador("Luis");
		vacina.setDtInicioPesquisa(LocalDate.now());
		
		VacinaDAO vacinaDAO = new VacinaDAO();
		vacina = vacinaDAO.inserir(vacina);
		JOptionPane.showMessageDialog(null, vacina.getIdVacina());
		
	}

}
