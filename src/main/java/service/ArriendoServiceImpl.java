package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import commons.GenericServiceImpl;
import daoApi.ArriendoDaoAPI;
import model.Arriendo;

import service.ArriendoServiceAPI;

@Service
public class ArriendoServiceImpl extends GenericServiceImpl<Arriendo, Integer> implements ArriendoServiceAPI{
	@Autowired
	private ArriendoDaoAPI arriendoDaoAPI;
	@Override
	public CrudRepository<Arriendo, Integer> getDao() {
		// TODO Auto-generated method stub
		return arriendoDaoAPI;
	}
	
}
