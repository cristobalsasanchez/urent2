package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import commons.GenericServiceImpl;
import daoApi.ArrendatarioDaoAPI;
import model.Arrendatario;

import service.ArrendatarioServiceAPI;

@Service
public class ArrendatarioServiceImpl extends GenericServiceImpl<Arrendatario, String> implements ArrendatarioServiceAPI{
	@Autowired
	private ArrendatarioDaoAPI arrendatarioDaoAPI;
	@Override
	public CrudRepository<Arrendatario, String> getDao() {

		return arrendatarioDaoAPI;
	}

}
