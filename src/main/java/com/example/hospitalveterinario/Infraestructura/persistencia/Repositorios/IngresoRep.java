package com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;

import java.util.List;
import java.util.UUID;

/**
 * La interfaz IngresoRep es una interfaz de repositorio para gestionar
 * entidades Ingreso.
 * Extiende la interfaz JpaRepository, proporcionando operaciones CRUD para
 * entidades Ingreso.
 */
public interface IngresoRep extends JpaRepository<Ingreso, UUID> {

    /**
     * Recupera una lista de entidades Ingreso asociadas con un mascotaId
     * específico.
     *
     * @param mascotaId el UUID de la mascota
     * @return una lista de entidades Ingreso asociadas con el mascotaId
     */
    @Query("SELECT i FROM Ingreso i WHERE i.mascota.id = :mascotaId")
    List<Ingreso> buscarMascota(@Param("mascotaId") UUID mascotaId);
}
