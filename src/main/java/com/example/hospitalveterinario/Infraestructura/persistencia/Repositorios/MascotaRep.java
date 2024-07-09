package com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios;

import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;


public interface MascotaRep extends JpaRepository<Mascota, UUID>{
    List<Mascota> findByActivo(Boolean activo);
}
