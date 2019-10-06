package com.proyecto.urent.Model.Service.Impl;

import com.proyecto.urent.Model.Dao.IInmuebleDao;
import com.proyecto.urent.Model.Entity.Inmueble;
import com.proyecto.urent.Model.Service.IInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InmuebleServiceImpl implements IInmuebleService {
    @Autowired
    private IInmuebleDao inmuebleDao;

    @Override
    public List<Inmueble> findAll(){
        return inmuebleDao.findAll();
    }

    @Override
    @Transactional
    public Inmueble findById(Integer id){
        return inmuebleDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Inmueble save(Inmueble inmueble){
        return inmuebleDao.save(inmueble);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        inmuebleDao.deleteById(id);
    }
}
