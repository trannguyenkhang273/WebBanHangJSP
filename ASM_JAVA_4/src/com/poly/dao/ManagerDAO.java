package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.utils.JpaUtils;
import com.poly.model.Manager;




public class ManagerDAO extends DAO<Manager,String>{

	private EntityManager em = JpaUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}
	@Override
	public void insert(Manager entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Manager entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(String key) {
		Manager favorite = this.findById(key);
		try {
			em.getTransaction().begin();	
			em.remove(favorite);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Manager> findAll() {
		String jpql = "SELECT o FROM Manager o";
		TypedQuery<Manager> query = em.createQuery(jpql,Manager.class);
		List<Manager> list = query.getResultList();
		return list;// TODO Auto-generated method stub
	}
	
	@Override
	public Manager findById(String key) {
		Manager favorite = em.find(Manager.class, key);
		return favorite;
	}

}
