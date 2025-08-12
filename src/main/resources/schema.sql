-- Schema SQL para la aplicación de prueba técnica
-- Este archivo se ejecutará automáticamente al iniciar la aplicación

-- Tabla de Alumnos
CREATE TABLE IF NOT EXISTS Alumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(150),
    fecha_nacimiento DATE
);

-- Tabla de Materias
CREATE TABLE IF NOT EXISTS Materia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    codigo VARCHAR(20),
    creditos INT
);

-- Tabla de Notas
CREATE TABLE IF NOT EXISTS Nota (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(3,1),
    fecha_registro DATE,
    id_alumno INT,
    id_materia INT,
    FOREIGN KEY (id_alumno) REFERENCES Alumno(id),
    FOREIGN KEY (id_materia) REFERENCES Materia(id)
);

-- Índices para mejorar el rendimiento
CREATE INDEX IF NOT EXISTS idx_alumno_email ON Alumno(email);
CREATE INDEX IF NOT EXISTS idx_materia_codigo ON Materia(codigo);
CREATE INDEX IF NOT EXISTS idx_nota_alumno ON Nota(id_alumno);
CREATE INDEX IF NOT EXISTS idx_nota_materia ON Nota(id_materia);
CREATE INDEX IF NOT EXISTS idx_nota_fecha ON Nota(fecha_registro);
