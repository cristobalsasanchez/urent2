package com.proyecto.urent.Model.Service;

import com.proyecto.urent.Model.Entity.Sede;

import java.util.List;

public interface ISedeService {
    public List<Sede> findAll();

    public Sede findById(Integer id);

    public Sede save(Sede sede);

    public void delete (Integer id);
}
