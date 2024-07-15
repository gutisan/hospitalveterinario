package com.example.hospitalveterinario.Infraestructura.rest;

import com.example.hospitalveterinario.Aplicacion.Servicios.ServicioIngreso;
import com.example.hospitalveterinario.Aplicacion.Servicios.ServicioMascota;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class MascotaControllerTest {

    @Mock
    private ServicioMascota servicioMascota;

    @Mock
    private ServicioIngreso servicioIngreso;

    @InjectMocks
    private MascotaController mascotaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarMascota() {
        // Arrange
        Mascota mascota = new Mascota();
        when(servicioMascota.guardarMascota(mascota)).thenReturn(mascota);

        // Act
        ResponseEntity<Mascota> response = mascotaController.guardarMascota(mascota);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mascota, response.getBody());
        verify(servicioMascota, times(1)).guardarMascota(mascota);
    }

    @Test
    void buscarMascota_mascotaEncontrada() {
        // Arrange
        Long idMascota = 1L;
        Mascota mascota = new Mascota();
        when(servicioMascota.buscarMascota(idMascota)).thenReturn(mascota);

        // Act
        ResponseEntity<Mascota> response = mascotaController.buscarMascota(idMascota);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mascota, response.getBody());
        verify(servicioMascota, times(1)).buscarMascota(idMascota);
    }

    @Test
    void buscarMascota_mascotaNoEncontrada() {
        // Arrange
        Long idMascota = 1L;
        when(servicioMascota.buscarMascota(idMascota)).thenReturn(null);

        // Act
        ResponseEntity<Mascota> response = mascotaController.buscarMascota(idMascota);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(servicioMascota, times(1)).buscarMascota(idMascota);
    }

    @Test
    void bajaMascota_mascotaEncontrada() {
        // Arrange
        Long idMascota = 1L;
        Mascota mascota = new Mascota();
        when(servicioMascota.buscarMascota(idMascota)).thenReturn(mascota);

        // Act
        ResponseEntity<Void> response = mascotaController.bajaMascota(idMascota);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(servicioMascota, times(1)).buscarMascota(idMascota);
        verify(servicioMascota, times(1)).bajaMascota(idMascota);
    }

    @Test
    void bajaMascota_mascotaNoEncontrada() {
        // Arrange
        Long idMascota = 1L;
        when(servicioMascota.buscarMascota(idMascota)).thenReturn(null);

        // Act
        ResponseEntity<Void> response = mascotaController.bajaMascota(idMascota);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(servicioMascota, times(1)).buscarMascota(idMascota);
        verify(servicioMascota, never()).bajaMascota(idMascota);
    }

    @Test
    void obtenerIngresosPorMascota_ingresosNoVacios() {
        // Arrange
        Long idMascota = 1L;
        List<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(new Ingreso());
        ingresos.add(new Ingreso());
        when(servicioIngreso.obtenerIngresosPorMascota(idMascota)).thenReturn(ingresos);

        // Act
        ResponseEntity<List<Ingreso>> response = mascotaController.obtenerIngresosPorMascota(idMascota);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(ingresos, response.getBody());
        verify(servicioIngreso, times(1)).obtenerIngresosPorMascota(idMascota);
    }

}