package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDao;
import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.Usuario;

public class UsuarioDaoJDBC implements UsuarioDao{

	private Connection conn;

	
	public UsuarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	

	public void insert(Usuario obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO tbl_usuario " +
				"(nome, usuario, senha) " +
				"VALUES " +
				"(?,?,?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());
			st.setString(2, obj.getUsuario());
			st.setString(3, obj.getSenha());

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
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
	public void update(Usuario obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE tbl_usuario " +
				"SET nome = ?, usuario = ?" +
				"WHERE id = ?");
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getUsuario());
			st.setLong(3, obj.getId());

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
				"DELETE FROM tbl_usuario WHERE id = ?");

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

	public Usuario findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM tbl_usuario WHERE Id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Usuario obj = new Usuario();
				obj.setId(rs.getLong("id"));
				obj.setNome(rs.getString("nome"));
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
	public List<Usuario> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM tbl_usuario ORDER BY nome");
			rs = st.executeQuery();

			List<Usuario> list = new ArrayList<>();

			while (rs.next()) {
				Usuario obj = new Usuario();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
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
