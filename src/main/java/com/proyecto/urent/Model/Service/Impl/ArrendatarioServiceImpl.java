package com.proyecto.urent.Model.Service.Impl;


import com.proyecto.urent.Model.Dao.IArrendatarioDao;
import com.proyecto.urent.Model.Entity.Arrendatario;
import com.proyecto.urent.Model.Service.IArrendatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArrendatarioServiceImpl implements IArrendatarioService {

    @Autowired
    private IArrendatarioDao arrendatarioDao;

    @Override
    public List<Arrendatario> findAll(){
        return arrendatarioDao.findAll();
    }

    @Override
    @Transactional
    public Arrendatario findById(Integer id){
        return arrendatarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Arrendatario save(Arrendatario arrendatario){
        return arrendatarioDao.save(arrendatario);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        arrendatarioDao.deleteById(id);
    }
}
