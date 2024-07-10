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

    /**
     * Constructor para MascotaController.
     * 
     * @param servicioMascota El servicio para gestionar objetos Mascota.
     */
    public MascotaController(ServicioMascota servicioMascota) {
        this.servicioMascota = servicioMascota;
    }

    /**
     * Endpoint para guardar un objeto Mascota.
     * 
     * @param mascota El objeto Mascota a guardar.
     * @return El ResponseEntity con el objeto Mascota guardado.
     */
    @PostMapping
    public ResponseEntity<Mascota> guardarMascota(@RequestBody Mascota mascota) {
        return ResponseEntity.ok(servicioMascota.guardarMascota(mascota));
    }

    /**
     * Endpoint para buscar un objeto Mascota por su ID.
     * 
     * @param idMascota El ID del objeto Mascota a buscar.
     * @return El ResponseEntity con el objeto Mascota encontrado.
     */
    @GetMapping("/{idMascota}")
    public ResponseEntity<Mascota> buscarMascota(@PathVariable UUID idMascota) {
        return ResponseEntity.ok(servicioMascota.buscarMascota(idMascota));
    }

    /**
     * Endpoint para eliminar un objeto Mascota por su ID.
     * 
     * @param idMascota El ID del objeto Mascota a eliminar.
     * @return El ResponseEntity que indica el éxito de la eliminación.
     */
    @DeleteMapping("/{idMascota}")
    public ResponseEntity<Void> bajaMascota(@PathVariable UUID idMascota) {
        servicioMascota.bajaMascota(idMascota);
        return ResponseEntity.noContent().build();
    }
}
