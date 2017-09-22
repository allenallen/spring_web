package common.domain.model;

import java.io.Serializable;

public interface GenericRepository<T, ID extends Serializable> {

	T find(ID id);

	T save(T entity);
	
	T update(T entity);
	
	void delete(ID id);

	void delete(T entity);

}
