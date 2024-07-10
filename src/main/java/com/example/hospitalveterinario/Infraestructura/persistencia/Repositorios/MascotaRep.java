package com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios;

import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Esta interfaz representa el repositorio de la entidad Mascota en la capa de
 * persistencia.
 * Extiende la interfaz JpaRepository de Spring Data JPA para obtener
 * funcionalidades de acceso a datos.
 */
public interface MascotaRep extends JpaRepository<Mascota, Long> {
    /**
     * Busca y devuelve una lista de mascotas activas.
     * 
     * @param activo el estado de activación de las mascotas a buscar
     * @return una lista de mascotas activas
     */
    List<Mascota> findByActivo(Boolean activo);
}
