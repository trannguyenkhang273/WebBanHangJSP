package com.poly.dao;

import java.util.List;

public abstract class DAO <E,K>{
	abstract public void insert(E entity);
	abstract public void update(E entity);
	abstract public void delete(K key);
	abstract public List<E> findAll();
	abstract public E findById(K key);
}
