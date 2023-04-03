package main.dao;
import java.util.List;

public interface DaoGeneric<T, K> {

	void insert(T obj);

	void update(T obj);
	
	void deleteByKey(K key);

	void delete(T obj);

	T findByKey(K key);

	List<T> findAll();
}
