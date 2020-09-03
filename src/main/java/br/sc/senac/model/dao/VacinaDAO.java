package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.model.vo.VacinaVO;

public class VacinaDAO implements BaseDAO<VacinaVO>{

	@Override
	public VacinaVO inserir(VacinaVO vacina) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO VACINA (IDPESQUISADOR, PAIS, ESTAGIO, DT_INICIO_PESQUISA)"
				+ " VALUES (?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatementWithGeneratedKeys(conn, sql);
		try {
			
			stmt.setInt(1, vacina.getPesquisadorVO().getId());
			stmt.setString(2, vacina.getPais());
			stmt.setInt(3, vacina.getEstagio());
			stmt.setString(4, vacina.getDtInicioPesquisa());

			/*int codigoRetorno = stmt.executeUpdate();
			if(codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet result = stmt.getGeneratedKeys();
				int idGerado = result.getInt(1);
				vacina.setIdVacina(idGerado);
			}*/
			
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
		String sql = "UPDATE VACINA SET IDPESQUISADOR = ?"
				+ ", PAIS = ?, ESTAGIO = ?, DT_INICIO_PESQUISA = ?"
				+ " WHERE IDVACINA = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		boolean alterou = false;
		try {			
			stmt.setInt(1, vacina.getPesquisadorVO().getId());
			stmt.setString(2, vacina.getPais());
			stmt.setString(3, vacina.getDtInicioPesquisa());
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
		VacinaVO vacina = new VacinaVO();
		vacina.setIdVacina(result.getInt("IDVACINA"));
		vacina.setEstagio(result.getInt("ESTAGIO"));
		vacina.setDtInicioPesquisa(result.getString("DT_INICIO_PESQUISA"));
		
		return vacina;
	}

}
