package com.example.hospitalveterinario;

import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Mascota;
import com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios.MascotaRep;
import com.example.hospitalveterinario.Aplicacion.Servicios.ServicioMascota;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Esta clase contiene pruebas unitarias para la clase ServicioMascota.
 */
@SpringBootTest
public class ServicioMascotaTest {
    @Autowired
    private ServicioMascota servicioMascota;

    @MockBean
    private MascotaRep mascotaRep;

    /**
     * Caso de prueba para obtener una Mascota por su ID.
     */
    @Test
    void testObtenerMascotaPorId() {
        Mascota mascota = new Mascota();
        mascota.setId(UUID.randomUUID());

        Mockito.when(mascotaRep.findById(mascota.getId())).thenReturn(Optional.of(mascota));

        Mascota mascotaEncontrada = servicioMascota.buscarMascota(mascota.getId());

        assertEquals(mascota.getId(), mascotaEncontrada.getId());
    }

    /**
     * Caso de prueba para obtener una Mascota por su ID cuando no se encuentra.
     */
    @Test
    void testObtenerMascotaPorIdNoEncontrado() {
        Mascota mascota = new Mascota();
        mascota.setId(UUID.randomUUID());

        Mockito.when(mascotaRep.findById(mascota.getId())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> servicioMascota.buscarMascota(mascota.getId()));
    }
}
