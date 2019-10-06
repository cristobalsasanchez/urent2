package com.proyecto.urent.Model.Service.Impl;

import com.proyecto.urent.Model.Dao.IDistanciaDao;
import com.proyecto.urent.Model.Entity.Distancia;
import com.proyecto.urent.Model.Service.IDistanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DistanciaServiceImpl implements IDistanciaService {
    @Autowired
    private IDistanciaDao distanciaDao;

    @Override
    public List<Distancia> findAll(){
        return distanciaDao.findAll();
    }

    @Override
    @Transactional
    public Distancia findById(Integer id){
        return distanciaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Distancia save(Distancia distancia){
        return distanciaDao.save(distancia);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        distanciaDao.deleteById(id);
    }
}
