package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import commons.GenericServiceImpl;
import daoApi.DistanciaDaoAPI;
import model.Distancia;

import service.DistanciaServiceAPI;
@Service
public class DistanciaServiceImpl extends GenericServiceImpl<Distancia, Integer> implements DistanciaServiceAPI{
	@Autowired
	private DistanciaDaoAPI distanciaDaoAPI;
	@Override
	public CrudRepository<Distancia, Integer> getDao() {
		// TODO Auto-generated method stub
		return distanciaDaoAPI;
	}
	
	

}
