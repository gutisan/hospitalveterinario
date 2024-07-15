package com.example.hospitalveterinario.Infraestructura.rest;

import com.example.hospitalveterinario.Aplicacion.Servicios.ServicioIngreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IngresoControllerTest {

    @Mock
    private ServicioIngreso servicioIngreso;

    @InjectMocks
    private IngresoController ingresoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerIngresos_ingresosVacios() {
        // Arrange
        when(servicioIngreso.obtenerIngresos()).thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<List<Ingreso>> response = ingresoController.obtenerIngresos();

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(servicioIngreso, times(1)).obtenerIngresos();
    }

    @Test
    void obtenerIngresos_ingresosNoVacios() {
        // Arrange
        List<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(new Ingreso());
        ingresos.add(new Ingreso());
        when(servicioIngreso.obtenerIngresos()).thenReturn(ingresos);

        // Act
        ResponseEntity<List<Ingreso>> response = ingresoController.obtenerIngresos();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ingresos, response.getBody());
        verify(servicioIngreso, times(1)).obtenerIngresos();
    }

    @Test
    void crearIngreso() {
        // Arrange
        Ingreso ingreso = new Ingreso();
        when(servicioIngreso.crearIngreso(ingreso)).thenReturn(ingreso);

        // Act
        ResponseEntity<Ingreso> response = ingresoController.crearIngreso(ingreso);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(ingreso, response.getBody());
        verify(servicioIngreso, times(1)).crearIngreso(ingreso);
    }

    @Test
    void actualizarIngreso_ingresoExistente() {
        // Arrange
        Long idMascota = 1L;
        Long idIngreso = 1L;
        Ingreso ingreso = new Ingreso();
        when(servicioIngreso.actualizarIngreso(idIngreso, idMascota, ingreso)).thenReturn(ingreso);

        // Act
        ResponseEntity<Ingreso> response = ingresoController.actualizarIngreso(idMascota, idIngreso, ingreso);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ingreso, response.getBody());
        verify(servicioIngreso, times(1)).actualizarIngreso(idIngreso, idMascota, ingreso);
    }

    @Test
    void actualizarIngreso_ingresoNoExistente() {
        // Arrange
        Long idMascota = 1L;
        Long idIngreso = 1L;
        Ingreso ingreso = new Ingreso();
        when(servicioIngreso.actualizarIngreso(idIngreso, idMascota, ingreso)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<Ingreso> response = ingresoController.actualizarIngreso(idMascota, idIngreso, ingreso);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(servicioIngreso, times(1)).actualizarIngreso(idIngreso, idMascota, ingreso);
    }

    @Test
    void anularIngreso_ingresoExistente() {
        // Arrange
        Long idIngreso = 1L;

        // Act
        ResponseEntity<Void> response = ingresoController.anularIngreso(idIngreso);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(servicioIngreso, times(1)).anularIngreso(idIngreso);
    }

    @Test
    void anularIngreso_ingresoNoExistente() {
        // Arrange
        Long idIngreso = 1L;
        doThrow(new RuntimeException()).when(servicioIngreso).anularIngreso(idIngreso);

        // Act
        ResponseEntity<Void> response = ingresoController.anularIngreso(idIngreso);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(servicioIngreso, times(1)).anularIngreso(idIngreso);
    }
}