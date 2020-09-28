package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.model.vo.VacinaVO;

public class VacinaDAO implements BaseDAO<VacinaVO>{

	@Override
	public VacinaVO inserir(VacinaVO vacina) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO VACINA (PESQUISADOR, PAIS, ESTAGIO, DT_INICIO_PESQUISA)"
				+ " VALUES (?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatementWithGeneratedKeys(conn, sql);
		try {
			
			java.sql.Date date = java.sql.Date.valueOf(vacina.getDtInicioPesquisa());
			
			stmt.setString(1, vacina.getPesquisador());
			stmt.setString(2, vacina.getPais());
			stmt.setInt(3, vacina.getEstagio());
			stmt.setDate(4, date);
			
		} catch (Exception e) {
			System.out.println("Erro ao inserir vacina\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return vacina;
	}

	@Override
	public boolean alterar(VacinaVO vacina) {
		Connection conn = Banco.getConnection();
		String sql = "UPDATE VACINA SET PESQUISADOR = ?"
				+ ", PAIS = ?, ESTAGIO = ?, DT_INICIO_PESQUISA = ?"
				+ " WHERE IDVACINA = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		boolean alterou = false;
		try {			
			
			java.sql.Date date = java.sql.Date.valueOf(vacina.getDtInicioPesquisa());
			
			stmt.setString(1, vacina.getPesquisador());
			stmt.setString(2, vacina.getPais());
			stmt.setDate(3, date);
			stmt.setInt(5, vacina.getIdVacina());
			
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
		String sql = "DELETE FROM VACINA WHERE IDVACINA = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		boolean excluiu = false;

		try {
			stmt.setInt(1, id);
			int result = stmt.executeUpdate();
			excluiu = (result == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (Exception e) {
			System.out.println("Erro ao deletar vacina\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	@Override
	public List<VacinaVO> pesquisarTodos() {
		Connection conn = Banco.getConnection();
		ResultSet result = null;
		VacinaVO vacina = new VacinaVO();
		String sql = "SELECT * FROM VACINA";
		List<VacinaVO> vacinasBuscadas = new ArrayList<VacinaVO>();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		try {
			result = stmt.executeQuery();
			while (result.next()) {
				vacina = construirDoResultSet(result);
				vacinasBuscadas.add(vacina);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar Todas as vacinas\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vacinasBuscadas;
	}

	@Override
	public VacinaVO pesquisarPorId(int id) {
		ResultSet result = null;
		VacinaVO vacina = new VacinaVO();
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM VACINA WHERE IDVACINA = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		try {
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			if(result.next()) {
				vacina = construirDoResultSet(result);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar por id\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vacina;
	}

	@Override
	public VacinaVO construirDoResultSet(ResultSet result) throws SQLException {
		
		LocalDate date = result.getDate("DT_INICIO_PESQUISA").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		VacinaVO vacina = new VacinaVO();
		vacina.setIdVacina(result.getInt("IDVACINA"));
		vacina.setEstagio(result.getInt("ESTAGIO"));
		vacina.setDtInicioPesquisa(date);
		
		return vacina;
	}

}
