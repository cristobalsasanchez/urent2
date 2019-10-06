package com.proyecto.urent.Model.Service;

import com.proyecto.urent.Model.Entity.Distancia;
import java.util.List;

public interface IDistanciaService {
    public List<Distancia> findAll();

    public Distancia findById(Integer id);

    public Distancia save(Distancia distancia);

    public void delete (Integer id);
}
