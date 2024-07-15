package com.example.hospitalveterinario.Aplicacion.Servicios;

import com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios.MascotaRep;
import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicioMascotaTest {

    @Mock
    private MascotaRep mascotaRep;

    @InjectMocks
    private ServicioMascota servicioMascota;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarMascota() {
        // Arrange
        Mascota mascota = new Mascota();
        when(mascotaRep.save(mascota)).thenReturn(mascota);

        // Act
        Mascota result = servicioMascota.guardarMascota(mascota);

        // Assert
        assertEquals(mascota, result);
        verify(mascotaRep, times(1)).save(mascota);
    }

    @Test
    void buscarMascota() {
        // Arrange
        Long id = 1L;
        Mascota mascota = new Mascota();
        mascota.setId(id);
        mascota.setActivo(true);
        when(mascotaRep.findById(id)).thenReturn(Optional.of(mascota));

        // Act
        Mascota result = servicioMascota.buscarMascota(id);

        // Assert
        assertEquals(mascota, result);
        verify(mascotaRep, times(1)).findById(id);
    }

    @Test
    void buscarMascota_mascotaNoEncontrada() {
        // Arrange
        Long id = 1L;
        when(mascotaRep.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> servicioMascota.buscarMascota(id));
        verify(mascotaRep, times(1)).findById(id);
    }

    @Test
    void bajaMascota() {
        // Arrange
        Long id = 1L;
        Mascota mascota = new Mascota();
        mascota.setId(id);
        mascota.setActivo(true);
        when(mascotaRep.findById(id)).thenReturn(Optional.of(mascota));
        when(mascotaRep.save(mascota)).thenReturn(mascota);

        // Act
        servicioMascota.bajaMascota(id);

        // Assert
        assertFalse(mascota.getActivo());
        verify(mascotaRep, times(1)).findById(id);
        verify(mascotaRep, times(1)).save(mascota);
    }

    @Test
    void listarMascotas() {
        // Arrange
        List<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota());
        mascotas.add(new Mascota());
        when(mascotaRep.findByActivo(true)).thenReturn(mascotas);

        // Act
        List<Mascota> result = servicioMascota.listarMascotas();

        // Assert
        assertEquals(2, result.size());
        verify(mascotaRep, times(1)).findByActivo(true);
    }
}