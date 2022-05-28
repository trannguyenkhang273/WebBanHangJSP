package com.poly.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.poly.dao.ImagePlusDAO;
import com.poly.model.ImagePlus;
import com.poly.model.Products;

public class JpaProgram {
	public static void main(String[] args) {
//		create();
		findAll();
	}
	
//	private static void create() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
//		EntityManager em = emf.createEntityManager();
//		try {
//			em.getTransaction().begin();
//			
//			Products entity = new Products();
//			entity.setId("TeoNV");
//			entity.setPassword("1234");
//			entity.setFullname("Nguyễn Văn Tèo");
//			entity.setEmail("TEO@gmail.com");
//			entity.setAdmin(false);
//			em.persist(entity);
//			
//			em.getTransaction().commit();
//			System.out.println("Thêm mới thành công");
//		}catch (Exception e) {
//			// TODO: handle exception
//			em.getTransaction().rollback();
//			System.out.println("Thêm mới thất bại");
//		}
//		em.close();
//		emf.close();
//	}
//	
//	private static void update() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
//		EntityManager em = emf.createEntityManager();
//		try {
//			em.getTransaction().begin();
//			
//			// Truy vấn thực thể theo id
//			Products entity = em.find(Products.class, "KhangTN");
//			// Thay đổi thông tin thực thể
//			entity.setPassword("poly@2020");
//			entity.setAdmin(false);
//			// Cập nhật thực thể
//			em.merge(entity);
//			
//			em.getTransaction().commit();
//			System.out.println("Cập nhật thành công");
//		}catch (Exception e) {
//			// TODO: handle exception
//			em.getTransaction().rollback();
//			System.out.println("Cập nhật thất bại");
//		}
//		em.close();
//		emf.close();
//	}
//	private static void delete() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
//		EntityManager em = emf.createEntityManager();
//		try {
//			em.getTransaction().begin();
//			
//			// Truy vấn thực thể theo id
//			Products entity = em.find(Products.class, "KhangTN");
//			em.remove(entity);
//			
//			em.getTransaction().commit();
//			System.out.println("Cập nhật thành công");
//		}catch (Exception e) {
//			// TODO: handle exception
//			em.getTransaction().rollback();
//			System.out.println("Cập nhật thất bại");
//		}
//		em.close();
//		emf.close();
//	}
	
	private static void findAll() {
		System.out.println("1");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASM_JAVA4");
		System.out.println("2");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			// Truy vấn thực thể theo id WHERE o.IdProducts like ?
			String jpql = "SELECT o FROM ImagePlus o WHERE o.idProduct = :id";
			TypedQuery<ImagePlus> query = em.createQuery(jpql, ImagePlus.class);
			String id = "MT1";
			query.setParameter("id", id);
			
			List<ImagePlus> list = query.getResultList();
			for(ImagePlus image: list) {
				System.out.println(image.getImages());
			}
		}catch (Exception e) {
				// TODO: handle exception
				em.getTransaction().rollback();
				System.out.println("truy vấn thất bại");
				throw new RuntimeException(e);
			}
		em.close();
		emf.close();
	}
	
//	private static void findByRole(boolean role) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
//		EntityManager em = emf.createEntityManager();
//		try {
//			em.getTransaction().begin();
//			
//			String jpql = "SELECT o FROM Users o WHERE o.admin=:role";
//			// Tạo đối tượng truy vấn
//			TypedQuery<Products> query = em.createQuery(jpql, Products.class);
//			query.setParameter("role", role);
//			// Truy vấn
//			List<Products> list = query.getResultList();
//			// Hiển thị kết quả truy vấn
//			for(Products user: list) {
//				System.out.println(">>Fullname: " + user.getFullname());
//				System.out.println(">>Is Admin: " + user.isAdmin());
//			}
//		}catch (Exception e) {
//				// TODO: handle exception
//				em.getTransaction().rollback();
//				System.out.println("truy vấn thất bại");
//			}
//		em.close();
//		emf.close();
//	}
//	
//	private static void findByKeyword(String keywork) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
//		EntityManager em = emf.createEntityManager();
//		try {
//			em.getTransaction().begin();
//			
//			String jpql = "SELECT o FROM Users o WHERE o.fullname LIKE ?0";
//			// Tạo đối tượng truy vấn
//			TypedQuery<Products> query = em.createQuery(jpql, Products.class);
//			query.setParameter(0, keywork);
//			// Truy vấn
//			List<Users> list = query.getResultList();
//			// Hiển thị kết quả truy vấn
//			for(Products user: list) {
//				System.out.println(">>Fullname: " + user.getFullname());
//				System.out.println(">>Is Admin: " + user.isAdmin());
//			}
//		}catch (Exception e) {
//				// TODO: handle exception
//				em.getTransaction().rollback();
//				System.out.println("truy vấn thất bại");
//			}
//		em.close();
//		emf.close();
//	}
//	
//	private static void findOne(String username, String password) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
//		EntityManager em = emf.createEntityManager();
//		try {
//			em.getTransaction().begin();
//			
//			String jpql = "SELECT o FROM Users o WHERE o.id=:id AND o.password=:pw";
//			// Tạo đối tượng truy vấn
//			TypedQuery<Products> query = em.createQuery(jpql, Products.class);
//			query.setParameter("id", username); 
//			query.setParameter("pw", password);
//			// Truy vấn một thực thể
//			Products user = query.getSingleResult();
//			// Hiển thị kết quả truy vấn
//				System.out.println(">>Fullname: " + user.getFullname());
//				System.out.println(">>Is Admin: " + user.isAdmin());
//		}catch (Exception e) {
//				// TODO: handle exception
//				em.getTransaction().rollback();
//				System.out.println("truy vấn thất bại");
//			}
//		em.close();
//		emf.close();
//	}
	
//	private static void findPage(int page, int size) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
//		EntityManager em = emf.createEntityManager();
//		try {
//			em.getTransaction().begin();
//			
//			String jpql = "SELECT o FROM Users o";
//			// Tạo đối tượng truy vấn
//			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
//			query.setFirstResult(page * size); 
//			query.setMaxResults(size);
//			// Truy vấn
//			List<Users> list = query.getResultList();
//			// Hiển thị kết quả truy vấn
//			for(Users user: list) {
//				System.out.println(">>Fullname: " + user.getFullname());
//				System.out.println(">>Is Admin: " + user.isAdmin());
//			}
//		}catch (Exception e) {
//				// TODO: handle exception
//				em.getTransaction().rollback();
//				System.out.println("truy vấn thất bại");
//			}
//		em.close();
//		emf.close();
//	}
	
}
