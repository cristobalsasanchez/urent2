package com.urent.springboot.web.app.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.urent.springboot.web.app.model.Arrendador;

public interface ArrendadorDAOApi extends CrudRepository<Arrendador, String> {

}
