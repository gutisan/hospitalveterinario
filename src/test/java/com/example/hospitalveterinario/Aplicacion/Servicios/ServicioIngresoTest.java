package com.example.hospitalveterinario.Aplicacion.Servicios;

import com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios.IngresoRep;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.EstadoIngreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicioIngresoTest {

    @Mock
    private IngresoRep ingresoRep;

    @InjectMocks
    private ServicioIngreso servicioIngreso;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerIngresos() {
        // Arrange
        List<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(new Ingreso());
        ingresos.add(new Ingreso());
        when(ingresoRep.findAll()).thenReturn(ingresos);

        // Act
        List<Ingreso> result = servicioIngreso.obtenerIngresos();

        // Assert
        assertEquals(2, result.size());
        verify(ingresoRep, times(1)).findAll();
    }

    @Test
    void crearIngreso() {
        // Arrange
        Ingreso ingreso = new Ingreso();
        when(ingresoRep.save(ingreso)).thenReturn(ingreso);

        // Act
        Ingreso result = servicioIngreso.crearIngreso(ingreso);

        // Assert
        assertEquals(ingreso, result);
        verify(ingresoRep, times(1)).save(ingreso);
    }

    @Test
    void actualizarIngreso() {
        // Arrange
        Long idIngreso = 1L;
        Long idMascota = 1L;
        Ingreso ingresoActualizado = new Ingreso();
        ingresoActualizado.setEstado(EstadoIngreso.FINALIZADO);
        ingresoActualizado.setFechaSalida(LocalDateTime.now());

        Ingreso ingreso = new Ingreso();
        ingreso.setId(idIngreso);
        Mascota mascota = new Mascota();
        mascota.setId(idMascota);
        ingreso.setMascota(mascota);

        when(ingresoRep.findById(idIngreso)).thenReturn(Optional.of(ingreso));
        when(ingresoRep.save(ingreso)).thenReturn(ingreso);

        // Act
        Ingreso result = servicioIngreso.actualizarIngreso(idIngreso, idMascota, ingresoActualizado);

        // Assert
        assertEquals(ingreso, result);
        assertEquals(EstadoIngreso.FINALIZADO, ingreso.getEstado());
        assertNotNull(ingreso.getFechaSalida());
        verify(ingresoRep, times(1)).findById(idIngreso);
        verify(ingresoRep, times(1)).save(ingreso);
    }

    @Test
    void anularIngreso() {
        // Arrange
        Long id = 1L;
        Ingreso ingreso = new Ingreso();
        ingreso.setId(id);

        when(ingresoRep.findById(id)).thenReturn(Optional.of(ingreso));
        when(ingresoRep.save(ingreso)).thenReturn(ingreso);

        // Act
        servicioIngreso.anularIngreso(id);

        // Assert
        assertEquals(EstadoIngreso.ANULADO, ingreso.getEstado());
        verify(ingresoRep, times(1)).findById(id);
        verify(ingresoRep, times(1)).save(ingreso);
    }

    @Test
    void obtenerIngresosPorMascota() {
        // Arrange
        Long mascotaId = 1L;
        List<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(new Ingreso());
        ingresos.add(new Ingreso());
        when(ingresoRep.buscarMascota(mascotaId)).thenReturn(ingresos);

        // Act
        List<Ingreso> result = servicioIngreso.obtenerIngresosPorMascota(mascotaId);

        // Assert
        assertEquals(2, result.size());
        verify(ingresoRep, times(1)).buscarMascota(mascotaId);
    }

    @Test
    void eliminarIngreso() {
        // Arrange
        Long id = 1L;

        // Act
        servicioIngreso.eliminarIngreso(id);

        // Assert
        verify(ingresoRep, times(1)).deleteById(id);
    }
}