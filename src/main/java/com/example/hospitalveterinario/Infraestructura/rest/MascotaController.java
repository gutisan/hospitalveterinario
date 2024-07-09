package com.example.hospitalveterinario.Infraestructura.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hospitalveterinario.Aplicacion.Servicios.ServicioMascota;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;


@RestController
@RequestMapping("/mascota")
public class MascotaController {

    private final ServicioMascota servicioMascota;

    public MascotaController(ServicioMascota servicioMascota) {
        this.servicioMascota = servicioMascota;
    }

    @PostMapping 

    public ResponseEntity<Mascota> guardarMascota(@RequestBody Mascota mascota) {
        return ResponseEntity.ok(servicioMascota.guardarMascota(mascota));
    }
    
}
