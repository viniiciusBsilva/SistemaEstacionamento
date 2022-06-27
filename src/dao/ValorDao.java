package dao;

import java.util.List;

import model.Valor;

public interface ValorDao {
	void insert(Valor obj);
	void update(Valor obj);
	void deleteById(Integer id);
	Valor findById(Integer id);
	List<Valor> findAll();
}
