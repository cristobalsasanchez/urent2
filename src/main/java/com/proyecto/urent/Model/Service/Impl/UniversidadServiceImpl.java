package com.proyecto.urent.Model.Service.Impl;

import com.proyecto.urent.Model.Dao.IUniversidadDao;
import com.proyecto.urent.Model.Entity.Universidad;
import com.proyecto.urent.Model.Service.IUniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UniversidadServiceImpl implements IUniversidadService {

    @Autowired
    private IUniversidadDao universidadDao;

    @Override
    public List<Universidad> findAll(){
        return universidadDao.findAll();
    }

    @Override
    @Transactional
    public Universidad findById(Integer id){
        return universidadDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Universidad save(Universidad universidad){
        return universidadDao.save(universidad);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        universidadDao.deleteById(id);
    }
}
