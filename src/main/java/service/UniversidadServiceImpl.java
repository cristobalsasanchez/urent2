package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import commons.GenericServiceImpl;
import daoApi.UniversidadDaoAPI;
import model.Universidad;

import service.UniversidadServiceAPI;

@Service
public class UniversidadServiceImpl extends GenericServiceImpl<Universidad, Integer> implements UniversidadServiceAPI{
	
	@Autowired
	private UniversidadDaoAPI universidadDaoAPI;
	@Override
	public CrudRepository<Universidad, Integer> getDao() {
		// TODO Auto-generated method stub
		return universidadDaoAPI;
	}
	

}
