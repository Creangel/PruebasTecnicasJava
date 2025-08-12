-- Datos de ejemplo para la aplicación de prueba técnica
-- Este archivo se ejecutará automáticamente al iniciar la aplicación

-- Insertar materias de ejemplo
INSERT INTO Materia (nombre, codigo, creditos) VALUES 
('Matemáticas', 'MAT101', 4),
('Física', 'FIS101', 4),
('Programación Java', 'JAV101', 3),
('Base de Datos', 'BD101', 3),
('Inglés Técnico', 'ING101', 2)
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre);

-- Insertar alumnos de ejemplo
INSERT INTO Alumno (nombre, apellido, email, fecha_nacimiento) VALUES 
('Juan', 'Pérez', 'juan.perez@email.com', '2000-05-15'),
('María', 'García', 'maria.garcia@email.com', '1999-08-22'),
('Carlos', 'López', 'carlos.lopez@email.com', '2001-03-10'),
('Ana', 'Martínez', 'ana.martinez@email.com', '2000-11-30'),
('Luis', 'Rodríguez', 'luis.rodriguez@email.com', '1999-12-05')
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre);

-- Insertar notas de ejemplo
INSERT INTO Nota (valor, fecha_registro, id_alumno, id_materia) VALUES 
(8.5, '2024-01-15', 1, 1),
(7.8, '2024-01-16', 1, 2),
(9.2, '2024-01-17', 1, 3),
(8.0, '2024-01-15', 2, 1),
(9.5, '2024-01-16', 2, 2),
(8.8, '2024-01-17', 2, 3),
(7.5, '2024-01-15', 3, 1),
(8.2, '2024-01-16', 3, 2),
(9.0, '2024-01-17', 3, 3),
(8.7, '2024-01-15', 4, 1),
(7.9, '2024-01-16', 4, 2),
(8.4, '2024-01-17', 4, 3),
(9.1, '2024-01-15', 5, 1),
(8.6, '2024-01-16', 5, 2),
(7.7, '2024-01-17', 5, 3)
ON DUPLICATE KEY UPDATE valor = VALUES(valor);
