package br.sc.senac.view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.PacienteDAO;
import br.sc.senac.model.dao.VacinaDAO;
import br.sc.senac.model.vo.PacienteVO;
import br.sc.senac.model.vo.PesquisadorVO;
import br.sc.senac.model.vo.VacinaVO;

public class Tela {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		VacinaVO vacina = new VacinaVO();
		VacinaDAO vacinaDAO = new VacinaDAO();
		PesquisadorVO pesquisador = new PesquisadorVO();
		pesquisador.setId(1);
		System.out.println("Digite PAIS, ESTAGIO, DT_INICIO_PESQUISA");
		vacina.setPais(s.nextLine());
		vacina.setEstagio(s.nextInt());
		vacina.setDtInicioPesquisa("2020-02-01");
		vacina.setPesquisadorVO(pesquisador);
		vacinaDAO.inserir(vacina);
		
		
		/*PacienteVO pacienteVO = new PacienteVO();
		PacienteDAO pacienteDAO = new PacienteDAO();
		
		System.out.println("Digite nome, sexo, cpf, reacao, voluntario");
		pacienteVO.setNome(s.nextLine());
		pacienteVO.setSexo(s.nextLine());
		pacienteVO.setCpf(s.nextInt());
		pacienteVO.setReacao(s.nextInt());
		pacienteVO.setVoluntario(s.hasNextBoolean());
		
		pacienteDAO.inserir(pacienteVO);
		
		System.out.println("Digite o id para excluir");
		pacienteDAO.excluir(s.nextInt());*/
		
	}

}
