package org.edu.uams.server.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.edu.uams.server.api.Dao;
import org.edu.uams.server.util.SessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public  abstract class AbstractDao<T extends Serializable> implements Dao<T>{


	protected Session session;
	protected Class<? extends T> entityClass;


	public AbstractDao(final Class<? extends T> paramEntityClass) {
		session=SessionFactoryUtil.getSession();
		if (paramEntityClass!=null) {
			this.entityClass=paramEntityClass;
		}
	}

	@Override
	public T persist(T entity) {
		Transaction transaction = this.session.getTransaction();
		transaction.begin();
		this.session.save(entity);
		transaction.commit();
		return entity;
	}

	@Override
	public T update(T entity) {
		Transaction transaction = this.session.getTransaction();
		transaction.begin();
		this.session.merge(entity);
		transaction.commit();
		return entity;
	}

	@Override
	public void delete(T entity) {
		if (entity==null) {
			return;
		}
		Transaction transaction = this.session.getTransaction();
		transaction.begin();
		this.session.delete(entity);
		this.session.flush();
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByPrimaryKey(Serializable id) {
		Transaction transaction = this.session.getTransaction();
		transaction.begin();
		return (T) session.get(entityClass, id);
	}

	//returns single record if available
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public T findByQuery(String queryText,Map<String,Object> params) {
		Query query = session.createQuery(queryText);

		if (params!=null && !params.isEmpty()) {
			Set<String> keys = params.keySet();
			for (String key : keys) {
				if (params.get(key)!=null) {
					query.setParameter(key, params.get(key));
				}
			}
		}

		List resultlist = query.list();

		if (resultlist!=null && resultlist.size()>0) {
			return (T) query.list().get(0);
		}
		else{
			return null;
		}
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<T> findListByQuery(String queryText,Map<String,Object> params) {
		Query query = session.createQuery(queryText);

		if (params!=null && !params.isEmpty()) {
			Set<String> keys = params.keySet();
			for (String key : keys) {
				if (params.get(key)!=null) {
					query.setParameter(key, params.get(key));
				}
			}
		}
		return  query.list();
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public T load(Class<T> entity,long id) {
		Transaction transaction = this.session.getTransaction();
		transaction.begin();
		
		
		return (T)session.load(entityClass, id);
	}

}
