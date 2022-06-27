package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.MovimentacaoDao;
import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.Movimentacao;


public class MovimentacaoDaoJDBC implements MovimentacaoDao{
	
private Connection conn;

	
	public MovimentacaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Movimentacao obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO tbl_movimentacao " +
				"(placa, modelo, data_entrada) " +
				"VALUES " +
				"(?,?,?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getPlaca());
			st.setString(2, obj.getModelo());
			st.setDate(3, (Date) obj.getData_entrada());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId_movimentacao(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Movimentacao obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE tbl_movimentacao " +
				"SET placa = ?, modelo = ?" +
				"WHERE id = ?");
			
			st.setString(1, obj.getPlaca());
			st.setString(2, obj.getModelo());
			st.setLong(3, obj.getId_movimentacao());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM tbl_movimentacao WHERE id = ?");

			st.setLong(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Movimentacao findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM tbl_movimentacao WHERE id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Movimentacao obj = new Movimentacao();
				obj.setId_movimentacao(rs.getLong("id"));
				obj.setPlaca(rs.getString("placa"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Movimentacao> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM tbl_movimentacao ORDER BY placa");
			rs = st.executeQuery();

			List<Movimentacao> list = new ArrayList<>();

			while (rs.next()) {
				Movimentacao obj = new Movimentacao();
				obj.setId_movimentacao(rs.getInt("id"));
				obj.setPlaca(rs.getString("nome"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	

}

