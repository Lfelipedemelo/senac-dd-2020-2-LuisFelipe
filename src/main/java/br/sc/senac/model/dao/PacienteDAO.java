package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.model.vo.PacienteVO;


public class PacienteDAO {

	public PacienteVO inserir (PacienteVO pacienteVO) {

		String sql = "INSERT INTO PACIENTE (NOME, SEXO, CPF, REACAO, VOLUNTARIO) "
				+ "VALUES (?,?,?,?,?)";
		
		try (Connection conn = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatement(conn, sql);) {
			query.setString(1, pacienteVO.getNome());
			query.setString(2, pacienteVO.getSexo());
			query.setString(3, pacienteVO.getCpf());
			query.setInt(4, pacienteVO.getReacao());
			query.setBoolean(5, pacienteVO.isVoluntario());
		} catch(SQLException e) {
			System.out.println("Erro ao inserir paciente \nCausa: " + e.getMessage());
		}
		
		return pacienteVO;
	}
	
	public boolean alterar(PacienteVO pacienteVO) {
		String sql = " UPDATE PACIENTE "
				+ " SET NOME=?, SEXO=?, CPF=?, REACAO=?, VOLUNTARIO=? " 
				+ " WHERE ID=? ";
		
		boolean alterou = false;
		
		try (Connection conn = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatement(conn, sql);) {
			query.setString(1, pacienteVO.getNome());
			query.setString(2, pacienteVO.getSexo());
			query.setString(3, pacienteVO.getCpf());
			query.setInt(4, pacienteVO.getReacao());
			query.setBoolean(5, pacienteVO.isVoluntario());
			query.setInt(6, pacienteVO.getId());
			
			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao alterar Paciente.\nCausa: " + e.getMessage());
		}
				
		return alterou;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = " DELETE FROM PACIENTE WHERE IDPACIENTE=? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		boolean excluiu = false;
		try {
			query.setInt(1, id);		
			int codigoRetorno = query.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir paciente (id: " + id + ") .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}

		return excluiu;
	}
	
	public PacienteVO pesquisarPorId(int id) {
		String sql = "SELECT * FROM PACIENTE WHERE ID=?";
		PacienteVO pacienteBuscado = null;
		
		try (Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setInt(1, id);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				pacienteBuscado = construirPacienteDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereço por Id (id: " + id + ") .\nCausa: " + e.getMessage());
		}
		
		return pacienteBuscado;
	}
	
	public List<PacienteVO> pesquisarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PACIENTE ";
		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		List<PacienteVO> pacientesBuscados = new ArrayList<PacienteVO>();
		
		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while(conjuntoResultante.next()) {
				PacienteVO clienteBuscado = construirPacienteDoResultSet(conjuntoResultante);
				pacientesBuscados.add(clienteBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os clientes .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		
		return pacientesBuscados;
	}
	
	private PacienteVO construirPacienteDoResultSet(ResultSet conjuntoResultante) throws SQLException {
		PacienteVO pacienteBuscado = new PacienteVO();
		pacienteBuscado.setId(conjuntoResultante.getInt("id"));
		pacienteBuscado.setNome(conjuntoResultante.getString("nome"));
		pacienteBuscado.setCpf(conjuntoResultante.getString("cpf"));
		pacienteBuscado.setReacao(conjuntoResultante.getInt("reacao"));
		pacienteBuscado.setVoluntario(conjuntoResultante.getBoolean("voluntario"));
		
		return pacienteBuscado;
	}
}
