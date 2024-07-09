package com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; 
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;

import java.util.List;
import java.util.UUID;

public interface IngresoRep extends JpaRepository<Ingreso, UUID>{
    @Query ("SELECT i FROM Ingreso i WHERE i.mascota.id = :mascotaId")
    List<Ingreso> buscarMascota(@Param ("mascotaId") UUID mascotaId);
}
