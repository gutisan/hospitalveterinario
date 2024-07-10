package com.example.hospitalveterinario.Infraestructura.rest;

import org.springframework.web.bind.annotation.*;
import com.example.hospitalveterinario.Aplicacion.Servicios.ServicioIngreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {

    private final ServicioIngreso servicioIngreso;

    /**
     * Constructor para IngresoController.
     * 
     * @param servicioIngreso El servicio para gestionar los ingresos.
     */
    public IngresoController(ServicioIngreso servicioIngreso) {
        this.servicioIngreso = servicioIngreso;
    }

    /**
     * Obtiene una lista de todos los ingresos.
     * 
     * @return Un ResponseEntity que contiene la lista de ingresos.
     */
    @GetMapping
    public ResponseEntity<List<Ingreso>> obtenerIngresos() {
        List<Ingreso> ingresos = servicioIngreso.obtenerIngresos();
        return ResponseEntity.ok(ingresos);
    }

    /**
     * Crea un nuevo ingreso.
     * 
     * @param ingreso El ingreso que se va a crear.
     * @return Un ResponseEntity que contiene el ingreso recién creado.
     */
    @PostMapping
    public ResponseEntity<Ingreso> crearIngreso(@RequestBody Ingreso ingreso) {
        Ingreso nuevoIngreso = servicioIngreso.crearIngreso(ingreso);
        return ResponseEntity.ok(nuevoIngreso);
    }

    /**
     * Actualiza un ingreso existente.
     * 
     * 
     * @param idIngreso El ID del ingreso que se va a actualizar.
     * 
     * @param ingreso   El objeto de ingreso actualizado.
     * @return Un ResponseEntity que contiene el ingreso actualizado.
     */
    @PutMapping("/{idMascota}/{idIngreso}")
    public ResponseEntity<Ingreso> actualizarIngreso(
            @PathVariable Long idMascota,
            @PathVariable Long idIngreso,
            @RequestBody Ingreso ingreso) {
        Ingreso ingresoActualizado = servicioIngreso.actualizarIngreso(idMascota, idIngreso, ingreso);
        return ResponseEntity.ok(ingresoActualizado);
    }

    /**
     * Elimina un ingreso.
     * 
     * @param idIngreso El ID del ingreso que se va a eliminar.
     * @return Un ResponseEntity sin contenido.
     */
    @DeleteMapping("/{idIngreso}")
    public ResponseEntity<Void> anularIngreso(@PathVariable Long idIngreso) {
        servicioIngreso.anularIngreso(idIngreso);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtiene una lista de ingresos para una mascota específica.
     * 
     * @param idMascota El ID de la mascota.
     * @return Un ResponseEntity que contiene la lista de ingresos para la mascota.
     */
    @GetMapping("/mascota/{idMascota}")
    public ResponseEntity<List<Ingreso>> obtenerIngresosPorMascota(@PathVariable Long idMascota) {
        List<Ingreso> ingresos = servicioIngreso.obtenerIngresosPorMascota(idMascota);
        return ResponseEntity.ok(ingresos);
    }
}
