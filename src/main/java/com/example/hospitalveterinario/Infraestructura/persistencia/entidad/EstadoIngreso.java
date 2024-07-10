/**
 * El enum EstadoIngreso representa los diferentes estados de un ingreso en un hospital veterinario.
 * Puede tener los siguientes estados:
 * - ALTA: El ingreso ha sido dado de alta.
 * - ANULADO: El ingreso ha sido cancelado.
 * - HOSPITALIZACION: El ingreso se encuentra actualmente en hospitalización.
 * - FINALIZADO: El ingreso ha sido completado.
 */
package com.example.hospitalveterinario.Infraestructura.persistencia.entidad;

public enum EstadoIngreso {
    ALTA, ANULADO, HOSPITALIZACION, FINALIZADO
}
