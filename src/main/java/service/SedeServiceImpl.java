package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import commons.GenericServiceImpl;
import daoApi.SedeDaoAPI;
import model.Sede;

import service.SedeServiceAPI;

@Service
public class SedeServiceImpl extends GenericServiceImpl<Sede, Integer> implements SedeServiceAPI {
	@Autowired
	private SedeDaoAPI sedeDaoAPI;
	@Override
	public CrudRepository<Sede, Integer> getDao() {
		// TODO Auto-generated method stub
		return sedeDaoAPI;
	}

}
