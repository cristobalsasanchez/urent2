package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import commons.GenericServiceImpl;
import daoApi.PropiedadDaoAPI;
import model.Propiedad;

import service.PropiedadServiceAPI;

@Service
public class PropiedadServiceImpl extends GenericServiceImpl<Propiedad, Integer> implements PropiedadServiceAPI{
	@Autowired
	private PropiedadDaoAPI propiedadDaoAPI;
	@Override
	public CrudRepository<Propiedad, Integer> getDao() {
		// TODO Auto-generated method stub
		return propiedadDaoAPI;
	}
	

}
