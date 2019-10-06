package com.proyecto.urent.Model.Dao;

import com.proyecto.urent.Model.Entity.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPropiedadDao extends JpaRepository<Propiedad, Integer> {
}
