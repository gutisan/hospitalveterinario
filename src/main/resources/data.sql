INSERT INTO MASCOTA (especie, raza, edad, codigo_identificacion, dni_responsable, activo) VALUES 
('Perro', 'Labrador', 5, '12345', '11111111A', true),
('Gato', 'Siamés', 3, '67890', '22222222B', true);

INSERT INTO INGRESO (fecha_ingreso, fecha_salida, estado, mascota_id, dni_registrador) VALUES 
(CURRENT_TIMESTAMP, NULL, 'ALTA', 1, '11111111A'),
(CURRENT_TIMESTAMP, NULL, 'ALTA', 2, '22222222B');