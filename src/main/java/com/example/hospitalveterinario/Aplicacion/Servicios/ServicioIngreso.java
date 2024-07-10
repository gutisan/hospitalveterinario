package com.example.hospitalveterinario.Aplicacion.Servicios;

import org.springframework.stereotype.Service;
import com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios.IngresoRep;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.EstadoIngreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;

import java.util.List;

@Service
public class ServicioIngreso {
    private final IngresoRep ingresoRep;

    /**
     * Constructor para ServicioIngreso.
     * 
     * @param ingresoRep El repositorio para las entidades Ingreso.
     */
    public ServicioIngreso(IngresoRep ingresoRep) {
        this.ingresoRep = ingresoRep;
    }

    /**
     * Obtiene una lista de todas las entidades Ingreso.
     * 
     * @return Una lista de entidades Ingreso.
     */
    public List<Ingreso> obtenerIngresos() {
        return ingresoRep.findAll();
    }

    /**
     * Crea una nueva entidad Ingreso.
     * 
     * @param ingreso La entidad Ingreso a crear.
     * @return La entidad Ingreso creada.
     */
    public Ingreso crearIngreso(Ingreso ingreso) {
        return ingresoRep.save(ingreso);
    }

    /**
     * Actualiza un ingreso existente en el sistema.
     *
     * @param idIngreso          El ID del ingreso a actualizar.
     * @param idMascota          El ID de la mascota asociada al ingreso.
     * @param ingresoActualizado El objeto Ingreso con los datos actualizados.
     * @return El ingreso actualizado.
     * @throws RuntimeException Si el ingreso no se encuentra o no corresponde a la
     *                          mascota especificada.
     */
    public Ingreso actualizarIngreso(Long idIngreso, Long idMascota, Ingreso ingresoActualizado) {
        Ingreso ingreso = ingresoRep.findById(idIngreso)
                .orElseThrow(() -> new RuntimeException("Ingreso no encontrado"));
        Mascota mascota = ingreso.buscarMascota();

        if (mascota == null || !mascota.getId().equals(idMascota)) {
            throw new RuntimeException("El ingreso no corresponde a la mascota especificada");
        }
        if (ingresoActualizado.getEstado() != null) {
            ingreso.setEstado(ingresoActualizado.getEstado());
        }

        if (ingresoActualizado.getFechaSalida() != null) {
            ingreso.setFechaSalida(ingresoActualizado.getFechaSalida());
        }

        return ingresoRep.save(ingreso);
    }

    /**
     * Cancela una entidad Ingreso.
     * 
     * @param id El ID de la entidad Ingreso a cancelar.
     */
    public void anularIngreso(Long id) {
        Ingreso ingreso = ingresoRep.findById(id).orElseThrow(() -> new RuntimeException("Ingreso no encontrado"));
        ingreso.setEstado(EstadoIngreso.ANULADO);
        ingresoRep.save(ingreso);
    }

    /**
     * Obtiene una lista de entidades Ingreso asociadas con una entidad Mascota
     * específica.
     * 
     * @param mascotaId El ID de la entidad Mascota.
     * @return Una lista de entidades Ingreso asociadas con la entidad Mascota.
     */
    public List<Ingreso> obtenerIngresosPorMascota(Long mascotaId) {
        return ingresoRep.buscarMascota(mascotaId);
    }

    /**
     * Elimina una entidad Ingreso existente.
     * 
     * @param id El ID de la entidad Ingreso a eliminar.
     */
    public void eliminarIngreso(Long id) {
        ingresoRep.deleteById(id);
    }
}
