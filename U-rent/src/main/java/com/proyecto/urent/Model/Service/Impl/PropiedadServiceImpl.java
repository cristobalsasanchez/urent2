package com.proyecto.urent.Model.Service.Impl;

import com.proyecto.urent.Model.Dao.IPropiedadDao;
import com.proyecto.urent.Model.Entity.Propiedad;
import com.proyecto.urent.Model.Service.IPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PropiedadServiceImpl implements IPropiedadService {
    @Autowired
    private IPropiedadDao propiedadDao;

    @Override
    public List<Propiedad> findAll(){
        return propiedadDao.findAll();
    }

    @Override
    @Transactional
    public Propiedad findById(Integer id){
        return propiedadDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Propiedad save(Propiedad propiedad){
        return propiedadDao.save(propiedad);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        propiedadDao.deleteById(id);
    }
}
