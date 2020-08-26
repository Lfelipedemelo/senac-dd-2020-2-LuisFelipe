package br.sc.senac.view;

import java.util.Scanner;

import br.sc.senac.model.dao.PacienteDAO;
import br.sc.senac.model.vo.PacienteVO;

public class Tela {

	public static void main(String[] args) {
		PacienteVO pacienteVO = new PacienteVO();
		Scanner s = new Scanner(System.in);
		PacienteDAO pacienteDAO = new PacienteDAO();
		
		/*System.out.println("Digite nome, sexo, cpf, reacao, voluntario");
		pacienteVO.setNome(s.nextLine());
		pacienteVO.setSexo(s.nextLine());
		pacienteVO.setCpf(s.nextInt());
		pacienteVO.setReacao(s.nextInt());
		pacienteVO.setVoluntario(s.hasNextBoolean());
		
		pacienteDAO.inserir(pacienteVO);*/
		
		System.out.println("Digite o id para excluir");
		pacienteDAO.excluir(s.nextInt());
		
	}

}
