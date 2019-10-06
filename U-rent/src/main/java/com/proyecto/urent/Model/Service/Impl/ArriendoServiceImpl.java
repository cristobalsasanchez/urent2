package com.proyecto.urent.Model.Service.Impl;

import com.proyecto.urent.Model.Dao.IArriendoDao;
import com.proyecto.urent.Model.Entity.Arriendo;
import com.proyecto.urent.Model.Service.IArriendoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArriendoServiceImpl implements IArriendoService {

    @Autowired
    private IArriendoDao arriendoDao;

    @Override
    public List<Arriendo> findAll(){
        return arriendoDao.findAll();
    }

    @Override
    @Transactional
    public Arriendo findById(Integer id){
        return arriendoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Arriendo save(Arriendo arriendo){
        return arriendoDao.save(arriendo);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        arriendoDao.deleteById(id);
    }
}
