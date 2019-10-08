package com.urent.springboot.web.app.commons;

import java.io.Serializable;

import java.util.List;

public interface GenericServiceApi<T, ID extends Serializable> {

	T save(T entity);
	void deleteID(ID id);
	T get(ID id);
	List<T> getAll();
}
