package main.dao;
import main.model.Client;

public interface ClientDao extends DaoGeneric<Client, Integer>{
	Client findByCompte(String key);
	void deleteByCompte(String key);
}
