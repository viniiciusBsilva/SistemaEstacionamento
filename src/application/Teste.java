package application;


import dao.DaoFactory;
import dao.UsuarioDao;
import model.Usuario;

public class Teste {

	public static void main(String[] args) {
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		
		Usuario dep2 = usuarioDao.findById(1);
		dep2.setNome("admin");
		dep2.setUsuario("admin");
		usuarioDao.update(dep2);
		System.out.println("Update completed");
	}

}
