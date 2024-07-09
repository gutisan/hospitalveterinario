package com.example.hospitalveterinario.Aplicacion.Servicios;

import org.springframework.stereotype.Service;
import com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios.MascotaRep;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;

import java.util.List;
import java.util.UUID;

@Service
public class ServicioMascota {
    private final MascotaRep mascotaRep;

    public ServicioMascota(MascotaRep mascotaRep) {
        this.mascotaRep = mascotaRep;
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRep.save(mascota);
    }

    public Mascota buscarMascota(UUID id) {

        return mascotaRep.findById(id)
        .filter(Mascota::getActivo)
        .orElseThrow(()-> new RuntimeException("Mascota no encontrada"));
    }

    public void bajaMascota(UUID id) {
        Mascota mascota = buscarMascota(id);
        mascota.setActivo(false);
        mascotaRep.save(mascota);
    }

    public List<Mascota> listarMascotas() {
        return mascotaRep.findByActivo(true);
    }

}
