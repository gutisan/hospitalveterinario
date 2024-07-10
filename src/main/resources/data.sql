INSERT INTO MASCOTA (especie, raza, edad, codigo_identificacion, dni_responsable, activo) VALUES 
('Perro', 'Pastor Aleman', 5, '34567', '13456111A', true),
('Gato', 'Persa', 6, '45677', '22564622B', true);

INSERT INTO INGRESO (fecha_ingreso, fecha_salida, estado, mascota_id, dni_registrador) VALUES 
(CURRENT_TIMESTAMP, NULL, 'ALTA', 1, '13456111A'),
(CURRENT_TIMESTAMP, NULL, 'ALTA', 2, '22564622B');