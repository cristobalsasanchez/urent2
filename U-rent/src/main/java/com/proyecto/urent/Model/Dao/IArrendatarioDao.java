package com.proyecto.urent.Model.Dao;

import com.proyecto.urent.Model.Entity.Arrendatario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArrendatarioDao extends JpaRepository<Arrendatario, Integer> {
}
