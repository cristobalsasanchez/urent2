package com.urent.springboot.web.app.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.urent.springboot.web.app.model.Arrendatario;

public interface ArrendatarioDAOApi extends CrudRepository<Arrendatario, String> {

}
