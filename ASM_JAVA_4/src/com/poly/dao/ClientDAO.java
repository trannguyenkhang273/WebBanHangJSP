package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.model.Client;
import com.poly.utils.JpaUtils;

public class ClientDAO {
	private EntityManager em = JpaUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	
	public Client create(Client entity) {
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
	
	public Client update(Client entity) {
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
	
	public Client remove(String id) {
		try {
			Client entity = findByid(id);
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
	
	public Client findByid(String id) {
		Client entity = em.find(Client.class, id);
		return entity;
	}
	
	public List<Client> findAll() {
		String jpql = "SELECT A FROM Products A";
		TypedQuery<Client> query = em.createQuery(jpql, Client.class);
		List<Client> list = query.getResultList();
		return list;
	}
}
