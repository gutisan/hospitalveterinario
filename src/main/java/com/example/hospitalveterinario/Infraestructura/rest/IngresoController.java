package com.example.hospitalveterinario.Infraestructura.rest;

import org.springframework.web.bind.annotation.*;
import com.example.hospitalveterinario.Aplicacion.Servicios.ServicioIngreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/ingreso")

public class IngresoController {

    private final ServicioIngreso servicioIngreso;

    public IngresoController(ServicioIngreso servicioIngreso) {
        this.servicioIngreso = servicioIngreso;
    }

    @GetMapping

    public ResponseEntity<List<Ingreso>> obtenerIngresos(){
        List<Ingreso> ingresos = servicioIngreso.obtenerIngresos();
        return ResponseEntity.ok(ingresos);
    }


    @PostMapping

    public ResponseEntity<Ingreso> crearIngreso (@RequestBody Ingreso ingreso){
        Ingreso nuevoIngreso = servicioIngreso.crearIngreso(ingreso);
        return ResponseEntity.ok(nuevoIngreso);
    }

    @PutMapping("/{idIngreso}")

    public ResponseEntity<Ingreso> actualizarIngreso(@PathVariable UUID idIngreso, @RequestBody Ingreso ingreso){
        Ingreso ingresoActualizado = servicioIngreso.actualizarIngreso(idIngreso, ingreso);
        return ResponseEntity.ok(ingresoActualizado);
    
    }

    @DeleteMapping("/{idIngreso}")

    public ResponseEntity<Void> anularIngreso(@PathVariable UUID idIngreso){
        servicioIngreso.anularIngreso(idIngreso);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/mascota/{idMascota}")

    public ResponseEntity<List<Ingreso>> obtenerIngresosPorMascota(@PathVariable UUID idMascota){
        List<Ingreso> ingresos = servicioIngreso.obtenerIngresosPorMascota(idMascota);
        return ResponseEntity.ok(ingresos);
    }
    
}
