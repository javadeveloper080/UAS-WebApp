package org.edu.uams.server.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Dao<T extends Serializable> {

	public void delete(T entity);

	public T findByPrimaryKey(long id);

	public List<T> findAll();

	public T persist(T entity);

	public T update(T entity);

	public List<T> findListByQuery(String queryText, Map<String, Object> params);

	public T findByQuery(String queryText, Map<String, Object> params);
	
	public T load(Class<T> entity,long id);

}