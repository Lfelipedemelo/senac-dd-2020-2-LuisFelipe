package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.model.vo.PesquisadorVO;
import br.sc.senac.model.vo.VacinaVO;

public class PesquisadorDAO implements BaseDAO<PesquisadorVO>{

	@Override
	public PesquisadorVO inserir(PesquisadorVO pesquisador) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO PESQUISADOR (NOME, DATA_NASCIMENTO, SEXO, CPF, REACAO, INSTITUICAO)"
				+ " VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatementWithGeneratedKeys(conn, sql);
		try {
			
			java.sql.Date date = java.sql.Date.valueOf(pesquisador.getDataNascimento());
		
			stmt.setString(1,pesquisador.getNome());
			stmt.setDate(2,date);
			stmt.setString(3,pesquisador.getSexo());
			stmt.setString(4,pesquisador.getCpf());
			stmt.setInt(5, 1);
			stmt.setString(6,pesquisador.getInstituicao());

		} catch (Exception e) {
			System.out.println("Erro ao inserir Pesquisador\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return pesquisador;
	}

	@Override
	public boolean alterar(PesquisadorVO pesquisador) {
		Connection conn = Banco.getConnection();
		String sql = "UPDATE PESQUISADOR SET NOME = ?"
				+ ", DATA_NASCIMENTO = ?, SEXO = ?, CPF = ?, REACAO = ?, INSTITUICAO = ?"
				+ " WHERE IDPESQUISADOR = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		boolean alterou = false;
		try {			
			
			java.sql.Date date = java.sql.Date.valueOf(pesquisador.getDataNascimento());
			
			stmt.setString(1,pesquisador.getNome());
			stmt.setDate(2,date);
			stmt.setString(3,pesquisador.getSexo());
			stmt.setString(4,pesquisador.getCpf());
			stmt.setInt(5,pesquisador.getReacao());
			stmt.setString(6,pesquisador.getInstituicao());
			
			int codigoRetorno = stmt.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (Exception e) {
			System.out.println("Erro ao alterar Vacina\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return alterou;
	}

	@Override
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM PESQUISADOR WHERE IDPESQUISADOR = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		boolean excluiu = false;

		try {
			stmt.setInt(1, id);
			int result = stmt.executeUpdate();
			excluiu = (result == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (Exception e) {
			System.out.println("Erro ao deletar pesquisador\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	@Override
	public List<PesquisadorVO> pesquisarTodos() {
		Connection conn = Banco.getConnection();
		ResultSet result = null;
		PesquisadorVO pesquisador = new PesquisadorVO();
		String sql = "SELECT * FROM VACINA";
		List<PesquisadorVO> pesquisadoresBuscados = new ArrayList<PesquisadorVO>();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		try {
			result = stmt.executeQuery();
			while (result.next()) {
				pesquisador = construirDoResultSet(result);
				pesquisadoresBuscados.add(pesquisador);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar Todas as vacinas\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pesquisadoresBuscados;
	}

	@Override
	public PesquisadorVO pesquisarPorId(int id) {
		ResultSet result = null;
		PesquisadorVO pesquisador = new PesquisadorVO();
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM VACINA WHERE IDVACINA = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		try {
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			if(result.next()) {
				pesquisador = construirDoResultSet(result);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar por id\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pesquisador;
	}

	@Override
	public PesquisadorVO construirDoResultSet(ResultSet result) throws SQLException {
		
		LocalDate date = result.getDate("DATA_NASCIMENTO").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		PesquisadorVO pesquisador = new PesquisadorVO();
		pesquisador.setId(result.getInt("IDPESQUISADOR"));
		pesquisador.setNome(result.getString("NOME"));
		pesquisador.setDataNascimento(date);
		pesquisador.setCpf(result.getString("CPF"));
		pesquisador.setReacao(result.getInt("REACAO"));
		pesquisador.setInstituicao(result.getString("INSTITUICAO"));

		
		return pesquisador;
	}

}
