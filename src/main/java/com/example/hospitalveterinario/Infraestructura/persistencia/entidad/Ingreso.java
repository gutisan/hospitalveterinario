package com.example.hospitalveterinario.Infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;

@Entity

public class Ingreso {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID id;
private LocalDateTime fechaIngreso;
private LocalDateTime fechaSalida;

@Enumerated(EnumType.STRING)
private EstadoIngreso estado;

@ManyToOne
@JoinColumn(name = "mascota_id", nullable = false)
private Mascota mascota;

private String dniRegistrador;


// Getters y Setters

public UUID getId() {
    return id;
}

public void setId(UUID id) {
    this.id = id;
}

public LocalDateTime getFechaIngreso() {
    return fechaIngreso;
}

public void setFechaIngreso(LocalDateTime fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
}

public LocalDateTime getFechaSalida() {
    return fechaSalida;
}

public void setFechaSalida(LocalDateTime fechaSalida) {
    this.fechaSalida = fechaSalida;
}

public EstadoIngreso getEstado() {
    return estado;
}

public void setEstado(EstadoIngreso estado) {
    this.estado = estado;
}

public Mascota getMascota() {
    return mascota;

}

public void setMascota(Mascota mascota) {
    this.mascota = mascota;
}

public String getDniRegistrador() {
    return dniRegistrador;
}

public void setDniRegistrador(String dniRegistrador) {
    this.dniRegistrador = dniRegistrador;
}

}