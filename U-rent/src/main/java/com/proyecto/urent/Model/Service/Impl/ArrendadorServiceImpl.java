package com.proyecto.urent.Model.Service.Impl;

import com.proyecto.urent.Model.Dao.IArrendadorDao;
import com.proyecto.urent.Model.Entity.Arrendador;
import com.proyecto.urent.Model.Service.IArrendadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArrendadorServiceImpl implements IArrendadorService {

    @Autowired
    private IArrendadorDao arrendadorDao;

    @Override
    public List<Arrendador> findAll(){
        return arrendadorDao.findAll();
    }

    @Override
    @Transactional
    public Arrendador findById(Integer id){
        return arrendadorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Arrendador save(Arrendador arrendador){
        return arrendadorDao.save(arrendador);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        arrendadorDao.deleteById(id);
    }
}
