package com.proyecto.urent.Model.Dao;

import com.proyecto.urent.Model.Entity.Arrendador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArrendadorDao extends JpaRepository<Arrendador, Integer> {
}
