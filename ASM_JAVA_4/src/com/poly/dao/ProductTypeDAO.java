package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.model.ProductType;
import com.poly.utils.JpaUtils;

public class ProductTypeDAO  {
	private EntityManager em = JpaUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	
	public ProductType create(ProductType entity) {
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
	
	public ProductType update(ProductType entity) {
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
	
	public ProductType remove(String id) {
		try {
			ProductType entity = findByid(id);
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
	
	public ProductType findByid(String id) {
		ProductType entity = em.find(ProductType.class, id);
		return entity;
	}
	
	public List<ProductType> findAll() {
		String jpql = "SELECT A FROM ProductType A";
		TypedQuery<ProductType> query = em.createQuery(jpql, ProductType.class);
		List<ProductType> list = query.getResultList();
		for(ProductType a:list) {
			System.out.println(a.getIdType());
			System.out.println(a.getProductName());
		}
		return list;
	}
	

}
