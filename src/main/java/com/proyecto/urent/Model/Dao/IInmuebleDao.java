package com.proyecto.urent.Model.Dao;

import com.proyecto.urent.Model.Entity.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInmuebleDao extends JpaRepository<Inmueble, Integer> {
}
