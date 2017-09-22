package common.infrastructure.persistence.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import common.domain.model.GenericRepository;

@Transactional
public abstract class JpaGenericRepository<T, ID extends Serializable> implements GenericRepository<T, ID> {

	@PersistenceContext
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	protected abstract Class<T> getEntityClass();

	@Override
	public T find(ID id) {
		if (id == null) {
			throw new IllegalArgumentException(
					"Id must not be null");
		}
		return em.find(getEntityClass(), id);
	}

	@Override
	public T save(T entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(ID id) {
		T entity = em.find(getEntityClass(), id);
		delete(entity);
	}

	@Override
	public void delete(T entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

}
