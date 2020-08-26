package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.sc.senac.model.vo.PacienteVO;

public class PacienteDAO {

	public PacienteVO inserir (PacienteVO pacienteVO) {
		Connection conn = Banco.getConnection();
		
		String sql = "INSERT INTO PACIENTE (NOME, SEXO, CPF, REACAO, VOLUNTARIO) "
				+ "VALUES (?,?,?,?,?)";
				
		PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conn, sql);
		
		try {
			query.setString(1, pacienteVO.getNome());
			query.setString(2, pacienteVO.getSexo());
			query.setInt(3, pacienteVO.getCpf());
			query.setInt(4, pacienteVO.getReacao());
			query.setBoolean(5, pacienteVO.isVoluntario());
			
			int codigoRetorno = query.executeUpdate();
			
			/*if (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt("IDPACIENTE");
				pacienteVO.setId(chaveGerada);
			}*/
		} catch(SQLException e) {
			System.out.println("Erro ao inserir paciente \nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);;
		}
		
		return pacienteVO;
	}
	
	public boolean excluir(int id) {
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM PACIENTE WHERE IDPACIENTE=? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;
		try {
			query.setInt(1, id);
			
			int codigoRetorno = query.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir endereço (id: " + id + ") .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}
				
		return excluiu;
	}
}
