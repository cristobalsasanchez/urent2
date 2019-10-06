package com.proyecto.urent.Model.Service;

import com.proyecto.urent.Model.Entity.Arrendador;

import java.util.List;

public interface IArrendadorService {

    public List<Arrendador> findAll();

    public Arrendador findById(Integer id);

    public Arrendador save(Arrendador arrendador);

    public void delete (Integer id);
}
