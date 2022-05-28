package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.model.Products;
import com.poly.utils.JpaUtils;

public class ProductsDAO {
	private EntityManager em = JpaUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	
	public Products create(Products entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		}catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public Products update(Products entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		}catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public Products remove(String id) {
		try {
			Products entity = findByid(id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		}catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public Products findByid(String id) {
		Products entity = em.find(Products.class, id);
		return entity;

	}
	public List<Products> findByidBill(int id) {
		String jpql = "select o from Products o where o.idProduct in(select s.idProduct from BillDetails s where s.billId = ?0) ";
		TypedQuery<Products> query = em.createQuery(jpql, Products.class);
		query.setParameter(0, id);
		List<Products> list = query.getResultList();
		return list;
	}
	
	
	public List<Products> findAll() {
		String jpql = "SELECT A FROM Products A";
		TypedQuery<Products> query = em.createQuery(jpql, Products.class);
		List<Products> list = query.getResultList();
		return list;
	}
	
	public List<Products> findByMenu(String TypeId) {
		String jpql = "SELECT A FROM Products A WHERE A.idType =:id";
		TypedQuery<Products> query = em.createQuery(jpql, Products.class);
		query.setParameter("id", TypeId);
		List<Products> list = query.getResultList();
		return list;
	}
}
