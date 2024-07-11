-- Crear tabla mascota
CREATE TABLE mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    activo BOOLEAN NOT NULL,
    codigo_identificacion VARCHAR(100) NOT NULL,
    dni_responsable VARCHAR(20) NOT NULL,
    edad INT,
    especie VARCHAR(50) NOT NULL,
    raza VARCHAR(50)
);

-- Crear tabla ingreso
CREATE TABLE ingreso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dni_registrador VARCHAR(20) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha_ingreso TIMESTAMP NOT NULL,
    fecha_salida TIMESTAMP,
    mascota_id BIGINT NOT NULL,

    CONSTRAINT fk_ingreso_mascota
        FOREIGN KEY (mascota_id) REFERENCES mascota(id)
);