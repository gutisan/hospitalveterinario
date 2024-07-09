package com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;

import java.util.UUID;

public interface IngresoRep extends JpaRepository<Ingreso, UUID>{

    
}
