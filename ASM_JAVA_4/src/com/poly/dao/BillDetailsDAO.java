package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.model.Bill;
import com.poly.model.BillDetails;
import com.poly.model.Manager;
import com.poly.utils.JpaUtils;

public class BillDetailsDAO extends DAO<BillDetails, Integer> {

	private EntityManager em = JpaUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}
	@Override
	public void insert(BillDetails entity) {
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
	public void update(BillDetails entity) {
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
	public void delete(Integer key) {
		BillDetails favorite = this.findById(key);
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
	public List<BillDetails> findAll() {
		String jpql = "SELECT o FROM BillDetails o";
		TypedQuery<BillDetails> query = em.createQuery(jpql,BillDetails.class);
		List<BillDetails> list = query.getResultList();
		return list;// TODO Auto-generated method stub
	}
	
	public BillDetails findByProdcut(String id,int id_bill) {
		String jpql = "select o FROM BillDetails o where o.idProduct like :key and o.billId = :key2";
		TypedQuery<BillDetails> query = em.createQuery(jpql,BillDetails.class);
		query.setParameter("key", id);
		query.setParameter("key2", id_bill);
		List<BillDetails> list = query.getResultList();
		return list.get(0);// TODO Auto-generated method stub
	}
	
	public List<BillDetails> findByBill(int bill) {
		String jpql = "SELECT o FROM " + BillDetails.class.getName() +" o where o.billId = :keyword";
		System.out.println(BillDetails.class.getName() );
		TypedQuery<BillDetails> query = em.createQuery(jpql,BillDetails.class);
		query.setParameter("keyword", bill);
		List<BillDetails> list = query.getResultList();
		return list;// TODO Auto-generated method stub
	}
	@Override
	public BillDetails findById(Integer key) {
		BillDetails favorite = em.find(BillDetails.class, key);
		return favorite;
	}

}
