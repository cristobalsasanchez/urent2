package com.proyecto.urent.Model.Service;

import com.proyecto.urent.Model.Entity.Arrendatario;

import java.util.List;

public interface IArrendatarioService {

    public List<Arrendatario> findAll();

    public Arrendatario findById(Integer id);

    public Arrendatario save(Arrendatario arrendatario);

    public void delete (Integer id);
}
