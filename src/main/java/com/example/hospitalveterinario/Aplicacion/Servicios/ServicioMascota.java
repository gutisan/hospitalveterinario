package com.example.hospitalveterinario.Aplicacion.Servicios;

import org.springframework.stereotype.Service;
import com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios.MascotaRep;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;

import java.util.List;
import java.util.UUID;

public class ServicioMascota {
    private final MascotaRep mascotaRep;

    public ServicioMascota(MascotaRep mascotaRep) {
        this.mascotaRep = mascotaRep;
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRep.save(mascota);
    }

    public Mascota buscarMascota(UUID id) {
        return mascotaRep.findById(id).orElseThrow(()-> new RuntimeException("Mascota no encontrada"));
    }

    public void bajaMascota(UUID id) {
        Mascota mascota = buscarMascota(id);
        //ver que es lo que hay que hacer con la baja de las mascotas.
        mascotaRep.save(mascota);
    }
}
