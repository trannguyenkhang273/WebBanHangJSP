package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.model.ImagePlus;
import com.poly.utils.JpaUtils;

public class ImagePlusDAO {
	private EntityManager em = JpaUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	
	public ImagePlus create(ImagePlus entity) {
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
	
	public ImagePlus update(ImagePlus entity) {
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
	
	public ImagePlus remove(String id) {
		try {
			ImagePlus entity = findByid(id);
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
	
	public ImagePlus findByid(String id) {
		ImagePlus entity = em.find(ImagePlus.class, id);
		return entity;
	}
	
	public List<ImagePlus> findAll() {
		String jpql = "SELECT A FROM Products A";
		TypedQuery<ImagePlus> query = em.createQuery(jpql, ImagePlus.class);
		List<ImagePlus> list = query.getResultList();
		return list;
	}
	
	public List<ImagePlus> findByIdProduct(String id) {
		String jpql = "SELECT o FROM ImagePlus o where o.idProduct =:id";
		TypedQuery<ImagePlus> query = em.createQuery(jpql, ImagePlus.class);
		
		query.setParameter("id", id);
		
		List<ImagePlus> list = query.getResultList();
		for(ImagePlus image: list) {
			System.out.println(image.getImages());
		}
		return list;
		
	}
}
