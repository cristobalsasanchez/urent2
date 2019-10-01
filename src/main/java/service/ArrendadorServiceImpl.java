package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import commons.GenericServiceImpl;
import daoApi.ArrendadorDaoAPI;
import model.Arrendador;

import service.ArrendadorServiceAPI;
@Service
public class ArrendadorServiceImpl extends GenericServiceImpl<Arrendador,String> implements ArrendadorServiceAPI{
	@Autowired
	private ArrendadorDaoAPI arrendadorDaoAPI;
	@Override
	public CrudRepository<Arrendador, String> getDao() {
		// TODO Auto-generated method stub
		return arrendadorDaoAPI;
	}

}
