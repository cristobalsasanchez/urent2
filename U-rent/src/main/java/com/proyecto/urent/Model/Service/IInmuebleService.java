package com.proyecto.urent.Model.Service;

import com.proyecto.urent.Model.Entity.Inmueble;

import java.util.List;

public interface IInmuebleService {
    public List<Inmueble> findAll();

    public Inmueble findById(Integer id);

    public Inmueble save(Inmueble inmueble);

    public void delete (Integer id);
}
