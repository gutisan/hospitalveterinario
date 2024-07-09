package com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios;

import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MascotaRep extends JpaRepository<Mascota, UUID>{
    
}
