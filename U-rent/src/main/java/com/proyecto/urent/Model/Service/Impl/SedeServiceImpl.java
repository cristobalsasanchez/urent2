package com.proyecto.urent.Model.Service.Impl;

import com.proyecto.urent.Model.Dao.ISedeDao;
import com.proyecto.urent.Model.Entity.Sede;
import com.proyecto.urent.Model.Service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SedeServiceImpl implements ISedeService {

    @Autowired
    private ISedeDao sedeDao;

    @Override
    public List<Sede> findAll(){
        return sedeDao.findAll();
    }

    @Override
    @Transactional
    public Sede findById(Integer id){
        return sedeDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Sede save(Sede sede){
        return sedeDao.save(sede);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        sedeDao.deleteById(id);
    }
}
