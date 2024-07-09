package com.example.hospitalveterinario.Infraestructura.rest;

import java.util.UUID;

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
    
    @GetMapping("/{idMascota}")
    public ResponseEntity<Mascota> buscarMascota(@PathVariable UUID idMascota) {
        return ResponseEntity.ok(servicioMascota.buscarMascota(idMascota));
    }

    @DeleteMapping("/{idMascota}")
    public ResponseEntity<Void> bajaMascota(@PathVariable UUID idMascota) {
        servicioMascota.bajaMascota(idMascota);
        return ResponseEntity.noContent().build();
    }

}
