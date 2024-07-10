package com.example.hospitalveterinario.Infraestructura.persistencia.entidad;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity

/**
 * Representa un ingreso en el hospital veterinario.
 */
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;

    @Enumerated(EnumType.STRING)
    private EstadoIngreso estado = EstadoIngreso.ALTA;

    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;

    private String dniRegistrador;

    // Getters and Setters

    /**
     * Obtiene el ID del ingreso.
     *
     * @return El ID del ingreso.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del ingreso.
     *
     * @param id El ID del ingreso.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de ingreso del ingreso.
     *
     * @return La fecha de ingreso del ingreso.
     */
    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso del ingreso.
     *
     * @param fechaIngreso La fecha de ingreso del ingreso.
     */
    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Obtiene la fecha de salida del ingreso.
     *
     * @return La fecha de salida del ingreso.
     */
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Establece la fecha de salida del ingreso.
     *
     * @param fechaSalida La fecha de salida del ingreso.
     */
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene el estado del ingreso.
     *
     * @return El estado del ingreso.
     */
    public EstadoIngreso getEstado() {
        return estado;
    }

    /**
     * Establece el estado del ingreso.
     *
     * @param estado El estado del ingreso.
     */
    public void setEstado(EstadoIngreso estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la mascota asociada al ingreso.
     *
     * @return La mascota asociada al ingreso.
     */
    public Mascota getMascota() {
        return mascota;
    }

    /**
     * Establece la mascota asociada al ingreso.
     *
     * @param mascota La mascota asociada al ingreso.
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /**
     * Obtiene el DNI del registrador del ingreso.
     *
     * @return El DNI del registrador del ingreso.
     */
    public String getDniRegistrador() {
        return dniRegistrador;
    }

    /**
     * Establece el DNI del registrador del ingreso.
     *
     * @param dniRegistrador El DNI del registrador del ingreso.
     */
    public void setDniRegistrador(String dniRegistrador) {
        this.dniRegistrador = dniRegistrador;
    }

}