package com.proyecto.urent.Model.Dao;


import com.proyecto.urent.Model.Entity.Arriendo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArriendoDao extends JpaRepository<Arriendo, Integer> {
}
