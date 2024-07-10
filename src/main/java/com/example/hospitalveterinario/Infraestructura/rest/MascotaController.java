package com.example.hospitalveterinario.Infraestructura.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hospitalveterinario.Aplicacion.Servicios.ServicioMascota;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;

import org.springframework.http.HttpStatus;

/**
 * Controlador REST para la entidad Mascota.
 */
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
        Mascota nuevaMascota = servicioMascota.guardarMascota(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }

    /**
     * Endpoint para buscar un objeto Mascota por su ID.
     * 
     * @param idMascota El ID del objeto Mascota a buscar.
     * @return El ResponseEntity con el objeto Mascota encontrado.
     */
    @GetMapping("/{idMascota}")
    public ResponseEntity<Mascota> buscarMascota(@PathVariable Long idMascota) {
        Mascota mascota = servicioMascota.buscarMascota(idMascota);
        if (mascota != null) {
            return ResponseEntity.ok(mascota);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Endpoint para eliminar un objeto Mascota por su ID.
     * 
     * @param idMascota El ID del objeto Mascota a eliminar.
     * @return El ResponseEntity que indica el éxito de la eliminación.
     */
    @DeleteMapping("/{idMascota}")
    public ResponseEntity<Void> bajaMascota(@PathVariable Long idMascota) {
        Mascota mascota = servicioMascota.buscarMascota(idMascota);
        if (mascota != null) {
            servicioMascota.bajaMascota(idMascota);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
