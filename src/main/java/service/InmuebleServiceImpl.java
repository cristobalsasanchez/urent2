package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import commons.GenericServiceImpl;
import daoApi.InmuebleDaoAPI;
import model.Inmueble;

import service.InmuebleServiceAPI;
@Service
public class InmuebleServiceImpl extends GenericServiceImpl<Inmueble, Integer> implements InmuebleServiceAPI{
	@Autowired
	private InmuebleDaoAPI inmuebleDaoAPI;
	@Override
	public CrudRepository<Inmueble, Integer> getDao() {
		// TODO Auto-generated method stub
		return inmuebleDaoAPI;
	}
	

}
