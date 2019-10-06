package com.proyecto.urent.Model.Service;

import com.proyecto.urent.Model.Entity.Propiedad;

import java.util.List;

public interface IPropiedadService {
    public List<Propiedad> findAll();

    public Propiedad findById(Integer id);

    public Propiedad save(Propiedad propiedad);

    public void delete (Integer id);
}
