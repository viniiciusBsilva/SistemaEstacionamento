package dao;

import dao.impl.MovimentacaoDaoJDBC;
import dao.impl.UsuarioDaoJDBC;
import dao.impl.ValorDaoJDBC;
import db.DB;

public class DaoFactory {
	
	public static UsuarioDao createUsuarioDao() {
		return new UsuarioDaoJDBC(DB.getConnection());
	}
	public static MovimentacaoDao createMovimentacaoDao() {
		return new MovimentacaoDaoJDBC(DB.getConnection());
	}
	public static ValorDao createValorDao() {
		return new ValorDaoJDBC(DB.getConnection());
	}
}
