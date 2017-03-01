/**
 * 
 */
package com.android.server.metier;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.android.server.model.IGenericRepository;


/**
 * @author SABER KHALIFA
 *
 */
@Service
@Transactional
public class MetierRepository<T> implements IMetierRepository<T>,Serializable {
	private static final long serialVersionUID = 1L;
	private IGenericRepository<T> dao;

	@Override
	public void insert(T temp) {
		// TODO Auto-generated method stub
       dao.insert(temp);
	}

	@Override
	public T update(T temp) {
		// TODO Auto-generated method stub
		return dao.update(temp);
	}

	@Override
	public void delete(T temp) {
		// TODO Auto-generated method stub
		dao.delete(temp);
	}

	@Override
	public T find(Class<T> temp, Long id) {
		// TODO Auto-generated method stub
		return dao.find(temp, id);
	}

	@Override
	public List<T> findAll(Class<T> temp) {
		// TODO Auto-generated method stub
		return dao.findAll(temp);
	}

	public IGenericRepository<T> getDao() {
		return dao;
	}

	public void setDao(IGenericRepository<T> dao) {
		this.dao = dao;
	}

}
