package com.proyecto.urent.Model.Dao;

import com.proyecto.urent.Model.Entity.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUniversidadDao extends JpaRepository<Universidad, Integer> {
}
