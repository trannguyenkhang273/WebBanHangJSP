package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.model.Bill;
import com.poly.model.Manager;
import com.poly.utils.JpaUtils;

public class BillDAO {
	private EntityManager em = JpaUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}
	public void insert(Bill entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public void update(Bill entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public void delete(Integer key) {
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

	public List<Bill> findAll() {
		String jpql = "SELECT o FROM Bill o";
		TypedQuery<Bill> query = em.createQuery(jpql,Bill.class);
		List<Bill> list = query.getResultList();
		return list;// TODO Auto-generated method stub
	}
	
	public Manager findById(Integer key) {
		Manager favorite = em.find(Manager.class, key);
		return favorite;
	}
	public Bill findByUser(String user) {
		String jpql = "SELECT o FROM Bill o where o.username like :key";
		TypedQuery<Bill> query = em.createQuery(jpql,Bill.class);
		query.setParameter("key",user );
		List<Bill> list = query.getResultList();
		return list.get(0);// TODO Auto-generated method stub
	}
}
