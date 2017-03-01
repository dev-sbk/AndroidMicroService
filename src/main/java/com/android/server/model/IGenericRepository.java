package com.android.server.model;

import java.util.List;
/**
 * 
 * @author SABER KHALIFA
 *
 * @param <T>
 */
public interface IGenericRepository<T> {
	public void insert(T temp);
	public T update(T temp);
	public void delete(T temp);
	public T find(Class<T> temp,Long id);
	public List<T> findAll(Class<T> temp);

}
