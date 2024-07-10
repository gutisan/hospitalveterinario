package com.example.hospitalveterinario.Aplicacion.Servicios;

import org.springframework.stereotype.Service;
import com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios.MascotaRep;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;

import java.util.List;
import java.util.UUID;

@Service
public class ServicioMascota {
    private final MascotaRep mascotaRep;

    /**
     * Constructor para la clase ServicioMascota.
     * 
     * @param mascotaRep el repositorio MascotaRep
     */
    public ServicioMascota(MascotaRep mascotaRep) {
        this.mascotaRep = mascotaRep;
    }

    /**
     * Guarda un objeto Mascota en el repositorio.
     * 
     * @param mascota el objeto Mascota a guardar
     * @return el objeto Mascota guardado
     */
    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRep.save(mascota);
    }

    /**
     * Recupera un objeto Mascota del repositorio basado en su ID.
     * 
     * @param id el ID del objeto Mascota a recuperar
     * @return el objeto Mascota recuperado
     * @throws RuntimeException si el objeto Mascota no se encuentra
     */
    public Mascota buscarMascota(UUID id) {
        return mascotaRep.findById(id)
                .filter(Mascota::getActivo)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
    }

    /**
     * Establece la propiedad "activo" de un objeto Mascota en false, indicando que
     * ya no está activo.
     * 
     * @param id el ID del objeto Mascota a desactivar
     */
    public void bajaMascota(UUID id) {
        Mascota mascota = buscarMascota(id);
        mascota.setActivo(false);
        mascotaRep.save(mascota);
    }

    /**
     * Recupera una lista de objetos Mascota activos del repositorio.
     * 
     * @return una lista de objetos Mascota activos
     */
    public List<Mascota> listarMascotas() {
        return mascotaRep.findByActivo(true);
    }

}
