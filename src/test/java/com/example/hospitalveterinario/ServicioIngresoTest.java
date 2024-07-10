package com.example.hospitalveterinario;

import com.example.hospitalveterinario.Infraestructura.persistencia.entidad.Ingreso;
import com.example.hospitalveterinario.Infraestructura.persistencia.Repositorios.IngresoRep;
import com.example.hospitalveterinario.Aplicacion.Servicios.ServicioIngreso;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Esta clase contiene pruebas unitarias para la clase ServicioIngreso.
 */
@SpringBootTest
public class ServicioIngresoTest {

    @Autowired
    private ServicioIngreso servicioIngreso;

    @MockBean
    private IngresoRep ingresoRep;

    /**
     * Caso de prueba para el método obtenerIngresos.
     * Verifica que el método devuelva la lista correcta de ingresos.
     */
    @Test
    void testObtenerIngresos() {
        List<Ingreso> ingresos = List.of(new Ingreso());
        Mockito.when(ingresoRep.findAll()).thenReturn(ingresos);

        List<Ingreso> result = servicioIngreso.obtenerIngresos();

        assertEquals(ingresos.size(), result.size());
    }

}