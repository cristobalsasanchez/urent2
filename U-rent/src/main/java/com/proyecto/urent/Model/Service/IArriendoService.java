package com.proyecto.urent.Model.Service;


import com.proyecto.urent.Model.Entity.Arriendo;

import java.util.List;

public interface IArriendoService {

    public List<Arriendo> findAll();

    public Arriendo findById(Integer id);

    public Arriendo save(Arriendo arriendo);

    public void delete (Integer id);
}
