package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ValorDao;
import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.Valor;

public class ValorDaoJDBC implements ValorDao{
	
private Connection conn;

	
	public ValorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Valor obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO tbl_valor " +
				"(valor_primeira_hora, valor_demais_horas, data_fim) " +
				"VALUES " +
				"(?,?,?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setDouble(1, obj.getValor_primeira_hora());
			st.setDouble(2, obj.getValor_demais_horas());
			st.setDate(3, (Date) obj.getData_fim());

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId_valor(id);
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
	public void update(Valor obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE tbl_valor " +
				"SET valor_primeira_hora = ?, valor_demais_horas = ?, data_fim = ?" +
				"WHERE id = ?");
			
			st.setDouble(1, obj.getValor_primeira_hora());
			st.setDouble(2, obj.getValor_demais_horas());
			st.setDate(3, (Date) obj.getData_fim());
			st.setLong(4, obj.getId_valor());

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
				"DELETE FROM tbl_valor WHERE id = ?");

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
	public Valor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM tbl_valor WHERE id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Valor obj = new Valor();
				obj.setId_valor(rs.getLong("id"));
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
	public List<Valor> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM tbl_valor ORDER BY valor_primeira_hora");
			rs = st.executeQuery();

			List<Valor> list = new ArrayList<>();

			while (rs.next()) {
				Valor obj = new Valor();
				obj.setId_valor(rs.getInt("id"));
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
