package com.example.hospitalveterinario.Aplicacion.Servicios;

import org.springframework.stereotype.Service;
import com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios.IngresoRep;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.EstadoIngreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;

import java.util.List;
import java.util.UUID;

@Service
public class ServicioIngreso {
    private final IngresoRep ingresoRep;

    public ServicioIngreso(IngresoRep ingresoRep) {
        this.ingresoRep = ingresoRep;
    }

    public List <Ingreso> obtenerIngresos() {
        return ingresoRep.findAll();
    }

    public Ingreso crearIngreso(Ingreso ingreso) {
        return ingresoRep.save(ingreso);
    }

    public Ingreso actualizarIngreso(UUID id, Ingreso ingreso) {
        return ingresoRep.save(ingreso);
                       
    }

    public void anularIngreso(UUID id) {
        Ingreso ingreso = ingresoRep.findById(id).orElseThrow(() -> new RuntimeException("Ingreso no encontrado"));
        ingreso.setEstado(EstadoIngreso.ANULADO);
        ingresoRep.save(ingreso);
           
    }

    public List<Ingreso> obtenerIngresosPorMascota(UUID mascotaId) {
        return ingresoRep.buscarMascota(mascotaId);
    }

}
