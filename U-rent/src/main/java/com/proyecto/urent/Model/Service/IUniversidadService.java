package com.proyecto.urent.Model.Service;

import com.proyecto.urent.Model.Entity.Universidad;

import java.util.List;

public interface IUniversidadService {
    public List<Universidad> findAll();

    public Universidad findById(Integer id);

    public Universidad save(Universidad universidad);

    public void delete (Integer id);
}
